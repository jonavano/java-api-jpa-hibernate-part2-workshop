package com.booleanuk.api.controller;

import com.booleanuk.api.model.Department;
import com.booleanuk.api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;

    @GetMapping
    public List<Department> getAll(){
        return this.repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Department> PostDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(this.repository.save(department), HttpStatus.CREATED);
    }
}
