/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class Potion {
    private String potionName;
    private int healAmount;
    
    public Potion(String potionName , int healAmount) {
        this.potionName = potionName;
        this.healAmount = healAmount;
    }
    
    public String getPotionName() {
        return this.potionName;
    }
    
    public int getHealAmount() {
        return this.healAmount;
    }
    
    @Override
    public String toString() {
        return  this.potionName + " (+" + this.healAmount + " HP)";
    }
    
    public static final Potion MINOR_FLASK = new Potion("Minor Flask" , 6);
    public static final Potion BIG_FLASK = new Potion("Big Flask" , 12);
    
    public static Potion charToPotion(char c) {
        if ( c == 'm') return MINOR_FLASK;
        else if ( c == 'B') return BIG_FLASK;
        else return null;
    }
}
