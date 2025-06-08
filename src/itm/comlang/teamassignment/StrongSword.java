/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author gunu_zello
 */
public class StrongSword extends Weapon implements Renderable {

    // Constructor for StrongSword that sets name to "Strong Sword", damage to 5, and position (x, y)
    // ("Strong Sword"라는 이름, 데미지 5, 좌표 (x, y)를 설정하는 생성자)
    public StrongSword(int x, int y) {
        super("Strong Sword", 5, x, y); // call parent constructor of Weapon 
                                        // (Weapon 부모 생성자 호출)
    }

    @Override
    public char getSymbol() {
        return 'X'; // returns character symbol representing StrongSword on map 
                    //('X'로 강한 검을 표시)
    }
}
