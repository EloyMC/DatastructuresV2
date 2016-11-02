package nl.hva.dmci.ict.datastructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Small program that creates a file which can be used for the practical lab 3
 * of the course Datastructures.
 *
 * @author Dennis Breuker
 * @author Nico Tromp
 */
public class StudentHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        StudentList students = new StudentList(10000);
        //System.out.println(students);
        int[] hashCount = new int[97];
        
        for (int i = 0; i < students.getList().length; i++) {
            int ldapHashVal = ldapHashCode(students.getList()[i].getLdap()) % 97;
            for (int j = 0; j < hashCount.length; j++) {
                if (ldapHashVal == j) {
                    hashCount[j]++;
                }
            }
            //System.out.println("LDAP real: " + s.getLdap());
            //System.out.println("Hascode: " + ldapHashCode(s.getLdap()));
            //System.out.println(ldapHashCode(students.getList()[i].getLdap()) + " - " + ldapHashCode(students.getList()[i].getLdap()) % 97);
        }

        int[] hashIndex = new int[97];
        for (int i = 0; i < hashIndex.length; i++) {
            hashIndex[i] = i;
        }
        //System.out.println(Arrays.toString(hashIndex));
        //System.out.println(Arrays.toString(hashCount));
        
        /*try (BufferedWriter br = new BufferedWriter(new FileWriter("hashCount.csv"))) {
            StringBuilder sb = new StringBuilder();
            for (int element : hashCount) {
                sb.append(element);
                sb.append("\n");
            }
            
            br.write(sb.toString());
        }*/
        System.out.println(ldapHashCode("nijl1") % 97);
    }

    public static int ldapHashCode(String ldap) {
        int hash = 0;
        for (int i = 0; i < ldap.length(); i++) {
            hash = ldap.charAt(i) + (31 * hash);
        }
        return Math.abs(hash);
    }

}
