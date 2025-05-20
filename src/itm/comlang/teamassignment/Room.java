/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

import java.nio.file.Paths;
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
}
