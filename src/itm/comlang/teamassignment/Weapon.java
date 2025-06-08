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

    private String name; // name of the weapon (무기의 이름)
    private int damage;  // damage dealt by the weapon (무기의 데미지)
    private int x;       // x-coordinate location of the weapon (무기의 x 좌표)
    private int y;       // y-coordinate location of the weapon (무기의 y 좌표)

    public Weapon(String name, int damage, int x, int y) {
        this.name = name;         // initialize weapon name (무기 이름 초기화)
        this.damage = damage;     // initialize weapon damage (무기 데미지 초기화)
        this.x = x;               // initialize x-coordinate (x 좌표 초기화)
        this.y = y;               // initialize y-coordinate (y 좌표 초기화)
    }

    public int getWeaponDamage() {
        return this.damage; // return weapon damage (무기 데미지 반환)
    }

    public String getName() {
        return name; // return weapon name (무기 이름 반환)
    }

    public int getDamage() {
        return damage; // return weapon damage (무기 데미지 반환)
    }

    public int getX() {
        return x; // return x-coordinate of the weapon (무기의 x 좌표 반환)
    }

    public int getY() {
        return y; // return y-coordinate of the weapon (무기의 y 좌표 반환)
    }

    @Override
    public String toString() {
        if (this.name.equals("None")) {
            return name; // if weapon has no name, return "None" (무기가 없으면 "None" 반환)
        }
        return name + " (Damage: " + damage + ")"; // return formatted weapon info (무기 정보 포맷팅해서 반환)
    }
}
