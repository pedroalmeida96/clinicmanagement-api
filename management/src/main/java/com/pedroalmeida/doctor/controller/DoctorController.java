package com.pedroalmeida.doctor.controller;


import com.pedroalmeida.doctor.model.entity.Doctor;
import com.pedroalmeida.doctor.model.entity.Doctor;
import com.pedroalmeida.doctor.service.DoctorService;
import com.pedroalmeida.shared.Mappings;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @GetMapping(Mappings.GET_ALL_DOCTORS)
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> list = service.getAllDoctors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(Mappings.GET_DOCTOR_BY_ID)
    public ResponseEntity<Doctor> getDoctor(@PathVariable("id") Long id) {
        Optional<Doctor> doctor = service.getById(id);
        return new ResponseEntity(doctor, HttpStatus.OK);
    }

    @PostMapping(Mappings.ADD_DOCTOR)
    public ResponseEntity<Doctor> putDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity(service.insertDoctor(doctor), HttpStatus.CREATED);
    }

    @PutMapping(Mappings.UPDATE_DOCTOR)
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity(service.updateDoctor(doctor), HttpStatus.OK);
    }

    @RequestMapping(value = Mappings.DELETE_DOCTOR, method = {RequestMethod.DELETE})
    public ResponseEntity deleteDoctor(@PathVariable("id") long id) {
        return service.getById(id).map(entity -> {
            service.deleteDoctor(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet(() ->
                new ResponseEntity("Doctor not found.", HttpStatus.BAD_REQUEST));
    }

}

