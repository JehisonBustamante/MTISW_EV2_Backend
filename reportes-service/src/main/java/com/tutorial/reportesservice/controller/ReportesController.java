package com.tutorial.reportesservice.controller;

import com.tutorial.reportesservice.entity.ReportesEntity;
import com.tutorial.reportesservice.service.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReportesController {

    @Autowired
    ReportesService studentService;

    @GetMapping
    public ResponseEntity<List<ReportesEntity>> getAll() {
        List<ReportesEntity> students = studentService.getAll();
        if(students.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportesEntity> getById(@PathVariable("id") int id) {
        ReportesEntity student = studentService.getStudentById(id);
        if(student == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

    @PostMapping()
    public ResponseEntity<ReportesEntity> save(@RequestBody ReportesEntity student) {
        ReportesEntity studentNew = studentService.save(student);
        return ResponseEntity.ok(studentNew);
    }

    @GetMapping("/books/{studentId}")
    public ResponseEntity<List<Book>> getBooks(@PathVariable("studentId") int studentId) {
        ReportesEntity student = studentService.getStudentById(studentId);
        if(student == null)
            return ResponseEntity.notFound().build();
        List<Book> books = studentService.getBooks(studentId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/pets/{studentId}")
    public ResponseEntity<List<Pet>> getPets(@PathVariable("studentId") int studentId) {
        ReportesEntity student = studentService.getStudentById(studentId);
        if(student == null)
            return ResponseEntity.notFound().build();
        List<Pet> pets = studentService.getPets(studentId);
        return ResponseEntity.ok(pets);
    }

    @PostMapping("/savebook/{studentId}")
    public ResponseEntity<Book> saveBook(@PathVariable("studentId") int studentId, @RequestBody Book book) {
        if(studentService.getStudentById(studentId) == null)
            return ResponseEntity.notFound().build();
        Book bookNew = studentService.saveBook(studentId, book);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/savepet/{studentId}")
    public ResponseEntity<Pet> savePet(@PathVariable("studentId") int studentId, @RequestBody Pet pet) {
        if(studentService.getStudentById(studentId) == null)
            return ResponseEntity.notFound().build();
        Pet petNew = studentService.savePet(studentId, pet);
        return ResponseEntity.ok(pet);
    }

}
