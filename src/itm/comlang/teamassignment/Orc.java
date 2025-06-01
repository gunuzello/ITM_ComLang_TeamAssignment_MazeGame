/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */

/* Orc 클래스 - HP 8, Damage 3 */
class Orc extends Monster {
    public Orc(int x, int y) {
        super(x, y, false);
    }

    @Override
    public int getInitialHp() {
        return 8;
    }

    @Override
    public int getDamageValue() {
        return 3;
    }

    @Override
    public String getSymbol() {
        return "O";
    }
}