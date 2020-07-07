package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDate("22.06.2020");
        student.setGroup("first");
        student.setName("Tsarukyan Andrey Vardazarovich");
        System.out.println("Student " + student.getName()
                + " in group " + student.getGroup()
                + " entered " + student.getDate());
    }
}
