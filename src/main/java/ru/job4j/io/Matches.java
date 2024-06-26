package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        int player = 2;
        while (matches > 0) {
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
            System.out.println("Кол-во спичек: " + matches);
            System.out.println("Ход " + player + " игрока");
            System.out.println("Сколько спичек вы забираете?");
            int select = Integer.valueOf(input.nextLine());
            while (select < 1 || select > 3) {
                System.out.println("Заберите 1, 2, 3 спички. "
                        + "Не больше и не меньше.");
                select = Integer.valueOf(input.nextLine());
            }
            matches -= select;
            if (matches == 0) {
                break;
            }
        }
        System.out.println(player + " игрок выйграл.");
    }
}
