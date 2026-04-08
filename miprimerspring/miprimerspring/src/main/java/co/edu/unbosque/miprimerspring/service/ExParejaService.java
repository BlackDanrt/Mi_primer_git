package co.edu.unbosque.miprimerspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.dto.ExParejaDTO;
import co.edu.unbosque.miprimerspring.entity.ExPareja;
import co.edu.unbosque.miprimerspring.repository.ExParejaRepository;

@Service
public class ExParejaService implements CRUDoperation<ExParejaDTO> {
	
	@Autowired
	private ExParejaRepository exparejaRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public ExParejaService() {

	}

	// LAS VALIDACIONES SE HACEN ACA EN SERVICE

	@Override
	public int create(ExParejaDTO data) {
		ExPareja entity = mapper.map(data, ExPareja.class);
		exparejaRepo.save(entity);
		return 0;
		// Si retorna 0, significa que todo salio bien.
	}

	@Override
	public List<ExParejaDTO> getAll() {
		List<ExPareja> entityList = (List<ExPareja>) exparejaRepo.findAll();
		List<ExParejaDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity) -> {
			ExParejaDTO temp = mapper.map(entity, ExParejaDTO.class);
			dtoList.add(temp);
		});
		return dtoList;
		// CRUDRepository devuelve las listas como iterables, toca castearlas a lista
	}

	@Override
	public int deleteById(Long id) {
		Optional<ExPareja> encontrado = exparejaRepo.findById(id);
		if (encontrado.isPresent()) {
			exparejaRepo.delete(encontrado.get());
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int updateById(Long id, ExParejaDTO newData) {
		Optional<ExPareja> encontrado = exparejaRepo.findById(id);
		if (encontrado.isPresent()) {
			ExPareja temp = encontrado.get();
			temp.setNombre(newData.getNombre());
			temp.setEdad(newData.getEdad());
			temp.setFechaNacimiento(newData.getFechaNacimiento());
			temp.setFechaRuptura(newData.getFechaRuptura());
			temp.setMotivoRuptura(newData.getMotivoRuptura());
			exparejaRepo.save(temp);
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public long count() {
		return exparejaRepo.count();
	}

	@Override
	public boolean exist(Long id) {
		return exparejaRepo.existsById(id) ? true : false;
	}
}
