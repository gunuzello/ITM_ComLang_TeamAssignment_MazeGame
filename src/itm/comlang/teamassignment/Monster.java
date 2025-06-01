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
public abstract class Monster {

    private int x, y;               // 몬스터의 위치
    private int hp;                 // 체력
    private int damage;            // 공격력
    private boolean keyHolder;     // 키 드랍 여부

    /*
      몬스터 생성자 - 하위 클래스에서 호출됨
     */
    public Monster(int x, int y, boolean keyHolder) {
        this.x = x;
        this.y = y;
        this.keyHolder = keyHolder;
        this.hp = getInitialHp();
        this.damage = getDamageValue();
    }

    // 각 몬스터별 초기 체력 정의
    public abstract int getInitialHp();

    // 각 몬스터별 공격력 정의
    public abstract int getDamageValue();

    // 몬스터를 표시할 문자 ("G", "O", "T")
    public abstract String getSymbol();

    // 데미지를 받아 체력 감소
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }
    }

    // 히어로에게 공격
    public void attack(Hero hero) {
        hero.attack(damage);
    }

    // 키 드랍 여부 반환
    public boolean isKeyHolder() {
        return keyHolder;
    }

    // 체력 반환
    public int getHp() {
        return hp;
    }

    // 위치 반환
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
