package com.assignment.demo.controller;

import com.assignment.demo.model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/add")
public class StudentController {
    List<StudentModel> studentModelList = new ArrayList<>();

    @GetMapping("/requestparam")
    public ResponseEntity<?> requestParam(@RequestParam String name, @RequestParam int age) {
        studentModelList.add(new StudentModel(name, age));
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }

    @GetMapping("/pathvariable/{name}/{age}")
    public ResponseEntity<?> pathVariable(@PathVariable String name, @PathVariable int age) {
        studentModelList.add(new StudentModel(name, age));
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }

    @GetMapping("/requestbody")
    public ResponseEntity<?> requestBody(@RequestBody StudentModel studentModel) {
        studentModelList.add(studentModel);
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }
}
