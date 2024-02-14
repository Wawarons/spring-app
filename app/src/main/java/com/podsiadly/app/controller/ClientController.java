package com.podsiadly.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.podsiadly.app.model.Patient;
import com.podsiadly.app.service.PatientService;

@RestController
public class ClientController {
  // Service
  @Autowired
  private PatientService patientService;

  @GetMapping(path = "/")
  public String hello_world() {
    return "hello_world";
  }

  // add new patient
  @PostMapping(path = "/add")
  public String addPatient(@RequestBody Patient patient) {
    patientService.addPatient(patient);
    return "Patient add successfuly...";
  }

  // getPatientById
  @GetMapping(path = "/patient/{id}")
  public Patient getPatientById(@PathVariable("id") long id) {
    return patientService.getPatientById(id);
  }

  // get patients
  @GetMapping(path = "/patients")
  public List<Patient> getPatients() {
    return patientService.getPatients();
  }

  // updatePatient
  @PutMapping(path = "/patient")
  public Patient updatePatient(Patient patient) {
    return patientService.updatePatient(patient);
  }

  // deletePatient
  @DeleteMapping(path = "/patient/{id}")
  public String deletePatient(@PathVariable("id") long id) {
    patientService.deletePatient(id);
    return "Patient delete successfuly..";
  }
}
