package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import static org.example.CreateFiles.createFiles;
import static org.example.FileOperations.*;


public class Main {
    public static void main(String[] args) throws IOException {

        String directory = "./"; // Директория, в которой находятся файлы
        backupFiles(directory); // Создаем резервные копии файлов в папке ./backup

        int[][] gameField = {
                {0, 1, 2},
                {2, 1, 0},
                {0, 0, 1}
        }; // Пример поля для игры
        writeGameField("game_field.bin", gameField); // Записываем поле игры в файл

        // Создаем файлы file1.txt, file2.txt, file3.txt
        createFiles();
        createTextFile("file1.txt", "Пример текста для файла 1");
        createTextFile("file2.txt", "Пример текста для файла 2");
        createTextFile("file3.txt", "Пример текста для файла 3");

        addPrefixToFiles("prefix_", "file1.txt", "file2.txt", "file3.txt"); // Добавляем префикс к файлам
    }

    public static void createTextFile(String fileName, String content) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
