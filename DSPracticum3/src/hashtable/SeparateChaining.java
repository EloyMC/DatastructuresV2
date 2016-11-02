/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.Hashtable;
import java.util.LinkedList;
import nl.hva.dmci.ict.datastructures.StudentList;

/**
 *
 * @author Serdar
 */
public class SeparateChaining {

    private int N; // number of key-value pairs
    private int M; // hash table size
    //private HashT1 st;

    /*public SeparateChaining(int M) { // Create M linked lists.
        this.M = M;
        //..ll = new LinkedList();
        for (int i = 0; i < M; i++) {
            //ll[i] = new SequentialSearchST(); // create linkedlist
        }
    }*/
    public static int hash(String ldap) {
        int hash = 0;
        for (int i = 0; i < ldap.length(); i++) {
            hash = ldap.charAt(i) + (31 * hash);
        }
        return Math.abs(hash);
    }

    public static void main(String[] args) {
        StudentList students = new StudentList(10000);
        //System.out.println(students);

        // Create custom hash table, insert ldap, 
        Hashtable<Integer, Object> ht = new Hashtable();

        for (int i = 0; i < students.getList().length; i++) {
            int hashIndex = hash(students.getList()[i].getLdap()) % 97;

            if (ht.get(hashIndex) instanceof LinkedList) { // Linkedlist found, add new collision to list         
                ((LinkedList)ht.get(hashIndex)).add(students.getList()[i]);
            } else if (ht.containsKey(hashIndex)) { // First item has collision, create linkedlist
                LinkedList ll = new LinkedList();
                ll.add(ht.get(hashIndex));
                ht.put(hashIndex, ll);
            } else { // New item
                ht.put(hashIndex, students.getList()[i]);
            }
        }

        for (int i = 0; i < ht.size(); i++) {
            System.out.println(i + ": " + ht.get(i));
        }

        System.out.println();
    }
}
