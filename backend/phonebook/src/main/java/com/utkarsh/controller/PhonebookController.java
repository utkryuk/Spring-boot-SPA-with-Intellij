package com.utkarsh.controller;

import com.utkarsh.model.Phonebook;
import com.utkarsh.service.impl.PhoneBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phonebook")
public class PhonebookController {

    @Autowired
    private PhoneBookServiceImpl phoneService;

    @GetMapping(path = "")
    public ResponseEntity<List<Phonebook>> getAll() {
        return ResponseEntity
                .ok(phoneService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getRecordById(@PathVariable(value = "id") String id) {
        Phonebook record = phoneService.getRecordById(id);
        if (record != null) {
            return ResponseEntity.ok(record);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No record exists");
    }

    @PostMapping(path = "")
    public ResponseEntity<Phonebook> addRecord(@RequestBody Phonebook record) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(phoneService.addRecord(record));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateRecordById(@RequestBody Phonebook record, @PathVariable(value = "id") String id) {
        Phonebook returnRecord = phoneService.updateRecordById(record, id);
        if (returnRecord != null) {
            return ResponseEntity
                    .ok(returnRecord);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No record exists");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteRecordById(@PathVariable(value = "id") String id) {
        Boolean isDeleted = phoneService.deleteRecordById(id);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Record Deleted Successfully");
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No record exists");
    }

}
