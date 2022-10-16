package client.reader;

import java.util.Scanner;

public class Reader {
    public String[] read() {
        System.out.println("Введите команду:");
        Scanner scanner = new Scanner(System.in);
        String[] arraysOfParams;
        System.out.print("~ ");
        arraysOfParams = scanner.nextLine().trim().split(" ");

        if (arraysOfParams[0].equals("")) {
            System.out.println("Вы не ничего не ввели, попробуйте ввести команду ещё раз.");
            read();
        }
        return arraysOfParams;
    }
}