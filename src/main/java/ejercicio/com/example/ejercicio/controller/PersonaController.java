package ejercicio.com.example.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicio.com.example.ejercicio.entity.Persona;
import ejercicio.com.example.ejercicio.repository.PersonaRepository;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // Servicio de registro
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPersona(@Validated @RequestBody Persona persona) {
        personaRepository.save(persona);
        return ResponseEntity.ok("Persona registrada exitosamente");
    }

    // Servicio de consulta
    @GetMapping("/consultar")
    public List<Persona> consultarPersonas() {
        return personaRepository.findAll();
    }
}
