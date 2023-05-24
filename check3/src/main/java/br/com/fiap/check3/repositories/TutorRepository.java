package br.com.fiap.check3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.check3.models.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}