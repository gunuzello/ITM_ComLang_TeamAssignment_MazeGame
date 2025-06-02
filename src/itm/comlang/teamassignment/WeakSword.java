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
    public WeakSword(int x, int y) {
        super("Weak Sword", 3, x, y);
    }
    
    @Override
    public char getSymbol() {
        return 'W';
    }
}