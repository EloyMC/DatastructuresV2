/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Comparator;
import model.Student;


/**
 *
 * @author Serdar
 */
public class StudentNoComparator implements Comparator<Student> {

    public static int amountCompared = 0;
    @Override
    public int compare(Student a, Student b) {
        amountCompared++;
        
        if (b.getStudentNum() < a.getStudentNum()) {
            return 1;
        } else if (b.getStudentNum() > a.getStudentNum()) {
            return -1;
        } else {
            return 0;
        }        
    }
    
}
