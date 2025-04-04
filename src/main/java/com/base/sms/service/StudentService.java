package com.base.sms.service;

import java.util.List;

import com.base.sms.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student stdent);
	
	Student getStudentById(Integer id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Integer id);
	
}
