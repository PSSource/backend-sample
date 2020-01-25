
package sample1.domain.model;
 
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.seedstack.business.domain.BaseAggregateRoot;
import org.seedstack.business.domain.Identity;
//import org.seedstack.business.domain.Identity.UUIDHandler;
import org.seedstack.jpa.JpaUnit;
 

@Entity
@Table(name="student")
@JpaUnit("myJpaUnit")
public class Person extends BaseAggregateRoot<UUID> {
	//@Identity(handler = UUIDHandler.class)
	@Id
	@Type(type = "uuid-char")
	@Column(name = "ID")
	private UUID guid; 

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
    private String lastName;

	
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

 
    public Person() {
        // needed for Hibernate
    }
 
  
 
    // ...
}
