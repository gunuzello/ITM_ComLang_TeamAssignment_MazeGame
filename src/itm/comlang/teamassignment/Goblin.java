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
class Goblin extends Monster {
    public Goblin(int x, int y) {
        super(x, y, false);
    }

    @Override
    public int getInitialHp() {
        return 3;
    }

    @Override
    public int getDamageValue() {
        return 1;
    }

    @Override
    public String getSymbol() {
        return "G";
    }
}
