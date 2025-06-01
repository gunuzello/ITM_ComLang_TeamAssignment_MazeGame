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
class Troll extends Monster {
    public Troll(int x, int y, boolean keyHolder) {
        super(x, y, keyHolder);
    }

    @Override
    public int getInitialHp() {
        return 15;
    }

    @Override
    public int getDamageValue() {
        return 4;
    }

    @Override
    public String getSymbol() {
        return "T";
    }
}

