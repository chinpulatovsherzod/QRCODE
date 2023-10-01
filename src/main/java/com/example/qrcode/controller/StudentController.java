package com.example.qrcode.controller;

import com.example.qrcode.model.Student;
import com.example.qrcode.service.StudentService;
import com.example.qrcode.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws IOException, WriterException {
        List<Student> students = studentService.getStudent();
        if (students.size() != 0) {
            for (Student student: students) {
                QRCodeGenerator.generatorQRcode(student);
                
            }
        }
        return ResponseEntity.ok(studentService.getStudent());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }


}
