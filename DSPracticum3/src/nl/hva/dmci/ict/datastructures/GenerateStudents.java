
package nl.hva.dmci.ict.datastructures;

/**
 * Small program that creates a file which can be used for the practical lab
 * 3 of the course Datastructures.
 * 
 * @author Dennis Breuker
 * @author Nico Tromp
 */
public class GenerateStudents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentList students = new StudentList(10000);
        System.out.println(students);
    }
    
}
