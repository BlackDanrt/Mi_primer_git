package co.edu.unbosque.miprimerspring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.entity.Pareja;
import co.edu.unbosque.miprimerspring.repository.ParejaRepository;

@Service
public class ParejaService implements CRUDoperation<ParejaDTO> {

	@Autowired
	private ParejaRepository parejaRepo;

	@Autowired
	private ModelMapper mapper;

	public ParejaService() {

	}

	// LAS VALIDACIONES SE HACEN ACA EN SERVICE

	@Override
	public int create(ParejaDTO data) {
		Pareja entity = mapper.map(data, Pareja.class);
		parejaRepo.save(entity);
		return 0;
		// Si retorna 0, significa que todo salio bien.
	}

	@Override
	public List<ParejaDTO> getAll() {
		List<Pareja> entityList = (List<Pareja>) parejaRepo.findAll();
		List<ParejaDTO> dtoList = new ArrayList<>();
		// Funciones lambda
		// Son funciones anonimas
		entityList.forEach((entity) -> {
			ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
		// CRUDRepository devuelve las listas como iterables, toca castearlas a lista
	}

	@Override
	public int deleteById(Long id) {
		Optional<Pareja> encontrado = parejaRepo.findById(id);
		if (encontrado.isPresent()) {
			parejaRepo.delete(encontrado.get());
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int updateById(Long id, ParejaDTO newData) {
		Optional<Pareja> encontrado = parejaRepo.findById(id);
		if (encontrado.isPresent()) {
			Pareja temp = encontrado.get();
			temp.setCarrera(newData.getCarrera());
			temp.setNombre(newData.getNombre());
			temp.setEdad(newData.getEdad());
			temp.setFechaAniversario(newData.getFechaAniversario());
			parejaRepo.save(temp);
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public long count() {
		return parejaRepo.count();
	}

	@Override
	public boolean exist(Long id) {
		return parejaRepo.existsById(id) ? true : false;
	}

	public List<ParejaDTO> findByNombre(String nombre) {
		Optional<List<Pareja>> encontrados = parejaRepo.findByNombre(nombre);
		if (encontrados.isPresent() && !encontrados.get().isEmpty()) {
			List<ParejaDTO> dtoList = new ArrayList<>();
			encontrados.get().forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
		} else {
			return new ArrayList<ParejaDTO>();
		}
	}
	
	public List<ParejaDTO> findByCarrera(String carrera) {
		Optional<List<Pareja>> encontrados = parejaRepo.findByCarrera(carrera);
		if (encontrados.isPresent() && !encontrados.get().isEmpty()) {
			List<ParejaDTO> dtoList = new ArrayList<>();
			encontrados.get().forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
		} else {
			return new ArrayList<ParejaDTO>();
		}
	}
	
	public List<ParejaDTO> findByEdad(int edad) {
		Optional<List<Pareja>> encontrados = parejaRepo.findByEdad(edad);
		if (encontrados.isPresent() && !encontrados.get().isEmpty()) {
			List<ParejaDTO> dtoList = new ArrayList<>();
			encontrados.get().forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
		} else {
			return new ArrayList<ParejaDTO>();
		}
	}
	
	public List<ParejaDTO> findByFechaAniversario(LocalDateTime fechaAniversario) {
		Optional<List<Pareja>> encontrados = parejaRepo.findByFechaAniversario(fechaAniversario);
		if (encontrados.isPresent() && !encontrados.get().isEmpty()) {
			List<ParejaDTO> dtoList = new ArrayList<>();
			encontrados.get().forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
		} else {
			return new ArrayList<ParejaDTO>();
		}
	}
	
}
