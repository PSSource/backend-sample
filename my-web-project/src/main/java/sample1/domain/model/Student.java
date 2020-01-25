package sample1.domain.model;


import org.hibernate.annotations.Type;
import org.seedstack.business.domain.BaseAggregateRoot;
import org.seedstack.business.domain.Identity;
import org.seedstack.jpa.JpaUnit;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
@JpaUnit("myJpaUnit")
public class Student extends BaseAggregateRoot<UUID> {
	
	
	
	public Student() {
	}
	
	public Student(String fname){
		this.firstName=fname;
	}
	//@Identity(handler = UUIDHandler.class)
	@Id
	@Type(type = "uuid-char")
	@Column(name = "ID")
	private UUID guid; 
    
    public UUID getGuid() {
		return guid;
	}

	public void setGuid(UUID guid) {
		this.guid = guid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Column(name="first_name")
	private String firstName;
	
	
    @Column(name="last_name")
    private String lastName;

   

   
}
