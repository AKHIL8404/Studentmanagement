package com.base.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.base.sms.entity.Student;
import com.base.sms.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}

	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "index";
	}
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Integer id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Integer id,@ModelAttribute("student") Student student,Model model) {
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPhone(student.getPhone());
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	@GetMapping("/find")
	public String searchStudent(@RequestParam("id") Integer id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("students", student);
		return "search";
	}
}
