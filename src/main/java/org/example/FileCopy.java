package org.example;

import java.io.*;

public class FileCopy {

    public static void BinaryCopy(String sourcePath, String destinationPath){
        File source = new File(sourcePath);
        File destination = new File(destinationPath);

        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)) {

            int readData = fis.read();
            while (readData != -1){
                fos.write(readData);
                readData = fis.read();
            }

            System.out.println("Объект успешно скопирован без использования буфера");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void BinaryCopyBuffered(String sourcePath, String destinationPath){
        File source = new File(sourcePath);
        File destination = new File(destinationPath);

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[1024 * 64];
            int bytesRead = bis.read(buffer);

            while(bytesRead != -1){
                bos.write(buffer, 0, bytesRead);
                bytesRead = bis.read(buffer);
            }

            bos.flush();
            System.out.println("Объект успешно скопирован с использованием буфера");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
