/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class BigFlask extends Potion implements Renderable {

    public BigFlask(int x, int y) {
        super("Big Flask", 12, x, y);
    }
    
    @Override
    public char getSymbol() {
        return 'B';
    }
}
