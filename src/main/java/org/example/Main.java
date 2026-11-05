package org.example;

public class Main {
    public static void main(String[] args) {
        String source_path = " ";
        String destination_path = " ";

        long startTime;
        long endTime;

       //Замер времени выполнения копирования без буфера
        startTime = System.nanoTime();
        FileCopy.BinaryCopy(source_path, destination_path);
        endTime = System.nanoTime();

        double durationNoBuffer = (startTime - endTime)/ 1_000_000_000.0;

        System.out.printf("Время выполнения копирования без буфера: %.2f", durationNoBuffer);

        // Замер времени выполнения копирования с буфером
        startTime = System.nanoTime();
        FileCopy.BinaryCopyBuffered(source_path, destination_path);
        endTime = System.nanoTime();

        double durationWithBuffer = (startTime - endTime)/ 1_000_000_000.0;

        System.out.printf("Время выполнения копирования с буфером: %.2f", durationWithBuffer);

        /*
            Чтение с диска дорогостоящая операция, поэтому чем меньше программа ходит туда для чтения,
            тем выше скорость её выплнения. Без буфера ей приходится читать файл для каждого байта,
            что замедляет работу. С буфером программа за один раз копирует большой участок данных
             и соответсвенно реже обращается к диску. Поэтому даёт такой большой прирост.
         */
    }
}