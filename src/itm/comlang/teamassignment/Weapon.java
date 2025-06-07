/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class Weapon {

    private String name;
    private int damage;
    private int x;
    private int y;

    public Weapon(String name, int damage, int x, int y) {
        this.name = name;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }
    

    public int getWeaponDamage() {
        return this.damage;

    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    

    @Override
    public String toString() {
        if(this.name.equals("None")) {
            return name;
        }
        return name + " (Damage: " + damage + ")";
    }
}
