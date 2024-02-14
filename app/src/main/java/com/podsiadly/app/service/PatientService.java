package com.podsiadly.app.service;

import com.podsiadly.app.model.Patient;
import java.util.List;

public interface PatientService {

  public Patient addPatient(Patient patient);

  public Patient getPatientById(long id);

  public List<Patient> getPatients();

  public void deletePatient(long id);

  public Patient updatePatient(Patient patient);
}
