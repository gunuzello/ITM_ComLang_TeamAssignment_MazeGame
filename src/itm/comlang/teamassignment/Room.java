/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ohkyounghun
 */
public class Room {

    private char[][] map; // For simple symbol-based entities
    // 간단한 심벌을 가진 엔티티들을 위한 맵
    private String[][] rawCells; // For entities that need parsing like ":"
    // ":" 같이 추가 처리가 필요한 엔티티들을 위한 셀 데이터
    private int rows;
    private int cols;

    private ArrayList<Renderable> renderables = new ArrayList<>();
    // Room 안의 엔티티 객체들을 저장하는 리스트
    // List for entity objects

    
    public Room(String filePath) {
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            // Read the first line to get row and column info
            // 첫 줄에서 행과 열의 정보를 읽음
            String[] parts = scanner.nextLine().split(",");
            rows = Integer.valueOf(parts[0]);
            cols = Integer.valueOf(parts[1]);

            // Initialize map arrays
            // 맵 배열 초기화
            map = new char[rows][cols];
            rawCells = new String[rows][cols];

            // Read and store each cell from CSV
            // CSV로부터 각 셀을 읽고 저장
            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                String[] cells = line.split(",");
                for (int j = 0; j < cols; j++) {
                    map[i][j] = cells[j].charAt(0);
                    rawCells[i][j] = cells[j];
                }
            }

            // After loading the map, scan entities
            // 맵을 모두 불러온 뒤 엔티티를 자동으로 스캔
            scanEntitiesFromMap();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // 파일 읽기 실패 시 에러 메시지 출력
        }
    }

    // Scan the map and create objects from cell content
    // 맵을 순회하면서 문자에 해당하는 엔티티 객체 생성
    private void scanEntitiesFromMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                String cell = rawCells[i][j].trim(); // Remove extra spaces
                // 공백 제거 중요
                Renderable entity = null;

                if (cell.isEmpty()) {
                    map[i][j] = ' ';
                    continue;
                }

                if (cell.charAt(0) == '@') {
                    map[i][j] = ' '; // Hero is handled in Game, not Room
                    // 히어로는 Room이 아닌 Game 클래스에서 관리됨
                }

                entity = EntityFactory.createEntity(cell, i, j);
                // 해당 문자를 통해 객체 생성

                if (entity != null) {
                    renderables.add(entity);
                    map[i][j] = entity.getSymbol(); // Overwrite with symbol if entity created
                    // 객체가 생성되면 심벌로 덮어쓰기
                }
            }
        }
    }

    // Print the room with hero icon
    // 히어로를 포함한 방 전체 출력
    public void printRoom(Hero hero) {
        // 1. Print top border
        // 상단 경계 출력
        System.out.print("+");
        for (int i = 0; i < cols; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        // 2. Print each row with left and right borders
        // 각 행을 좌우 벽과 함께 출력
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                if (hero != null && i == hero.getX() && j == hero.getY()) {
                    System.out.print("☺"); // Print hero
                    // 히어로 위치 출력
                } else {
                    System.out.print(getSymbolForRendering(map[i][j]));
                    //유니코드 출력
                }
            }
            System.out.println("|");
        }

        // 3. Print bottom border
        // 하단 경계 출력
        System.out.print("+");
        for (int i = 0; i < cols; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    // Find hero's location marked with '@'
    // '@'로 표시된 히어로 위치 찾기
    public int[] findHeroLocation() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '@') {
                    return new int[]{i, j}; // Return {x, y}
                    // 좌표 반환
                }
            }
        }
        return null; // If not found
        // 히어로가 없으면 null 반환
    }

    // Find a random empty space (used when hero position not found)
    // 빈 공간 중 하나를 무작위로 반환
    public int[] findRandomEmptySpace() {
        ArrayList<int[]> emptyspace = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == ' ') {
                    emptyspace.add(new int[]{i, j});
                    // 빈 공간 저장
                }
            }
        }
        if (emptyspace.isEmpty()) {
            return null; // No empty space
        }
        Random random = new Random();
        return emptyspace.get(random.nextInt(emptyspace.size()));
        // 랜덤한 위치 반환
        // nextInt(5) = (0 ~ 4)
    }

    // Save the current room state to a CSV file
    // 현재 방의 상태를 CSV 파일로 저장
    public void saveRoomToFile(String path) {
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.println(rows + "," + cols); // Save dimensions
            // 행과 열 정보 저장

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.print(rawCells[i][j]); //without this, we cannot load nextRoom (because of door)
                    if (j < cols - 1) { //"cols - 1" is used to skip the last column,   so that commas are added only **between** cells,   
                                        // and not **after** the final cell in each row.

                        writer.print(","); // Add comma between cells
                        // 셀 사이에 쉼표 추가
                    }
                }
                writer.println(); // Move to next line
                // 한 줄 끝나면 줄바꿈
            }

            System.out.println("Room state saved to: " + path);
        } catch (Exception e) {
            System.out.println("Error saving room: " + e.getMessage());
        }
    }

    // Getters
    // getter 메서드들
    public ArrayList<Renderable> getRenderables() {
        return renderables;
    }

    public char[][] getMap() {
        return map;
    }

    public String[][] getRawCells() {
        return rawCells;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    // Convert character codes to printable symbols for UI
    // 문자 코드를 출력용 심벌로 변환
    public static String getSymbolForRendering(char c) {
        if (c == '@') {
            return "☺";
        } else if (c == 'S') {
            return "/";
        } else if (c == 'W') {
            return "†";
        } else if (c == 'X') {
            return "⚔";
        } else if (c == 'm') {
            return "⚱";
        } else if (c == 'B') {
            return "⚱";
        } else if (c == 'G') {
            return "☠";
        } else if (c == 'O') {
            return "☢";
        } else if (c == 'T') {
            return "⚑";
        } else if (c == 'd') {
            return "⬓";
        } else if (c == 'D') {
            return "⛩";
        } else {
            return " ";
        }
    }
}
