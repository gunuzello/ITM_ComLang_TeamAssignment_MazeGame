/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class Door {

    private int x;
    private int y;
    private String nextRoomFile;

    public Door(int x, int y, String nextRoomFile) {
        this.x = x;
        this.y = y;
        this.nextRoomFile = nextRoomFile;
    }

    public int getX() {
        return x;

    }

    public int getY() {
        return y;

    }

    public String getNextRoomFile() {
        return nextRoomFile;
    }

    public boolean isAtPosition(int heroX, int heroY) {
        return this.x == heroX && this.y == heroY;
    }
}
