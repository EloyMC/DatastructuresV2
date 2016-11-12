/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.Hashtable;
import nl.hva.dmci.ict.datastructures.StudentList;

/**
 *
 * @author Serdar
 */
public class QuadraticProbing extends Hashtable<Integer, Object> {

    private int maxSize;
    private int[] collisionCount;

    public QuadraticProbing(int maxSize) {
        this.maxSize = maxSize;
        collisionCount = new int[maxSize];
    }

    public static int hash(String ldap) {
        int hash = 0;
        for (int i = 0; i < ldap.length(); i++) {
            hash = ldap.charAt(i) + (31 * hash);
        }
        return Math.abs(hash);
    }

    @Override
    public synchronized Object put(Integer key, Object value) {
        int tmpKey = key;
        int steps = 0;
        if (tmpKey != maxSize) {
            while (super.containsKey(tmpKey)) {
                ++collisionCount[tmpKey];
                //System.out.println("unchanged key: " + tmpKey);
                tmpKey = (tmpKey + ((int) Math.pow(++steps, 2))) % maxSize;
                //System.out.println("changed key: " + tmpKey);
            }
        }
        
        return super.put(tmpKey, value);
    }

    public int getCollisionCount(int index) {
        return collisionCount[index];
    }

    public static void main(String[] args) {
        StudentList students = new StudentList(10000);
        //System.out.println(students);
        //10.501, 11.701, 13.309, 15.401
        // Create custom hash table, insert ldap, 
        QuadraticProbing qp = new QuadraticProbing(15401);

        for (int i = 0; i < students.getList().length; i++) {
            int hashIndex = hash(students.getList()[i].getLdap()) % qp.maxSize;
            System.out.println("hashIndex: " + hashIndex);
            qp.put(hashIndex, students.getList()[i]);
        }

        int totalCollisions = 0;
        for (int i = 0; i < qp.maxSize; i++) {
            totalCollisions += qp.getCollisionCount(i);
            System.out.println((i + 1) + ": " + qp.get(i) + " - " + qp.getCollisionCount(i) + " collisions occured.");
        }
        System.out.println("");
        System.out.println("Total collisions of "+qp.maxSize+" spots: " + totalCollisions);
    }
}
