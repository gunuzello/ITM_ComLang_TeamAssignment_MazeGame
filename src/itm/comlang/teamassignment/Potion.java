/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
// 💊 Potion class representing healing items
// 💊 힐링 아이템을 나타내는 Potion 클래스
public class Potion {

    private String name;       // Name of the potion (포션의 이름)
    private int healAmount;    // Amount of HP restored (회복되는 HP 양)
    private int x;             // X coordinate of the potion (포션의 x 좌표)
    private int y;             // Y coordinate of the potion (포션의 y 좌표)

    // Constructor to initialize a Potion with name, heal amount, and position
    // 포션의 이름, 회복량, 좌표를 초기화하는 생성자
    public Potion(String name, int healAmount, int x, int y) {
        this.name = name;
        this.healAmount = healAmount;
        this.x = x;
        this.y = y;
    }

    // Returns the name of the potion
    // 포션의 이름을 반환
    public String getName() {
        return name;
    }

    // Returns the amount of HP the potion restores
    // 포션이 회복해주는 HP 양을 반환
    public int getHealAmount() {
        return healAmount;
    }

    // Returns the X coordinate of the potion
    // 포션의 X 좌표를 반환
    public int getX() {
        return x;
    }

    // Returns the Y coordinate of the potion
    // 포션의 Y 좌표를 반환
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return name + " (+" + healAmount + " HP)"; // Format: "PotionName (+HP)"
        // 예시: "Big Flask (+10 HP)"
    }
}
