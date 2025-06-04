/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ohkyounghun
 */
public class Game {

    private Hero hero;
    private Room room;
    private Scanner sc = new Scanner(System.in);
    private String copiedFolder;
    private String currentRoomFileName;

    //히어로 위치 인식 및 객체 배치, 게임 시작시 초기세팅이다. 처음에 room1을 여는 것은 불변이므로 고정값으로 줌 
    public Game() {
        // 1. 복사 먼저 수행
        this.copiedFolder = RoomFileManager.copyRoomsToNewFolder("rooms");

        // 2. 복사 실패 시 종료 처리 (혹시라도 에러났을 때)
        if (copiedFolder == null) {
            System.out.println("Cannot start the Game.");
            return;
        }

        // 3. 복사된 폴더에서 room1.csv 로드
        this.currentRoomFileName = "room1.csv";
        this.room = new Room(copiedFolder + "/" + currentRoomFileName);
        int[] heroLocation = room.findHeroLocation(); //heroLocation 에다가 히어로를 찾는 메소드 사용해서 좌표값 집어넣음 

        if (heroLocation != null) {
            // case 1: @가 있으면 거기로 생성
            this.hero = new Hero(heroLocation[0], heroLocation[1]);
        } else {
            // case 2: @가 없을 때
            // 먼저 (1,1) 시도
            if (room.getMap()[1][1] == ' ') {
                this.hero = new Hero(1, 1);
            } else {
                // (1,1)에도 못 놓으면 → 랜덤 빈칸
                int[] randomLoc = room.findRandomEmptySpace();
                this.hero = new Hero(randomLoc[0], randomLoc[1]);
            }
        }
    }

