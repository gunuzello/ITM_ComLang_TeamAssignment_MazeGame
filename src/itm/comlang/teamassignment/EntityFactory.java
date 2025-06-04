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


    public static Renderable createAdvancedEntity(String c, int x, int y) {
        c = c.trim();
        if (c.contains("S")) {
            return new Stick(x, y);
        } else if (c.contains("W")) {
            return new WeakSword(x, y);
        } else if (c.contains("X")) {
            return new StrongSword(x, y);
        } else if (c.equals("m")) {
            return new MinorFlask(x, y);
        } else if (c.contains("B")) {
            return new BigFlask(x, y);
        } else if (c.contains("D")) {
            return new Door(x, y, null, true);
        } else if (c.contains("G")) {
            return new Goblin(x, y, 3, false);
        } else if (c.contains("O")) {
            return new Orc(x, y, 8, false);
        } else if (c.contains("T")) {
            return new Troll(x, y, 15, true);
        }

        if (c.contains("d:")) {
            String filename = c.split(":")[1].trim();
            return new Door(x, y, filename, false);
        }
        return null;

    }
}
