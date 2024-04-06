package com.example.gestionpatient.web;

import com.example.gestionpatient.entities.Patient;
import com.example.gestionpatient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0") int page,
                        @RequestParam(name="size",defaultValue = "4") int size,
                        @RequestParam(name="Keyword",defaultValue = "") String Keyword
                         ){
        Page<Patient> pagePatients = patientRepository.findByNomContains(Keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("Keyword",Keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name="id") Long id,@RequestParam(name="Keyword",defaultValue = "") String Keyword,
                         @RequestParam(name="page",defaultValue = "0") int page) {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&Keyword="+Keyword;}

    @GetMapping("/")
    public String home() {

         return "redirect:/index";


        }
}
