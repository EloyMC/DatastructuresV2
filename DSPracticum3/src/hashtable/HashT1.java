/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author Serdar
 */
public class HashT1<Key, Value> extends Hashtable {

    @Override
    public synchronized Object put(Object k, Object v) {
        return super.put(k, v); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public int hash(String ldap) {
        int hash = 0;
        for (int i = 0; i < ldap.length(); i++) {
            hash = ldap.charAt(i) + (31 * hash);
        }
        return Math.abs(hash);
    }
}
