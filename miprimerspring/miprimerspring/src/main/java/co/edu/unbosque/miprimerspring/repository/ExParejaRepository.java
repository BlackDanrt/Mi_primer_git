package co.edu.unbosque.miprimerspring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.entity.ExPareja;

public interface ExParejaRepository extends CrudRepository<ExPareja, Long> {

	@Override
	default long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default void delete(ExPareja entity) {
		// TODO Auto-generated method stub

	}

	@Override
	default void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	default void deleteAll(Iterable<? extends ExPareja> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	default void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	default boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default Iterable<ExPareja> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Iterable<ExPareja> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Optional<ExPareja> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	default <S extends ExPareja> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default <S extends ExPareja> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
}
