/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class BigFlask extends Potion {

    public BigFlask() {
        super("Big Flask", 12); // 어차피 고정된 값이니까.

    }

    @Override
    public String getPotionName() {
        return "Big Flask"; // 어차피 고정된 값이니까.
    }

    @Override
    public int getHealAmount() {
        return 12; // 어차피 고정된 값이니까.
    }
}
