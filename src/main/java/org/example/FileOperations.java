package org.example;

import java.io.*;
import java.nio.file.*;

public class FileOperations {

    public static void backupFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File backupDir = new File(directory, "backup");
        backupDir.mkdir(); // Создаем папку для резервных копий
        File[] files = directory.listFiles(File::isFile); // Получаем список файлов в директории
        if (files != null) {
            for (File file : files) {
                try {
                    Files.copy(file.toPath(), Paths.get(backupDir.getPath(), file.getName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeGameField(String filePath, int[][] gameField) {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (int[] row : gameField) {
                for (int value : row) {
                    // Записываем каждое значение в 1 байт
                    outputStream.writeByte(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addPrefixToFiles(String prefix, String... files) {
        for (String fileName : files) {
            File file = new File(fileName);
            if (file.exists()) {
                String newFileName = prefix + file.getName();
                file.renameTo(new File(file.getParent(), newFileName));
                System.out.println("Файл " + fileName + " переименован в " + newFileName);
            } else {
                System.out.println("Файл " + fileName + " не существует.");
            }
        }
    }
}