package handle;

import model.Student;

import java.util.Scanner;

public class StudentHandler implements IStudentHandler {
    Scanner scanner = new Scanner(System.in);
    private Student student = new Student();

    @Override
    public void inputStudent() {
        System.out.println("Enter student name: ");
        student.setName(scanner.nextLine());
        System.out.println("Enter student age");
//        scanner.next();
        student.setAge(scanner.nextInt());
        System.out.println("Enter sex of student: ");
        scanner.nextLine();
        student.setGender(scanner.nextLine());
        System.out.println("Enter math scores of student: ");
        student.setMathScores(scanner.nextFloat());
        System.out.println("Enter physics scores of student: ");
        student.setPhysicScores(scanner.nextFloat());
        System.out.println("Enter chemistrys scores of student: ");
        student.setChemistryScores(scanner.nextFloat());
        System.out.println("Done !");
    }

    @Override

    public void outputStudent() {
        System.out.println("Student name: " + student.getName());
        System.out.println("Student age: " + student.getAge());
        System.out.println("Student gender: " + student.getGender());
        System.out.println("Math scores of student: " + student.getMathScores());
        System.out.println("Physics scores of student: " + student.getPhysicScores());
        System.out.println("Chemistrys scores of student: " + student.getChemistryScores());
        System.out.println("Done !");
    }

    @Override

    public float avgOfStudent() {
        return (student.getMathScores() + student.getChemistryScores() + student.getPhysicScores()) / 3;
    }

    @Override

    public void studentRank() {
        float avgScores = avgOfStudent();
        if (avgScores >= 8)
            System.out.println("Xep loai gioi");
        else if (avgScores >= 6.5)
            System.out.println("Xep loai kha");
        else
            System.out.println("Xep loai trung binh");
    }
}
