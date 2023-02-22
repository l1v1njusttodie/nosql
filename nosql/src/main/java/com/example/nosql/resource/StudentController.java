package com.example.nosql.resource;

import java.util.List;
import java.util.Optional;

import com.example.nosql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nosql.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@PostMapping("/addStudent")
	public String saveStudent(@RequestBody Student student) {
		repository.save(student);
		return "Added student with id : " + student.getId();
	}

	@GetMapping("/findAllStudent")
	public List<Student> getStudent() {
		return repository.findAll();
	}

	@GetMapping("/findAllStudent/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		repository.deleteById(id);
		return "student deleted with id : " + id;
	}

}
