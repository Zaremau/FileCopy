package org.example;

public class Main {

    public static void main(String[] args) {
        String sourcePath = ""; // например: "C:/files/source.mp4"
        String destinationPath = ""; // например: "C:/files/copy.mp4"


        long startTime;
        long endTime;

        //Замер времени выполнения копирования без буфера
        startTime = System.nanoTime();
        FileCopy.binaryCopy(sourcePath, destinationPath);
        endTime = System.nanoTime();

        double durationNoBuffer = (endTime - startTime)/ 1_000_000_000.0;

        System.out.printf("Время выполнения копирования без буфера: %.2f \n", durationNoBuffer);

        // Замер времени выполнения копирования с буфером
        startTime = System.nanoTime();
        FileCopy.binaryCopyBuffered(sourcePath, destinationPath);
        endTime = System.nanoTime();

        double durationWithBuffer = (endTime - startTime)/ 1_000_000_000.0;

        System.out.printf("Время выполнения копирования с буфером: %.2f \n", durationWithBuffer);


        /*Лог после копирования файла размеров в 154 мг двумя методами:
            Файл успешно скопирован без использования буфера
            Время выполнения копирования без буфера: 956,04
            Файл успешно скопирован с использованием буфера
            Время выполнения копирования с буфером: 0,17

            Классы BufferedInputStream/ BufferedOutputStream позволяют копировать через буфер,
            но для большей наглядности я использовала ещё дополнительный буфер  byte[] buffer.
            Время копирования с буфером сократилось в 5 623,77 раз. Это объясняется тем,
            что метод без буфера делает многократно больше системных вызовов read()/write(),
             поэтому у него гораздо выше оверхэд.
         */
    }
}