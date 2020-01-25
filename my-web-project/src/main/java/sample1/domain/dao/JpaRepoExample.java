package sample1.domain.dao;

import javax.inject.Inject;

import org.seedstack.business.Service;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import sample1.domain.model.Student;
import sample1.infrastructure.JpaRepoExampleI;
import sample1.infrastructure.StudentRepository;

@Transactional
@JpaUnit("myJpaUnit")
public class JpaRepoExample implements JpaRepoExampleI{
	
	@Inject
	StudentRepository sRepo;
	
	public String getDatabyRepo(){
		
		Student s= sRepo.findStudentByFirstName("prakash");
		
		
		
		System.out.println("Repo -- " + s.getGuid()+"  "+ s.getFirstName()+ " " +s.getLastName());
		return s.toString();
	}

}
