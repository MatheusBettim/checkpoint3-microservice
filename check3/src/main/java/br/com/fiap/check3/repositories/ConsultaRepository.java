package br.com.fiap.check3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.check3.models.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}