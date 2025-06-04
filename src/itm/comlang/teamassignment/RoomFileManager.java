/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 * RoomFileManager 클래스는 게임 시작 시 원본 rooms 폴더에 있는 CSV 파일들을 새로운 세션 폴더로 복사하는 기능을
 * 담당한다.
 *
 * 복사된 경로는 "game_runs/run_YYYYMMDD_HHmmss" 형태로 생성되며, Game 클래스에서 해당 경로의 room 파일을
 * 로드하여 게임을 진행할 수 있다.
 *
 * 예시 사용: String path = RoomFileManager.copyRoomsToNewFolder("rooms"); Room room
 * = new Room(path + "/room1.csv");
 *
 * @author ohkyounghun
 *
 */
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomFileManager {

    public static String copyRoomsToNewFolder(String sourceFolder) {
        // 1. 날짜 기반 폴더 이름 생성
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folderName = "run_" + timestamp;

        // 2. 최종 복사될 폴더 경로
        Path destFolder = Paths.get("game_runs/" + folderName);

        try {
            // 3. 복사 폴더 생성
            Files.createDirectories(destFolder);

            // 4. .csv 파일만 골라 복사
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(sourceFolder), "*.csv");

            for (Path file : stream) {
                Path dest = destFolder.resolve(file.getFileName());
                Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING);
            }

            // 5. 완료 메시지 및 경로 반환
            System.out.println("Copy Complete: " + destFolder.toString());
            return destFolder.toString();

        } catch (IOException e) {
            System.out.println("Copy Error: " + e.getMessage());
            return null;
        }
    }
}
