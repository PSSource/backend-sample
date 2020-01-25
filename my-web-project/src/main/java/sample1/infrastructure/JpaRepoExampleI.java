package sample1.infrastructure;

import javax.inject.Inject;

import org.seedstack.business.Service;

import sample1.domain.model.Student;
import sample1.infrastructure.StudentRepository;

@Service
public interface JpaRepoExampleI {
	
	public String getDatabyRepo();

}
