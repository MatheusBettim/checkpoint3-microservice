package br.com.fiap.check3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.check3.models.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

	@Query(value = "select id, crv, horario_inicio, horario_final, id_dia, id_especialidade, nome from veterinario where id_dia = ?;",nativeQuery = true)
	List<Veterinario> findByIdDia(Long idDia);
	
}