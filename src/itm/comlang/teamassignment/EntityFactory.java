/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class EntityFactory {
//used polymorphism

    public static Renderable createEntityFromChar(char c, int x, int y) {
        if (c == 'S') {
            return new Stick(x, y);
        } else if (c == 'W') {
            return new WeakSword(x, y);
        } else if (c == 'X') {
            return new StrongSword(x, y);
        } else if (c == 'm') {
            return new MinorFlask(x, y);
        } else if (c == 'B') {
            return new BigFlask(x, y);
        } else {
            return null;
        }
    }

    public static Renderable createAdvancedEntity(String cell, int x, int y) {
        if (cell.startsWith("G:")) {
            int hp = Integer.valueOf(cell.split(":")[1]);
            return new Goblin(x, y, hp, false);
        } else if (cell.startsWith("O:")) {
            int hp = Integer.valueOf(cell.split(":")[1]);
            return new Orc(x, y, hp, false);
        } else if (cell.startsWith("T:")) {
            int hp = Integer.valueOf(cell.split(":")[1]);
            return new Troll(x, y, hp, true);  // Troll은 항상 key 보유
        } else if (cell.startsWith("d:") || cell.startsWith("D:")) {
            boolean isFinal = cell.charAt(0) == 'D'; // cell.charAt(0) == 'D'이면 true 
            String filename = cell.split(":")[1];
            return new Door(x, y, filename, isFinal);
        }
        return null;
    }
}
