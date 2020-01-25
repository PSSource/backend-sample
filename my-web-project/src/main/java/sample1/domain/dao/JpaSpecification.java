package sample1.domain.dao;

import java.util.stream.Stream;

import javax.inject.Inject;


import org.seedstack.business.Service;
import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.business.modelmapper.ModelMapper;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import ch.qos.logback.core.net.SyslogOutputStream;
import sample1.domain.model.Person;
import sample1.domain.model.Student;
import sample1.dto.PersonDto;
import sample1.infrastructure.JpaRepoExampleI;
import sample1.infrastructure.JpaSpecificationI;
import sample1.infrastructure.StudentRepository;

@Transactional
@JpaUnit("myJpaUnit")
public class JpaSpecification implements JpaSpecificationI{
	
	@Inject
	PersonRepository sRepo;
	
	@Inject
    private FluentAssembler fluentAssembler;
	
	public String getDatabyRepo(){
		
		Stream<Person> s= sRepo.findByName("prakash");
		
		s.forEach(p->System.out.println(" SPecification Example   "+p.getFirstName()));
		
		return s.toString();
	}


	@Override
	public String getDatabySpecCol() {
		
		Stream<Person> s= sRepo.findByNameFewCol("prakash");
		
		s.forEach(p->System.out.println(" SPecification Example   "+p.getFirstName()));
		
		return s.toString();
		
		/*Person person = new Person();
		person.setFirstName("prakash");
		person.setLastName("sahu");
		
		
		PersonDto personDto = fluentAssembler
                .assemble(person)
                .with(ModelMapper.class)
                .to(PersonDto.class);
		System.out.println(person.getFirstName()+ " "+ person.getLastName());
		return personDto.getFirstName() + " "+person.getLastName();
		*/
	}
	
	
}
