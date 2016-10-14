/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.SecureRandom;

/**
 *
 * @author Serdar
 */
public class Student {

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

    public int getStudentNum() {
        return studentNum;
    }

    private void setStudentNum() {
        studentNum = ++studentNumStart;
    }

    public Group getGroup() {
        return group;
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
}
