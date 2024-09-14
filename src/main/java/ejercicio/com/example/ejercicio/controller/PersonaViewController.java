package ejercicio.com.example.ejercicio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ejercicio.com.example.ejercicio.entity.Persona;
import ejercicio.com.example.ejercicio.repository.PersonaRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaViewController {


    private final PersonaRepository personaRepository;

    public PersonaViewController (PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        return "registro";
    }

    @PostMapping("/api/personas")
    public String registrarPersona(@ModelAttribute Persona persona) {
        personaRepository.save(persona);
        return "redirect:/consulta";
    }

    @GetMapping("/consulta")
    public String mostrarConsulta(Model model) {
        model.addAttribute("personas", personaRepository.findAll());
        return "consulta";
    }
}

