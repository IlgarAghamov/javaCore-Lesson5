package org.example;

import java.io.*;

public class CreateFiles {

    public static void createFiles() {
        try {
            // Создание файла с состоянием игры
            int[] gameState = {0, 1, 2, 2, 1, 0, 0, 0, 1};
            writeGameState("game_state.bin", gameState);

            // Создание файлов с данными
            writeTextFile("file1.txt", "Пример текста для файла 1");
            writeTextFile("file2.txt", "Пример текста для файла 2");
            writeTextFile("file3.txt", "Пример текста для файла 3");

            System.out.println("Файлы успешно созданы.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTextFile(String fileName, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(content);
        }
    }

    public static void writeGameState(String filePath, int[] gameState) throws IOException {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (int state : gameState) {
                outputStream.writeByte(state);
            }
        }
    }
}