    // 게임 구동을 위한 메인 루프, 사실상 이 메소드를 메인클래스에서 구동함
    public void GameRunning() {
        while (true) {
            System.out.println("AdventureGame");
            System.out.println("HP: " + hero.getHP() + "/25 " + "| " + "Weapon: " + hero.getWeapon() + " | " + "Key: " + hero.getKeyStatus());
            room.printRoom(this.hero); // 현재 방 출력

            System.out.println("Enter command (u/d/l/r to move, a to attack, q to quit): ");
            String command = sc.nextLine();

            //q누르면 움직이지 않고 종료해버리면 되니까 가장 먼저 배치 
            if (command.equals("q")) {
                break;
            }

            if (command.equals("a")) {
                handleAttack();  // 새로 추가되는 메소드
            } else {
                hero.move(command, room.getMap());
                processCell();
            }
            if (!hero.isStillAlive()) {
                System.out.println("You die!");
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

        // 몬스터를 다루는 부분은 handleAttack으로 책임을 다 넘김. processCell은 오직 아이템만 관리 
        // 문 검색
        if (cell == 'd' || cell == 'D') {
            handleDoor(x, y);
        }

    }

    private void handleDoor(int x, int y) {
        for (Renderable r : room.getRenderables()) {
            if (r.getX() == x && r.getY() == y && r instanceof Door) {
                Door door = (Door) r;

                if (door.getSymbol() == 'D') {
                    if (hero.hasKey()) {
                        System.out.println("You used the key and escaped the dungeon!");
                        System.exit(0);  // 게임 종료 (성공)
                    } else {
                        System.out.println("The master door is locked. You need the key.");
                    }
                } else {
                    System.out.println("Moving to next room: " + door.getNextRoomFile());

                    // 현재 방 상태 저장
                    room.saveRoomToFile(copiedFolder + "/" + currentRoomFileName);
                    System.out.println("Moving to next room: " + door.getNextRoomFile());

                    // 새 방 로드
                    String previousRoomFileName = currentRoomFileName;
                    this.currentRoomFileName = door.getNextRoomFile();
                    this.room = new Room(copiedFolder + "/" + currentRoomFileName);

                    // 새 room에서 히어로 위치도 다시 설정
                    // 새 room에서 히어로 위치 설정 (handleDoor 안에 직접 작성 가능)
                    int doorX = -1, doorY = -1;
                    for (Renderable nextR : room.getRenderables()) {
                        if (nextR instanceof Door) {
                            Door nextDoor = (Door) nextR;
                            if (nextDoor.getNextRoomFile().equals(previousRoomFileName)) {
                                doorX = nextDoor.getX();
                                doorY = nextDoor.getY();
                                break;
                            }
                        }
                    }

                    if (doorX == -1) {
                        System.out.println("ERROR: Cannot find return door in the next room.");
                        System.exit(1);
                    }

                    // 8방향 랜덤 스폰 (벽 뚫지 않기)
                    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

                    ArrayList<int[]> emptySpots = new ArrayList<>();
                    for (int i = 0; i < dx.length; i++) {
                        int newX = doorX + dx[i];
                        int newY = doorY + dy[i];

                        if (newX >= 0 && newX < room.getRows() && newY >= 0 && newY < room.getCols()) {
                            char targetCell = room.getMap()[newX][newY];
                            if (targetCell == ' ') {  // 빈 공간일 때만 허용
                                emptySpots.add(new int[]{newX, newY});
                            }
                        }
                    }

                    if (!emptySpots.isEmpty()) {
                        Random rand = new Random();
                        int[] spawn = emptySpots.get(rand.nextInt(emptySpots.size()));
                        hero.setX(spawn[0]);
                        hero.setY(spawn[1]);

                    } else {
                        // 주변 빈 공간 없으면 전체 랜덤
                        int[] randomLoc = room.findRandomEmptySpace();
                        hero.setX(randomLoc[0]);
                        hero.setY(randomLoc[1]);
                    }

                }
                break;
            }
        }
    }

    private void handleAttack() {
        int hx = hero.getX();
        int hy = hero.getY();

        
        for (Renderable r : room.getRenderables()) {
            if (r instanceof Monster) {
                int mx = r.getX();
                int my = r.getY();

                // 인접 판별 : 좌/우/상/하만 확인
                if ((mx == hx - 1 && my == hy - 1)
                        || // ↖
                        (mx == hx - 1 && my == hy)
                        || // ↑
                        (mx == hx - 1 && my == hy + 1)
                        || // ↗
                        (mx == hx && my == hy - 1)
                        || // ←
                        (mx == hx && my == hy + 1)
                        || // →
                        (mx == hx + 1 && my == hy - 1)
                        || // ↙
                        (mx == hx + 1 && my == hy)
                        || // ↓
                        (mx == hx + 1 && my == hy + 1) // ↘
                        ) {
                    handleMonster(mx, my);//있으면 맞다이 할 수 있음
                    return;
                }
            }
        }
        System.out.println("No monster nearby to attack.");
    }

    //웨폰 만났을때 행동 메소드
    private void handleWeapon(int x, int y) {

        Renderable target = null;  // 삭제할 무기를 임시로 기억

        for (Renderable r : room.getRenderables()) {
            if (r.getX() == x && r.getY() == y && r instanceof Weapon) {
                Weapon weapon = (Weapon) r;

                if (!hero.isArmed()) {
                    hero.equipWeapon(weapon);
                    System.out.println("You equipped: " + weapon.getName());
                    target = r;
                } else {
                    System.out.println("You found: " + weapon.getName());
                    System.out.println("You are currently holding: " + hero.getWeapon().getName());
                    System.out.print("Do you want to switch? (y/n): ");
                    String answer = sc.nextLine();

                    if (answer.equals("y")) {
                        hero.equipWeapon(weapon);
                        System.out.println("Switched to: " + weapon.getName());
                        target = r;
                    } else {
                        System.out.println("Kept your current weapon.");
                    }
                }
                break;
            }
        }
        // for문 끝나고 안전하게 remove!
        if (target != null) {
            room.getRenderables().remove(target);
            room.getMap()[x][y] = ' ';
            room.getRawCells()[x][y] = " ";
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
                    room.getRenderables().remove(r);
                    room.getMap()[x][y] = ' ';// 사용한 포션은 제거
                    room.getRawCells()[x][y] = " ";
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
                    room.getMap()[x][y] = ' ';
                    room.getRawCells()[x][y] = " ";
                }
                break;
            }
        }
    }

}
