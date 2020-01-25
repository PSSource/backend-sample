
package sample1.domain.dao;
 
import java.util.UUID;
import java.util.stream.Stream;
import org.seedstack.business.domain.Repository;

import sample1.domain.model.Person;
 
public interface PersonRepository extends Repository<Person, UUID> {
	
	
	//select * from table
    default Stream<Person> findByName(String name) {
        return get(getSpecificationBuilder().of(Person.class)
                .property("firstName").matching(name).ignoringCase()
                .or()
                .property("lastName").matching(name).ignoringCase()
                .build()
        );
    }
    
	//select few_column from table
    default Stream<Person> findByNameFewCol(String name) {
        return get(getSpecificationBuilder().of(Person.class)
                .property("firstName").equalTo(name)                
                .build()
        );
    }
    
    
/*    public interface VehicleProjectRepository extends Repository<ProjectVehicle, Long> { 
        default Stream<ProjectVehicle> findProjectByAllowedUser(String userId) {
            return get(getSpecificationBuilder().of(ProjectVehicle.class).property("listTslUsersWithReadRight.userIdentification").equalTo(userId).or()
                    .property("listTdfUsersWithReadRight.userIdentification").equalTo(userId).or().property("listTslUsersWithRight.userIdentification")
                    .equalTo(userId).or().property("listTdfUsersWithRight.userIdentification").equalTo(userId).build());
        } */ 

    
  
}
