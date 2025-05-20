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
            
            for(int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < cols; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
        }
        
    }
    public void printRoom() {
        
        
    }
}


