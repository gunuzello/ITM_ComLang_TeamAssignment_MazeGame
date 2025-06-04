/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itm.comlang.teamassignment;

/**
 *
 * @author ohkyounghun
 */
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RoomFileManager {

    public static String copyRoomsToNewFolder(String sourceFolder) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path destFolder = Paths.get("game_runs/run_" + timestamp);

        try {
            Files.createDirectories(destFolder);

            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(sourceFolder), "*.csv");

            for (Path file : stream) {
                Path dest = destFolder.resolve(file.getFileName());
                Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING);
            }

            System.out.println("Copy Complete: " + destFolder.toString());
            return destFolder.toString();
        } catch (IOException e) {
            System.out.println("Copy Error: " + e.getMessage());
            return null;
        }
    }
}