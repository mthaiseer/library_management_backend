package io.code.library.controller;


import io.code.library.entity.Student;
import io.code.library.request.StudentRequest;
import io.code.library.response.StudentResponse;
import io.code.library.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(@Valid @RequestBody StudentRequest request){

        Student student  =  studentService.createStudent(request.to());
        return StudentResponse.from(student);

    }

    @GetMapping
    public StudentResponse findById(@RequestParam("id") Long id){
        Student student  =  studentService.findById(id);
        return StudentResponse.from(student);
    }


    @GetMapping("/all")
    public List<StudentResponse> findAll(){
        List<Student> student  =  studentService.findAll();
       return  student.stream()
                .map(it-> StudentResponse.from(it))
                .collect(Collectors.toList());
    }




}
