/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
// Interface for objects that can be rendered on the map
// 맵에 렌더링될 수 있는 객체들을 위한 인터페이스
public interface Renderable {

    // Returns the character symbol to be displayed on the map
    // 맵에 표시될 캐릭터 심벌을 반환
    char getSymbol();

    // Returns the X coordinate of the object
    // 객체의 X 좌표를 반환
    int getX();

    // Returns the Y coordinate of the object
    // 객체의 Y 좌표를 반환
    int getY();

    // Returns the name of the object
    // 객체의 이름을 반환
    String getName();
}
