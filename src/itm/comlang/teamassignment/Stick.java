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
    public Stick(int x, int y) {
        super("Stick", 1, x, y);
    }
    
    @Override
    public char getSymbol() {
        return 'S';
    }
}
