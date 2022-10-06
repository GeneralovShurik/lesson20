package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Test test = new Test();
        test.start();// не run
        test.join();//дождаться пока метод run не выполнится
        System.out.println("sdkj");
        // строки
        // массивы коллекции
        // ооп

        // 1, работа со строками (работать со строкой как с набором символов, уметь изменять код символа в строке)
        // любая строка массив char
        String s = "hello";
        char a = 'a';
        char b = 0;
        // A...Za..z
        for (char c : s.toCharArray()){
            System.out.println((int)c);//явно приводим к int, выводим коды каждой буквы
        }

        System.out.println(toUpperCase("sdAggH %%! iI вВ"));

        // 2.дан массив любых целых чисел, особым образом его преобразовать, элементы менять местами
         // сортировка методом пузырька
        // Bubble sort
        // цикл в цикле

        int [] arr = {12,20,1,9,52,66,3,7,9};
        sort(arr);
        for(int e : arr) {
            System.out.println(e);
        }



        //3, потоки, чтение и запись текстовых файлов
        //в задании прочитанные данные превратить в строку
        // будем знать количество симолов и где какие данные находятся
        FileWriter fw = new FileWriter("1.txt");//создаем файл
        Thread t1 = new Thread(()-> { //создаем поток
            try {
                synchronized (fw) {
                fw.write("hello");
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()-> { //создаем поток
            try {
                synchronized (fw) {
                fw.write("world");
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

       // fw.write("hello!");// пишем
        fw.flush();//записываем после завершения потоков
        fw.close();//закрываем

        //что бы прочитать файл
        FileReader fr = new FileReader("1.txt");//важно наличие файла на диске иначе exception

        ///////////////потоки

        char [] data = new char[6];//создаем что бы передать количество
        fr.read(data);//2 перегрузка если знаем количество
        fr.close();
        String s2 = new String(data);
        char first = s2.charAt(0);
        char last = s2.charAt(s2.length() - 1);
        System.out.println(first + " " + last);

        System.out.println(new String(data));

        ///рандом
        Random rand = new Random();
        rand.nextInt(10); // [0;10]

    }
    public static void sort(int[]toSort){
        for (int i = 0; i < toSort.length-1; i++) {
            for (int j = i + 1; j < toSort.length; j++) {
                if(toSort [i] > toSort [j]) {
                    int tmp = toSort [i]; // меняем местами для этого создаем промежуточную переменную
                    toSort [i] = toSort [j];
                    toSort [j] = tmp;
                }

            }

        }

    }

    public static String toUpperCase (String s){//строчные букыв в заглавные
        // s => [a...zA...Z +' ']
        // s = "aabb'
        //найдем смещение большой и маленькой буквы
        int offset = 'a' - 'A';//a=150 A= 100 offset = 50 lдля английского алфавита
        if(offset < 0){
           // Math.abs();//возвращает по модулю
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                c -= offset;
               // с = с- offset;//если разница отрицательна
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
