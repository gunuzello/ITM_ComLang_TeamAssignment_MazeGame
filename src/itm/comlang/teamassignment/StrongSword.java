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

    public StrongSword(int x, int y) {
        super("Strong Sword", 5, x, y);

    }
    
    @Override
    public char getSymbol() {
        return 'X';
    }
}
