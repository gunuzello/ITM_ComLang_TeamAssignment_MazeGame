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
    private boolean hasKey;
    private int x;
    private int y;
    private Weapon weapon;

    public Hero(int x, int y) {
        this.hp = 25;
        this.x = x;
        this.y = y;
        this.hasKey = false;
    }

    public int attack(int damage) {
        return this.hp -= damage;
    }

    public int heal(int potion) {
        return this.hp += potion;
    }

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
        }
        this.x = newX;
        this.y = newY;

        // 맵 범위 체크
        if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) {
            System.out.println("You can't escape the map!");
            return;
        }

        // 빈 공간만 이동 허용
        if (map[newX][newY] != ' ') {
            System.out.println("You can't move there!");
            return;
        }

        // 이전 위치를 비우고, 새 위치에 @ 표시
        map[this.x][this.y] = ' ';
        this.x = newX;
        this.y = newY;
        map[this.x][this.y] = '@';

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean hasKey() {
        return this.hasKey;
    }

    public void earnKey() {
        this.hasKey = true;
    }

    public boolean isStillAlive() {
        if (this.hp > 0) {
            return true;
        }
        return false;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
