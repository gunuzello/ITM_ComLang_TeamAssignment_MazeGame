/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */

/* Goblin 클래스 - HP 3, Damage 1 */
public class Goblin extends Monster implements Renderable {

    public Goblin(int x, int y, boolean keyHolder) {
        super("Goblin",x, y, 8, 2, keyHolder);
    }
    
    @Override
    public char getSymbol() {
        return 'G';
    }
}
