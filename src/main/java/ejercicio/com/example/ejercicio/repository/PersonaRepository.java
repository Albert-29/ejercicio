package ejercicio.com.example.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejercicio.com.example.ejercicio.entity.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
