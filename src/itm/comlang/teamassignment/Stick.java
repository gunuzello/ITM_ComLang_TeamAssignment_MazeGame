/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author gunu_zello
 */
public class Stick extends Weapon implements Renderable {

    // Constructor for Stick that sets name to "Stick", damage to 1, and position (x, y)
    // ("Stick"이라는 이름, 데미지 1, 좌표 (x, y)를 설정하는 생성자)
    public Stick(int x, int y) {
        super("Stick", 1, x, y); // call parent constructor of Weapon (Weapon 부모 생성자 호출)
    }

    @Override
    public char getSymbol() {
        return 'S'; // returns character symbol representing Stick 
                    //('S'를 리턴)
                    
    }
}
