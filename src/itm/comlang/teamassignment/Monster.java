/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
/*
  추상 몬스터 클래스 - Goblin, Orc, Troll의 공통 기능 제공
 */
public class Monster {
    private String name;
    private int x;
    private int y;
    private int hp;
    private int damage;
    private boolean keyHolder;

    public Monster(String name, int x, int y, int hp, int damage, boolean keyHolder) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
        this.keyHolder = keyHolder;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isKeyHolder() {
        return keyHolder;
    }

    public void takeDamage(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void attack(Hero hero) {
        hero.attack(damage);
    }
    public String toString() {
        return this.name + " (Damage: " + this.damage + " " + " HP: " + this.hp+ ")";
    }
}
