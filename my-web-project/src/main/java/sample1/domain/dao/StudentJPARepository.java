package sample1.domain.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.seedstack.business.domain.Repository;
import org.seedstack.jpa.BaseJpaRepository;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import sample1.domain.model.Student;
import sample1.infrastructure.StudentRepository;

@Transactional
@JpaUnit("myJpaUnit")
public class StudentJPARepository extends  BaseJpaRepository<Student, UUID> implements StudentRepository{ 
	
	@Inject
	@Jpa
	private Repository<Student, UUID> sRepository;
	

     public Student findStudentByFirstName(String name) {
		
    	 
    	 Optional<Student> opt= sRepository.get(UUID.fromString("63760fe0-54c5-4832-b105-73d5d58fb523"));
    	 
    	 return opt.get();
	}


	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
     
     
     
}
