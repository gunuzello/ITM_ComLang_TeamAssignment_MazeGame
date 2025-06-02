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

    //몬스터의 이름 반환
    public String getName(){
        return this.name;
    }
    
    //몬스터 위치의 x값 반환 
    public int getX() {
        return x;
    }

    //몬스터 위치의 y값 반환 
    public int getY() {
        return y;
    }

    //몬스터의 체력 반환 
    public int getHp() {
        return hp;
    }

    //해당 몬스터가 가지는 공격력 반환 
    public int getDamage() {
        return damage;
    }

    //해당 몬스터가 key를 들고 있는지 참.거짓 반환 
    public boolean isKeyHolder() {
        return keyHolder;
    }

    //몬스터가 히어로에게 공격당했을때 받은 데미지만큼 체력 소모 
    public void takeDamage(int damageTaken) {
        hp -= damageTaken;
        if (hp < 0) {
            hp = 0;
        }
    }

    //몬스터의 사망여부 확인 
    public boolean isDead(){
        return this.hp <=0;
    }
    
    
    
    //몬스터가 히어로를 공격할 때 실행
    public void attack(Hero hero) {
        hero.takeDamage(this.damage);
    }
    
    public String toString() {
        return this.name + " (Damage: " + this.damage + " " + " HP: " + this.hp+ ")";
    }
}
