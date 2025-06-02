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
        } else if (c == 'G') {
            return new Goblin(x, y, false);
        } else if (c == 'O') {
            return new Orc(x, y, false);
        } else if (c == 'T') {
            return new Troll(x, y, true);  // 키 보유 몬스터
        } else {
            return null;
        }
    }
}
