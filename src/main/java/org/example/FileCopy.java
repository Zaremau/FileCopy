package org.example;

import java.io.*;

public class FileCopy {
    private static final int BUFFER_SIZE = 64 * 1024;

    public static void binaryCopy(String sourcePath, String destinationPath){
        File source = new File(sourcePath);
        File destination = new File(destinationPath);

        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)) {

            int readData = fis.read();
            while (readData != -1){
                fos.write(readData);
                readData = fis.read();
            }

            System.out.println("Файл успешно скопирован без использования буфера");

        } catch (IOException e) {
            throw new  RuntimeException("Ошибка копирования: " + sourcePath, e);
        }
    }

    public static void binaryCopyBuffered(String sourcePath, String destinationPath){
        File source = new File(sourcePath);
        File destination = new File(destinationPath);

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = bis.read(buffer);

            while(bytesRead != -1){
                bos.write(buffer, 0, bytesRead);
                bytesRead = bis.read(buffer);
            }

            System.out.println("Файл успешно скопирован с использованием буфера");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка копирования: " + sourcePath, e);
        }
    }
}
