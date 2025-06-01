/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public abstract class Potion { // 직접 객체 생성이 불가능함 -> 추상클래스로 지정했기때

    private String potionName;
    private int healAmount;

    protected Potion(String potionName, int healAmount) {
        this.potionName = potionName;
        this.healAmount = healAmount;
    }

    public String getPotionName() {
        return this.potionName;
    }

    public int getHealAmount() {
        return this.healAmount;
    }

    public static Potion charToPotion(char c) {
        /* static을 부여함으로써 객체 없이도 바로 접근하게 만듬. 예시: Potion potion = Potion.charToPotion(cell); 이런식으로 
        Game 클래스에서 호출 가능. */

        if (c == 'm') {
            return new MinorFlask();
        } else if (c == 'B') {
            return new BigFlask();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.potionName + " (+" + this.healAmount + " HP)";
    }

}
