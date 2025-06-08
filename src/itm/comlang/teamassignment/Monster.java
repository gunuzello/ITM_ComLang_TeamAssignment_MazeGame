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
  몬스터 클래스 - Goblin, Orc, Troll의 공통 기능 제공
 */
public class Monster {

    private String name;         // Name of the monster (몬스터 이름)
    private int x;               // X coordinate (x 좌표)
    private int y;               // Y coordinate (y 좌표)
    private int hp;              // Hit points (체력)
    private int damage;          // Attack damage (공격력)
    private boolean keyHolder;   // Whether the monster holds the key (열쇠 보유 여부)

    // Constructor to initialize monster properties
    // 몬스터의 속성들을 초기화하는 생성자
    public Monster(String name, int x, int y, int hp, int damage, boolean keyHolder) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
        this.keyHolder = keyHolder;
        this.name = name;
    }

    // Returns the monster's name
    // 몬스터의 이름 반환
    public String getName() {
        return this.name;
    }

    // Returns X coordinate
    // 몬스터 위치의 x값 반환
    public int getX() {
        return x;
    }

    // Returns Y coordinate
    // 몬스터 위치의 y값 반환
    public int getY() {
        return y;
    }

    // Returns current HP
    // 몬스터의 체력 반환
    public int getHp() {
        return hp;
    }

    // Returns the monster's attack damage
    // 해당 몬스터가 가지는 공격력 반환
    public int getDamage() {
        return damage;
    }

    // Returns whether the monster holds a key
    // 해당 몬스터가 열쇠를 들고 있는지 여부 반환
    public boolean isKeyHolder() {
        return keyHolder;
    }

    // Reduces HP by the given damage amount
    // 히어로에게 공격당했을 때 체력을 감소시킴
    public void takeDamage(int damageTaken) {
        hp -= damageTaken;
        if (hp < 0) {
            hp = 0;
        }
    }

    // Checks if the monster is dead (HP <= 0)
    // 몬스터의 사망 여부 확인
    public boolean isDead() {
        return this.hp <= 0;
    }

    // Attacks the hero and reduces their HP
    // 몬스터가 히어로를 공격함
    public void attack(Hero hero) {
        hero.takeDamage(this.damage);
    }

    @Override
    public String toString() {
        return this.name + " (Damage: " + this.damage + " HP: " + this.hp + ")";
        // 예시 출력: "Orc (Damage: 3 HP: 8)"
    }
}
