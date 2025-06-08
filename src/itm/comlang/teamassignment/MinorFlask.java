/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class MinorFlask extends Potion implements Renderable {

    // Constructor for MinorFlask with fixed name and healing amount
    // 이름과 회복량이 고정된 MinorFlask 생성자
    public MinorFlask(int x, int y) {
        super("Minor Flask", 6, x, y); // Heal amount is 6 (회복량은 6)
    }

    @Override
    public char getSymbol() {
        return 'm'; // Symbol used to represent MinorFlask on the map
        // 맵에서 MinorFlask를 나타내는 문자 심벌
    }
}
