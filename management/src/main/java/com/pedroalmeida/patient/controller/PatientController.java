package com.pedroalmeida.patient.controller;


import com.pedroalmeida.patient.model.entity.Patient;
import com.pedroalmeida.patient.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
@AllArgsConstructor
public class PatientController {

    @Autowired
    private final PatientService service;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> list = service.getAllPatients();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

