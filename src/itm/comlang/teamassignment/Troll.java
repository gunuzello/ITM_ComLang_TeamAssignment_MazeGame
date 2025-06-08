/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */

/* Troll class - HP 15, Damage 4, can hold the key (Troll 클래스 - 체력 15, 데미지 4, 열쇠 보유 가능) */
public class Troll extends Monster implements Renderable {

    // Constructor for Troll that sets name, position, HP, damage, and keyHolder flag
    // (Troll 생성자: 이름, 위치, 체력, 데미지, 열쇠 보유 여부 설정)
    public Troll(int x, int y, int hp, boolean keyHolder) {
        super("Troll", x, y, hp, 4, keyHolder); // call Monster constructor with parameters 
    }

    @Override
    public char getSymbol() {
        return 'T'; // returns character symbol representing Troll ('T'를 리턴)

    }
}
