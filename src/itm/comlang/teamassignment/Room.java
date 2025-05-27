/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ohkyounghun
 */
public class Room {

    private char[][] map;
    private int rows;
    private int cols;
   

    public Room(String filePath) {
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            String[] parts = scanner.nextLine().split(",");
            rows = Integer.valueOf(parts[0]);
            cols = Integer.valueOf(parts[1]);

            map = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                String[] cells = line.split(",");
                for (int j = 0; j < cols; j++) {
                    String divideCells = cells[j];
                    map[i][j] = divideCells.charAt(0);

                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void printRoom() {
       

        System.out.print("+");
        for (int i = 0; i < cols; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("|");
        }

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
                    return new int[]{i,j}; // 배열을 리턴 -> {x,y}와 같음
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
                    emptyspace.add(new int[]{i,j}); // 리스트에 빈 좌표들을 저장
                }
            }
        }
        if (emptyspace.isEmpty()) { 
            return null; // 맵에 빈공간이 없을경우 null 리턴
        }
        Random random = new Random(); // 랜덤하게 정수를 뽑아주는 클래스 (자바유틸)
        return emptyspace.get(random.nextInt(emptyspace.size())); // nextInt() 메서드는 랜덤으로 숫자를 뽑아주므로 , ()안에 배열 크기를 초과하는 
                                                                  // 불상사를 방지하기위해 .size()로 방지.
    }
}
