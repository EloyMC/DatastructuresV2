/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Comparator;
import model.Group;

/**
 *
 * @author Serdar
 */
public class GroupComparator implements Comparator<Group> {
    
    @Override
    public int compare(Group a, Group b) {
        if (b.getGroupID().charAt(1) < a.getGroupID().charAt(1)) {
            return 1;
        } else if (b.getGroupID().charAt(1) > a.getGroupID().charAt(1)) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
