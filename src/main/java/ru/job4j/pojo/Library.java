package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean Code", 464);
        Book second = new Book("Holy Bible", 1500);
        Book third = new Book("Koran", 900);
        Book fourth = new Book("Russian-English translator", 600);
        Book[] library = new Book[4];
        library[0] = first;
        library[1] = second;
        library[2] = third;
        library[3] = fourth;
        for (int index = 0; index < library.length; index++) {
            Book ml = library[index];
            System.out.println(ml.getName() + System.lineSeparator() + ml.getPagesQuantity());
        }
        Book mlt = library[0];
        library[0] = library[3];
        library[3] = mlt;
        for (int index = 0; index < library.length; index++) {
            Book mlx = library[index];
            System.out.println(mlx.getName() + System.lineSeparator() + mlx.getPagesQuantity());
        }
        for (int index = 0; index < library.length; index++) {
            if (library[index].getName().equals("Clean Code")) {
                Book mlf = library[index];
                System.out.println(mlf.getName() + System.lineSeparator() + mlf.getPagesQuantity());
            }
        }
    }
}
