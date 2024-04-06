package com.example.gestionpatient;

import com.example.gestionpatient.entities.Patient;
import com.example.gestionpatient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionPatientApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public void run(String... args) throws Exception {
       patientRepository.save(new Patient(null,"Mohamed",new Date(),false,34));
        patientRepository.save(new Patient(null,"Sara",new Date(),true,3478));
        patientRepository.save(new Patient(null,"Hanane",new Date(),false,3490));
        patientRepository.save(new Patient(null,"Imane",new Date(),true,3456));







    }

    public static void main(String[] args) {

        SpringApplication.run(GestionPatientApplication.class, args);
    }

}
