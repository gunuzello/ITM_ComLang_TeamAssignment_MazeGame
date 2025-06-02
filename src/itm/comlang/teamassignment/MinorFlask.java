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

    public MinorFlask(int x, int y) {
        super("Minor Flask", 6, x, y);
    }
    
    @Override
    public char getSymbol() {
        return 'm';
    }
}
