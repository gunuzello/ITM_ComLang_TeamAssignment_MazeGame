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
        } else if (c == 'D') {
            return new Door(x, y, null, true);
        } else if (c == 'G') {
            return new Goblin(x, y, 3, false);
        } else if (c == 'O') {
            return new Orc(x, y, 8, false);
        } else if (c == 'T') {
            return new Troll(x, y, 15, true);
        }
        return null;
    }

    public static Renderable createAdvancedEntity(String cell, int x, int y) {
        cell = cell.trim();

        if (cell.startsWith("d:")) {
            String filename = cell.split(":")[1].trim();
            return new Door(x, y, filename, false);
        }
        return null;

    }
}
