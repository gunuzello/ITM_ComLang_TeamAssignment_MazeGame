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

    private char[][] map; // 간단한 심벌을 가진 엔티티들을 위해 
    private String[][] rawCells; // : 와 같이 스플릿을 해야하는 엔티티들을 위해
    private int rows;
    private int cols;
    // Room에 존재하는 게임 요소들을 저장할 리스트
    private ArrayList<Renderable> renderables = new ArrayList<>();

    public Room(String filePath) {
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            String[] parts = scanner.nextLine().split(",");
            rows = Integer.valueOf(parts[0]);
            cols = Integer.valueOf(parts[1]);

            map = new char[rows][cols];
            rawCells = new String[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                String[] cells = line.split(",");
                for (int j = 0; j < cols; j++) {

                    map[i][j] = cells[j].charAt(0);
                    rawCells[i][j] = cells[j];

                }

            }
            // 맵이 로딩된 후 엔티티 자동 스캔
            scanEntitiesFromMap();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    // 맵을 순회하면서 각 좌표의 문자를 기반으로 객체 생성 및 리스트 추가
  private void scanEntitiesFromMap() {
    for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
            String cell = rawCells[i][j].trim(); // 공백 제거 중요
            Renderable entity = null;

            if (cell.isEmpty()) {
                map[i][j] = ' ';
                continue;
            }

            if (cell.charAt(0) == '@') {
                map[i][j] = ' ';  // 히어로는 Room이 아니라 Game에서 관리
            } else if (cell.contains(":")) {
                entity = EntityFactory.createAdvancedEntity(cell, i, j);
            } else {
                entity = EntityFactory.createEntityFromChar(cell.charAt(0), i, j);
            }

            if (entity != null) {
                renderables.add(entity);
                map[i][j] = entity.getSymbol();  // 이때만 심벌 덮어쓰기
            }
        }
    }
}
    public void printRoom(Hero hero) {
        
        //1. 상단 뚜껑 만들기 
        System.out.print("+");
        for (int i = 0; i < cols; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        //2.좌측 벽 만들기(한 줄 단위로)(이거 반복문 돌림)
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            //3. 한 줄 단위로 히어로 위치 확인
            for (int j = 0; j < cols; j++) {
                if (hero != null && i == hero.getX() && j == hero.getY()) {
                    System.out.print('@');  // hero 현재 위치에서만 출력
                } else {
                    System.out.print(map[i][j]);
                }
            }
            //4. 우측 벽 만들기(한 줄 단위로)(여기서 반복문 하나 끝남 다시 위로 올라가지)
            System.out.println("|");
        }

        //5. 하단 뚜껑 만들
        System.out.print("+");
        for (int i = 0; i < cols; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public int[] findHeroLocation() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '@') {
                    return new int[]{i, j}; // 배열을 리턴 -> {x,y}와 같음
                }
            }
        }
        return null; // @가 없으면 그냥 null 리턴.
    }

    public int[] findRandomEmptySpace() { // 위 메서드를 사용했는데 @가 없으면 랜덤으로 지정해줘야하므로 필요함.
        // 아마 Game클래스에서 if(null) -> findRandomEmptySpace() 실행하는 순서로 로직 구현해야할듯.
        ArrayList<int[]> emptyspace = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == ' ') {
                    emptyspace.add(new int[]{i, j}); // 리스트에 빈 좌표들을 저장
                }
            }
        }
        if (emptyspace.isEmpty()) {
            return null; // 맵에 빈공간이 없을경우 null 리턴
        }
        Random random = new Random(); // 랜덤하게 정수를 뽑아주는 클래스 (자바유틸)
        return emptyspace.get(random.nextInt(emptyspace.size())); // nextInt() 메서드는 랜덤으로 숫자를 뽑아주므로 , ()안에 배열 크기를 초과하는 
        // 불상사를 방지하기위해 .size()로 방지.
    }// 게임 로직에서 사용할 수 있도록 각 리스트 getter 제공

    public void saveRoomToFile(String path) {
        try (PrintWriter writer = new PrintWriter(path)) {
            // 첫 줄에 행과 열 정보 저장
            writer.println(rows + "," + cols);

            // map 배열을 한 줄씩 저장
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.print(rawCells[i][j]);
                    if (j < cols - 1) {
                        writer.print(",");  // 마지막 열이 아닐 때만 쉼표 추가
                    }
                }
                writer.println(); // 한 줄 끝나면 줄바꿈
            }

            System.out.println("Room state saved to: " + path);
        } catch (Exception e) {
            System.out.println("Error saving room: " + e.getMessage());
        }
    }

    public ArrayList<Renderable> getRenderables() {
        return renderables;
    }

    public char[][] getMap() {
        return map;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
