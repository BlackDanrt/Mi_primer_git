package co.edu.unbosque.miprimerspring.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.entity.Pareja;

public interface ParejaRepository extends CrudRepository<Pareja, Long> {

	public Optional<List<Pareja>> findByNombre(String nombre);

	public Optional<List<Pareja>> findByCarrera(String nombre);

	public Optional<List<Pareja>> findByEdad(int edad);

	public Optional<List<Pareja>> findByFechaAniversario(LocalDateTime fechaAniversario);

}
