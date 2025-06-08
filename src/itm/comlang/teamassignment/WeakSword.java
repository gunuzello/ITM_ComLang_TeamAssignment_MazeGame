/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author gunu_zello
 */
public class WeakSword extends Weapon implements Renderable {

    // Constructor for WeakSword that sets name to "Weak Sword", damage to 3, and position (x, y)
    // ("Weak Sword"이라는 이름, 데미지 3, 좌표 (x, y)를 설정하는 생성자)
    public WeakSword(int x, int y) {
        super("Weak Sword", 3, x, y); // call parent constructor of Weapon (Weapon 부모 생성자 호출)
    }

    @Override
    public char getSymbol() {
        return 'W'; // returns character symbol representing WeakSword on map ('W'로 약한 검을 표시)
    }
}
