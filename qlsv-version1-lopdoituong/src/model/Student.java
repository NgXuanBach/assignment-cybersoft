package model;

public class Student {
    private String name;
    private int age;
    private String gender;
    private float mathScores;
    private float physicScores;
    private float chemistryScores;

    public float getMathScores() {
        return mathScores;
    }

    public void setMathScores(float mathScores) {
        this.mathScores = mathScores;
    }

    public float getPhysicScores() {
        return physicScores;
    }

    public void setPhysicScores(float physicScores) {
        this.physicScores = physicScores;
    }

    public float getChemistryScores() {
        return chemistryScores;
    }

    public void setChemistryScores(float chemistryScores) {
        this.chemistryScores = chemistryScores;
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.gender = sex;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }
}
