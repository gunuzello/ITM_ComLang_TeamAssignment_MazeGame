/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public abstract class Potion { // 직접 객체 생성이 불가능함 -> 추상클래스로 지정했기때문
    private String potionName;
    private int healAmount;
    
    public Potion(String potionName , int healAmount) {
        this.potionName = potionName;
        this.healAmount = healAmount;
    }
    
    public abstract String getPotionName();
    
    
    public abstract int getHealAmount();
    
    
    @Override
    public String toString() {
        return  this.potionName + " (+" + this.healAmount + " HP)";
    }
    
    
   
}
