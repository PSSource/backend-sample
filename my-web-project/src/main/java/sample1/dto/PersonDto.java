package sample1.dto;

import org.seedstack.business.assembler.DtoOf;

import sample1.domain.model.Person;

@DtoOf(Person.class)
public class PersonDto {
	
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
