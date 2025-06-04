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
    private Scanner sc = new Scanner(System.in);

    //히어로 위치 인식 및 객체 배치, 게임 시작시 초기세팅이다. 처음에 room1을 여는 것은 불변이므로 고정값으로 줌 
    public Game() {
        this.room = new Room("room1.csv"); // 고정값이니까 
        int[] heroLocation = room.findHeroLocation(); //heroLocation 에다가 히어로를 찾는 메소드 사용해서 좌표값 집어넣음 

        if (heroLocation != null) { //heroLocation에 값이 있을때는 그 좌표값으로 히어로를 지정함.(생성자가 좌표 뿐이니)
            this.hero = new Hero(heroLocation[0], heroLocation[1]);
        } else { //히어로 위치가 지정되지 않으면 랜덤으로 뿌림
            int[] randomLoc = room.findRandomEmptySpace();
            this.hero = new Hero(randomLoc[0], randomLoc[1]);
        }
    }

    // 게임 구동을 위한 메인 루프, 사실상 이 메소드를 메인클래스에서 구동함
    public void GameRunning() {
        while (true) {
            room.printRoom(); // 현재 방 출력
            
            
            System.out.println("Enter command (u/d/l/r to move, a to attack, q to quit): ");
            String direction = sc.nextLine();
            hero.move(direction, room.getMap());
            processCell();
            if (!hero.isStillAlive()) {
                System.out.println("You die!");
                break;
            } else if (direction.equals("q")) {
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
        if (cell == 'S' || cell == 'W' || cell == 'X') { //무기를 찾았을때
            handleWeapon(x, y);//무기찾고 행동 메소드
        }

        // 포션 검색
        if (cell == 'm' || cell == 'B') {
            handlePotion(x, y);
        }

        // 몬스터 검색
        if (cell == 'G' || cell == 'O' || cell == 'T') {
            handleMonster(x, y);
        }
    }

    //웨폰 만났을때 행동 메소드
    private void handleWeapon(int x, int y) {
        for (Renderable r : room.getRenderables()) {
            if (r.getX() == x && r.getY() == y && r instanceof Weapon) {
                Weapon weapon = (Weapon) r;

                if (!hero.isArmed()) {
                    hero.equipWeapon(weapon);
                    System.out.println("You equipped: " + weapon.getName());
                } else {
                    System.out.println("You found: " + weapon.getName());
                    System.out.println("You are currently holding: " + hero.getWeapon().getName());
                    System.out.print("Do you want to switch? (y/n): ");
                    String answer = sc.nextLine();

                    if (answer.equals("y")) {
                        hero.equipWeapon(weapon);
                        System.out.println("Switched to: " + weapon.getName());
                    } else {
                        System.out.println("Kept your current weapon.");
                    }
                }
                break;
            }
        }
    }

    //포션 행동 메소드 
    private void handlePotion(int x, int y) {
        for (Renderable r : room.getRenderables()) {
            if (r.getX() == x && r.getY() == y && r instanceof Potion) {
                Potion potion = (Potion) r;
                int beforeHeal = hero.getHP(); //포션 먹기 전 체력 저장용

                if (beforeHeal < 25) {  // HP가 꽉 차지 않았을 때만 회복
                    hero.heal(potion.getHealAmount());
                    System.out.println("You used: " + potion.getName());
                    System.out.println("HP restored to: " + hero.getHP());
                    room.getRenderables().remove(r);  // 사용한 포션은 제거
                } else {
                    System.out.println("Your HP is full. Potion left on the ground.");
                }
                break;
            }
        }
    }

    //몬스터 전투 행동 메소드 
    private void handleMonster(int x, int y) {
        for (Renderable r : room.getRenderables()) {
            if (r.getX() == x && r.getY() == y && r instanceof Monster) {
                Monster monster = (Monster) r;

                System.out.println("Encountered " + monster.getName() + " (HP: " + monster.getHp() + ")");

                //히어로가 무기가 없으면 싸우지 못한다는 것
                if (!hero.isArmed()) {
                    System.out.println("You have no weapon to attack! Escape or find a weapon.");
                    return;
                }

                //몬스터가 살아있고, 히어로도 살아있을때 공격여부 결정
                while (monster.getHp() > 0 && hero.isStillAlive()) {
                    System.out.print("Attack? (y/n): ");
                    String choice = sc.nextLine();

                    //공격을 한다면 히어로 => 몬스터 순서로 공격
                    if (choice.equals("y")) {
                        monster.takeDamage(hero.countDamage());
                        System.out.println("You hit " + monster.getName() + ". Monster HP: " + monster.getHp());

                        if (monster.getHp() > 0) {
                            hero.takeDamage(monster.getDamage());
                            System.out.println(monster.getName() + " hits back! Your HP: " + hero.getHP());
                        }
                    } else { //공격 안할거면 그냥 넘어가기
                        System.out.println("You chose not to attack.");
                        break;
                    }
                }

                //몬스터가 죽었을때 필드에서 삭제, 트롤의 경우에는 키를 드랍
                if (monster.getHp() <= 0) {
                    System.out.println(monster.getName() + " is defeated!");

                    if (monster.isKeyHolder()) {
                        System.out.println("You obtained the KEY!");
                        hero.earnKey();
                    }
                    room.getRenderables().remove(r);
                }
                break;
            }
        }
    }

}
