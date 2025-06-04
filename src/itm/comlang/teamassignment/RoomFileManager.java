/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 * RoomFileManager 클래스는 게임 시작 시 원본 rooms 폴더에 있는
 * CSV 파일들을 새로운 세션 폴더로 복사하는 기능을 담당한다.
 *
 * 복사된 경로는 "game_runs/run_YYYYMMDD_HHmmss" 형태로 생성되며,
 * Game 클래스에서 해당 경로의 room 파일을 로드하여 게임을 진행할 수 있다.
 *
 * 예시 사용:
 *   String path = RoomFileManager.copyRoomsToNewFolder("rooms");
 *   Room room = new Room(path + "/room1.csv");
 *
 * @author ohkyounghun
 * 
 */

import java.io.IOException;
import java.nio.file.*;

public class RoomFileManager {

    /**
     * 원본 rooms 폴더에서 .csv 파일들을 복사하여
     * 새로운 실행용 하위 폴더(game_runs/run_날짜시간)를 생성하고
     * 그 안에 복사해주는 메서드.
     *
     * @param sourceFolder 복사할 원본 폴더 경로 (예: "rooms")
     * @return 복사된 새 폴더 경로 (예: "game_runs/run_20250604_174500"), 실패 시 null
     */
    public static String copyRoomsToNewFolder(String sourceFolder) {
        // 1. 폴더 이름 만들
        String folderName = "CopyRooms";

        // 2. 최종 복사될 폴더 경로 지정
        Path destFolder = Paths.get("game_runs/run_" + folderName);

        try {
            // 3. 복사될 폴더가 없으면 자동 생성
            Files.createDirectories(destFolder);

            // 4. 원본 폴더에서 .csv 파일만 선택
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(sourceFolder), "*.csv");

            // 5. 각 .csv 파일을 새기 폴더로 복사
            for (Path file : stream) {
                Path dest = destFolder.resolve(file.getFileName()); // 복사 대상 경로
                Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING); // 파일 복사 수행
            }

            // 6. 성공 메시지 + 경로 반환
            System.out.println("Copy Complete: " + destFolder.toString());
            return destFolder.toString();

        } catch (IOException e) {
            // 복사 도중 에러 발생 시
            System.out.println("Copy Error: " + e.getMessage());
            return null;
        }
    }
}