package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String words = "Песня не найдена";
        if (position == 1) {
            words = "Пусть бегут неуклюже";
        } else if (position == 2) {
            words = "Спокойной ночи";
        }
        System.out.println(words);
    }

    public static void main(String[] args) {
        Jukebox cafe = new Jukebox();
        int song = 3;
        cafe.music(song);
    }
}
