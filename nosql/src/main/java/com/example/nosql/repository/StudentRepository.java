package com.example.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.nosql.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

}
