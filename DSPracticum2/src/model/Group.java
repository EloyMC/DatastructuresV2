/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author Serdar
 * @param <Student>
 */
public class Group<Student> extends LinkedList<Student> {
    
    private String groupID;

    @Override
    public boolean add(Student e) {
        return super.add(e);
    }

    public Group(String groupID) {
        this.groupID = groupID;
    }
    
    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    @Override
    public String toString() {
        return groupID;
    }
    
    
}
