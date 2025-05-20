/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class Hero {
    private int hp;
    private String weapon;
    private boolean hasKey;
    private int x;
    private int y;
    
    public Hero (int x, int y) {
        this.hp = 25;
        this.x = x;
        this.y = y;
        this.weapon = "";
        this.hasKey = false;
    }
    public int Attack (int damage) {
        return this.hp -= damage;
    }
    public int heal (int portion) {
        return this.hp += portion;
    }
    public String equipWeapon (String weapon) {
        return this.weapon = weapon;
    }
    
    
           
}
