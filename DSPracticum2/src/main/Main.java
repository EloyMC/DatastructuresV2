/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

        GroupSet gen = new GroupSet(400);
        gen.createGroups(); // Create groups
        gen.createStudents(); // Create students + assign to group

        Collections.shuffle(gen.getStudents()); // Shuffle list of students
        // Sort students by the assigned comparator by high grades to low grades of students
        Comparator<Student> compStudent = new Student(null);
        Collections.sort(gen.getStudents(), compStudent);

//        System.out.println("################## List of Students ##################");
//        for(Student s : gen.getStudents()) {
//            System.out.println(s);
//        }
        GroupComparator groupC = new GroupComparator();
        Arrays.sort(gen.getGroups(), groupC);
        for (Group g : gen.getGroups()) {
            StudentNoComparator compStudentNo = new StudentNoComparator();
            Collections.sort(g, compStudentNo); // comparator to sort studentnr
            for (int i = 0; i < g.size(); i++) {
                System.out.println(g.get(i));
            }
            System.out.println(g.size());
        }
    }

}
