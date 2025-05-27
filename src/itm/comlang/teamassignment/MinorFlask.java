/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class MinorFlask extends Potion {

    public MinorFlask() {
        super("Minor Flask", 6); // 어차피 고정된 값이니까.

    }

    @Override
    public String getPotionName() {
        return "Minor Flask"; // 어차피 고정된 값이니까.
    }

    @Override
    public int getHealAmount() {
        return 6; // 어차피 고정된 값이니까.
    }
}
