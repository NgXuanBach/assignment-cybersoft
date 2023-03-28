package main;

import handle.StudentHandler;

public class main {
    public static void main(String[] args) {
        StudentHandler student = new StudentHandler();
        student.inputStudent();
        student.avgOfStudent();
        student.outputStudent();
        student.studentRank();
    }
}
