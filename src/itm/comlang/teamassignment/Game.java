/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

import java.util.Scanner;

/**
 *
 * @author ohkyounghun
 */
public class Game {

    private Hero hero;
    private Room room;

    //히어로 위치 인식 및 객체 배치, 게임 시작시 초기세팅이다. 처음에 room1을 여는 것은 불변이므로 고정값으로 줌 
    public Game() {
        this.room = new Room("room1.csv"); // 고정값이니까 
        int[] heroLocation = room.findHeroLocation();

        if (heroLocation != null) {
            this.hero = new Hero(heroLocation[0], heroLocation[1]);
        } else {
            int[] randomLoc = room.findRandomEmptySpace();
            this.hero = new Hero(randomLoc[0], randomLoc[1]);
        }
    }

    // 게임 구동을 위한 메인 루프, 사실상 이 메소드를 메인클래스에서 구동함
    public void GameRunning() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            room.printRoom(); // 현재 방 출력
            System.out.println("Enter move (u/d/l/r): ");
            String direction = sc.nextLine();
            hero.move(direction, room.getMap());
            processCell();
            if (!hero.isStillAlive()) {
                System.out.println("You die!");
                break;
            } else if(direction.equals("q")){
                break;
            }
        }
    }

    //히어로가 이동을 한 후 히어로의 위치에 있는 문자에 대해 우리가 이미 초기에 파악해 놓은 리스트안에 들어있는 객체에서 꺼내는것 까지의 골격 
    public void processCell() {
        int x = hero.getX();
        int y = hero.getY();
        char cell = room.getMap()[x][y];

        // 무기 검색
        if (cell == 'S' || cell == 'W' || cell == 'X') {
            for (Weapon w : room.getWeapons()) {
                if (w.getX() == x && w.getY() == y) {
                    System.out.println("Weapon found: " + w.getName());
                    // 이후 행동은 별도 메소드에서 처리
                    break;
                }
            }
        }

        // 포션 검색
        if (cell == 'm' || cell == 'B') {
            for (Potion p : room.getPotions()) {
                if (p.getX() == x && p.getY() == y) {
                    System.out.println("Potion found: " + p.getName());
                    // 이후 행동은 별도 메소드에서 처리
                    break;
                }
            }
        }

        // 몬스터 검색
        if (cell == 'G' || cell == 'O' || cell == 'T') {
            for (Monster m : room.getMonsters()) {
                if (m.getX() == x && m.getY() == y) {
                    System.out.println("Monster found: " + m.getClass().getSimpleName()); //m이라는 Monster 객체의 클래스 이름을 문자열로 가져와라.
                    // 이후 전투는 여기서 호출 가능
                    break;
                }
            }
        }
    }

}
