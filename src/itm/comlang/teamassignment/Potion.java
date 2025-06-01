/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
// 💊 Potion 클래스
public class Potion {

    private String name;
    private int healAmount;
    private int x;
    private int y;

    public Potion(String name, int healAmount, int x, int y) {
        this.name = name;
        this.healAmount = healAmount;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return name + " (+" + healAmount + " HP)";
    }
}
