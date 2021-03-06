/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import model.Group;
import model.Student;

/**
 *
 * @author Serdar
 */
public class GroupSet {

    public static final int MAX_SIZE = 32;
    public static final int ROUTE_MAX = 5;
    public static final int GROUP_START = 20000;
    public static int groupsPerRoute = 0;
    public static int totalGroups = 0;
    public static int studentsPerRoute = 0;
    public static int amountCompared = 0;
    private int totalStudents = 0;
    private Group[] groups;
    private List<Student> students = new ArrayList();

    public GroupSet(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public void createStudents() {
        int groupIndex = 0;

        for (int i = 0; i < totalStudents; i++) {
            if (groupIndex == groups.length) {
                groupIndex = 0;
            }
            Group currentGroup = groups[groupIndex++];
            Student s = new Student(currentGroup);
            students.add(s);
            currentGroup.add(s);
        }
    }

    public List<Student> getStudents() {
        return students;
    }
    

    public void createGroups() {
        if (totalStudents <= 0) {
            System.err.println("Failed to create groups, Because no humans were found..(╯°□°）╯︵ ┻━┻)");
        } else {
            studentsPerRoute = (int) Math.ceil(totalStudents / (double) ROUTE_MAX);
            groupsPerRoute = (int) Math.ceil((double) studentsPerRoute / MAX_SIZE);
            totalGroups = groupsPerRoute * ROUTE_MAX;

            groups = new Group[totalGroups];
            String[] route = new String[]{"B", "G", "N", "S", "T"};
            int routeCurrent = 0;
            int groupNum = 0;

            for (int i = 0; i < groups.length; i++) {
                if (routeCurrent == ROUTE_MAX) {
                    routeCurrent = 0;
                }
                if (i % 5 == 0) {
                    groupNum++;
                }
                groups[i] = new Group("I" + route[routeCurrent++] + (GROUP_START + groupNum));
            }
            System.out.println("Total students: " + totalStudents);
            System.out.println("Students per route: " + studentsPerRoute);
            System.out.println("Groups per route: " + groupsPerRoute);
            System.out.println("Total groups of students: " + totalGroups);
            System.out.println("");
        }
    }

    public Group[] getGroups() {
        return groups;
    }

     public void sortByGrade(List<Student> students) {
         
        for (int i = 0; i < students.size() - 1; i++) {
            for (int k = i + 1; k < students.size(); k++) {
                // Compare left to right, not right to left.
                amountCompared++;
                if (students.get(i).getGrade() < students.get(k).getGrade()) {
                    Student temp = students.get(i);
                    students.set(i, students.get(k));
                    students.set(k, temp);
                }
            }
        }
    }
}
