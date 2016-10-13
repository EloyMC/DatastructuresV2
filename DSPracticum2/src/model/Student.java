/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.SecureRandom;
import java.util.Comparator;

/**
 *
 * @author Serdar
 */
public class Student implements Comparator<Student> {

    public static int studentNumStart = 50060000;
    private static final SecureRandom SEC = new SecureRandom();
    public static int amountCompared = 0;
    
    private int studentNum;
    private Group group;
    private double grade;

    public static SecureRandom getSEC() {
        return SEC;
    }

    public Student(Group group) {
        setStudentNum();
        this.grade = setGrade();
        this.group = group;
    }

    public static String addSpecialization(int current) {
        String special;
        switch (current) {
            case 1:
                special = "B";
                break;
            case 2:
                special = "G";
                break;
            case 3:
                special = "N";
                break;
            case 4:
                special = "S";
                break;
            case 5:
                special = "T";
                break;
            default:
                special = "B";
        }
        return special;
    }

    public int getStudentNum() {
        return studentNum;
    }

    private void setStudentNum() {
        studentNum = ++studentNumStart;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public double getGrade() {
        return grade;
    }

    private double setGrade() {
        //this.grade = (double) Math.round(1 + (Math.random() * 10) * 10d) / 10d;
        return SEC.nextInt(91) / 10.0 + 1;
    }
    
    @Override
    public String toString() {
        return "Studentnr: " + studentNum + "\tGrade: " + grade + "\tGroup: " + group;
    }
    
    @Override
    public int compare(Student a, Student b) {
        amountCompared++;
        if (b.getGrade() > a.getGrade()) {
            return 1;
        } else if (b.getGrade() < a.getGrade()) {
            return -1;
        } else {
            return 0;
        }
    }

}
