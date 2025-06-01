/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package itm.comlang.teamassignment;

import java.util.ArrayList;

/**
 *
 * @author gunu_zello
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Room room1 = new Room("room1.csv");
        Room room2 = new Room("room2.csv");
        Room room3 = new Room("room3.csv");
        Room room4 = new Room("room4.csv");
        room1.printRoom();
        room2.printRoom();
        room3.printRoom();
        room4.printRoom();
        System.out.println(room1.getMonsters());
        System.out.println(room1.getPotions());
        System.out.println(room1.getWeapons());
       
        

    }

}
