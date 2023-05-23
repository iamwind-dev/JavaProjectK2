/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Student;

/**
 *
 * @author WinD
 */
public interface StudentDaoInterface {
           List<Student> getStudents();
    void addStudent(Student student);
    
    void updateStudent(Student student);
    
    void deleteStudent(String id);
}
