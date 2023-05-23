/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author duong
 */
public class Student {

    ArrayList<Student> mylist = new ArrayList<>();

    public ArrayList<Student> getMylist() {
        return mylist;
    }

    public void setMylist(ArrayList<Student> mylist) {
        this.mylist = mylist;
    }
    private String ID;
    private String name;
    private String address;

    public Student() {
    }

    public Student(String ID, String name, String classs, String phonenumber, String sex, String address) {
        this.ID = ID;
        this.name = name;

        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object[] toArray() {
        return new Object[]{ID, name, address};
    }

    @Override
    public String toString() {
        return "Student{" + "mylist=" + mylist + ", ID=" + ID + ", name=" + name + ", address=" + address + '}';
    }
}
