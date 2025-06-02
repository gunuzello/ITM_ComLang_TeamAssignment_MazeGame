/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
public class Door implements Renderable {

    private int x;
    private int y;
    private String nextRoomFile;
    private boolean isFinal;

    public Door(int x, int y, String nextRoomFile, boolean isFinal) {
        this.x = x;
        this.y = y;
        this.nextRoomFile = nextRoomFile;
        this.isFinal = isFinal;
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
    
    @Override
    public char getSymbol() {
        if (isFinal) {
            return 'D';
        } else {
            return 'd';
        }
    }
    
    public String getName() {
        if (isFinal) {
            return "Master Door";
        } else {
            return "Regular Door";
        }
    }
    public String toString() {
        return "There is " + this.getName();
    }
}
