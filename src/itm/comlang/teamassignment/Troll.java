/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */

/* Troll 클래스 - HP 15, Damage 4, keyHolder 가능 */
public class Troll extends Monster implements Renderable {

    public Troll(int x, int y, boolean keyHolder) {
        super("Troll", x, y, 16, 4, keyHolder);
    }
    
    @Override
    public char getSymbol() {
        return 'T';
    }
}
