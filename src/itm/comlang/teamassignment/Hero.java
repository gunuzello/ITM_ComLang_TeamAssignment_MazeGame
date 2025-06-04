/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class Hero implements Renderable {

    private int hp;
    private boolean hasKey;
    private int x;
    private int y;
    private Weapon weapon;
    private String name;

    public Hero(int x, int y) {
        this.hp = 25;
        this.x = x;
        this.y = y;
        this.hasKey = false;
        this.name = "Hero";
        this.weapon = new Weapon("None");
    }

    //지금 히어로가 가진 무기로 얼마만큼의 공격력을 가지는지 측정 
    public int countDamage() {
        if (this.weapon != null) {
            return this.weapon.getDamage();
        }
        return 0;
    }

    //히어로가 받는 데미지 값을 받아서 실제로 hp가 깎이도록 설정 
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    //히어로가 힐을 받을때 최대 체력인 25를 넘지 않도록 설정(반환값 없음)
    public void heal(int potion) {
        this.hp += potion;
        if (this.hp > 25) {
            this.hp = 25;
        }

    }

    //히어로가 가진 웨폰을 다른 웨폰으로 교체 
    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void move(String direction, char[][] map) {

        int newX = this.x;
        int newY = this.y;
        /*이중 배열의 위치
           y → (열)
        0   1   2   3   4
      +---+---+---+---+---+
x=0 → | 0 | 1 | 2 | 3 | 4 |   ← 맨 위 (map[0][0])
x=1 → |   |   |   |   |   |
x=2 → |   |   |   |   |   |
x=3 → |   |   |   |   |   |
x=4 → |   |   |   |   |   |
x=5 → |   |   |   |   |   |   ← 맨 아래 (map[4][4])
      +---+---+---+---+---+ */

        if (direction.equals("u")) {
            newX--;
        } else if (direction.equals("d")) {
            newX++;
        } else if (direction.equals("l")) {
            newY--;
        } else if (direction.equals("r")) {
            newY++;
        } else {
            System.out.println("Invalid direction!");
            return;
        }

        

        // 맵 범위 체크
        if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) {
            System.out.println("You can't escape the map!");
            return;
        }
        
        char targetCell = map[newX][newY];
        if (targetCell == 'G' || targetCell == 'O' || targetCell == 'T') {
            System.out.println("There is a monster blocking the way!");
            return;
        }

        // 이전 위치를 비우고, 새 위치에 @ 표시
        this.x = newX;
        this.y = newY;

    }

    public boolean isArmed() {
        if (this.weapon != null) {
            return true;
        } else {
            return false;
        }
    }

    //히어로의 무기값 반환 
    public Weapon getWeapon() {
        return this.weapon;
    }

    //히어로의 hp값 반환 
    public int getHP() {
        return this.hp;
    }

    //히어로 위치의 x값 반환 
    public int getX() {
        return this.x;
    }

    //히어로 위치의 y값 반환 
    public int getY() {
        return this.y;
    }

    //히어로의 key보유 여부 확인 
    public boolean hasKey() {
        return this.hasKey;
    }

    //히어로가 key를 가졌을때 hasKey 값을 변화시킴(반환값 없음)
    public void earnKey() {
        this.hasKey = true;
    }
    public String getKeyStatus() {
        if (this.hasKey) {
            return "Yes";
        }
        return "No";
        
    }

    //히어로의 생존여부 반환 
    public boolean isStillAlive() {
        if (this.hp > 0) {
            return true;
        }
        return false;
    }

    //히어로의 위치값 초기화 
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public char getSymbol() {
        return '@';
    }

    public String getName() {
        return this.name;
    }

}
