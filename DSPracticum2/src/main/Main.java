/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import model.Group;
import model.Student;
import sort.GroupComparator;
import sort.StudentNoComparator;

/**
 *
 * @author Serdar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GroupSet gen = new GroupSet(160000);
        gen.createGroups(); // Create groups
        gen.createStudents(); // Create students + assign to group

        Collections.shuffle(gen.getStudents(), Student.getSEC()); // Shuffle list of students
        // Sort students by the assigned comparator by high grades to low grades of students
//        long startT = System.nanoTime();
//        gen.sortByGrade(gen.getStudents());
//        long endT = System.nanoTime();
//        long diff = endT - startT;
//        long nanoToMill = TimeUnit.NANOSECONDS.toMillis(diff);
//        
//        System.out.println("################## List of Students ##################");
//        for (Student s : gen.getStudents()) {
//            System.out.println(s);
//        }
//        System.out.println("\n");

        GroupComparator groupC = new GroupComparator();
        Arrays.sort(gen.getGroups(), groupC);

        for (Group g : gen.getGroups()) {
            StudentNoComparator compStudentNo = new StudentNoComparator();
            Collections.sort(g, compStudentNo);
// comparator to sort studentnr
//            for (int i = 0; i < g.size(); i++) {
//                System.out.println(g.get(i));yyyy
//            }
//            System.out.println("STUDENTS PER GROUP: " + g.size());

        }

        System.out.println("Amount of grade comparisons: " + Student.amountCompared);
        System.out.println("Amount of student comparisons: " + StudentNoComparator.amountCompared);
        System.out.println("Amount of group comparisons: " + GroupComparator.amountCompared);
        System.out.println("Amount of bubblegrade comparisons: " + GroupSet.amountCompared);
    }

}
