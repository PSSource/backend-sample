package sample1.infrastructure;

import java.util.UUID;
import java.util.stream.Stream;

import org.seedstack.business.domain.AggregateExistsException;
import org.seedstack.business.domain.AggregateNotFoundException;
import org.seedstack.business.domain.BaseRepository;
import org.seedstack.business.specification.Specification;

import sample1.domain.model.Person;

//public class JpaRepoEx extends BaseJpaRepository<Person, UUID>{
public class JpaRepoEx extends BaseRepository<Person, UUID>{

	@Override
	public void add(Person aggregate) throws AggregateExistsException {
		System.out.println("Add-----");
		
	}

	@Override
	public Stream<Person> get(Specification<Person> specification,
			org.seedstack.business.domain.Repository.Option... options) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long remove(Specification<Person> specification) throws AggregateNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
