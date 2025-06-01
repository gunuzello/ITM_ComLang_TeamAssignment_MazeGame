/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public abstract class Weapon {

    private String weaponName;
    private int weaponDamage;

    public Weapon() {

    }

    public Weapon(String weaponName, int weaponDamage) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage() {
        return this.weaponDamage;
    }

    public String getWeapon() {
        return this.weaponName;
    }

    @Override
    public String toString() {
        return weaponName + " (Damage: " + weaponDamage + ")";
    }

}
