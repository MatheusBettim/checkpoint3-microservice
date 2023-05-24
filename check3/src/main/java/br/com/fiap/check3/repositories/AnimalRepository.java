package br.com.fiap.check3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.check3.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}