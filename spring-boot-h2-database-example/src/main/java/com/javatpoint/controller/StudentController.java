package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.javatpoint.model.Student;  
import com.javatpoint.service.StudentService;

//Creating RestController
@RestController

public class StudentController {
	//autowired the StudentService class  
	@Autowired  
	StudentService studentService;  
	//creating a get mapping that retrieves all the students detail from the database   
	@GetMapping("/student")
	
	private List<Student> getAllstudent() {
		return studentService.getAllstudent();
	}
	//creating a delete mapping that deletes a specific student
	@DeleteMapping("/student/{id}")
	private void deleteStudent(@PathVariable("id")int id) {
		studentService.delete(id);
	}
	//creating post mapping that post the student detail in the database
	@PostMapping("/student")
	private int saveStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student.getId();
	}
	
}
