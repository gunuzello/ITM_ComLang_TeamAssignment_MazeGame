/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */

/* Orc class - HP 8, Damage 3 */
/* Orc 클래스 - 체력 8, 데미지 3 */
public class Orc extends Monster implements Renderable {

    // Constructor for Orc with position, HP, and key holding flag
    // Orc의 위치, 체력, 열쇠 보유 여부를 설정하는 생성자
    public Orc(int x, int y, int hp, boolean keyHolder) {
        super("Orc", x, y, hp, 3, keyHolder); // Call Monster constructor with damage = 3
        // Monster 부모 생성자를 호출하며 데미지는 3으로 고정
    }

    @Override
    public char getSymbol() {
        return 'O'; // Symbol used to display Orc on the map
        // 맵에 Orc를 표시할 때 사용하는 문자 심벌
    }
}
