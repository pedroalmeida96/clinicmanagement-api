package com.pedroalmeida.doctor.controller;


import com.pedroalmeida.doctor.model.entity.Doctor;
import com.pedroalmeida.doctor.service.DoctorService;
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
public class DoctorController {

    @Autowired
    private final DoctorService service;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> list = service.getAllDoctors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

