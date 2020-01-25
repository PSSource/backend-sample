package sample1.interfaces.rest;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import sample1.domain.dao.JpaRepoExample;
import sample1.domain.model.Person;
import sample1.infrastructure.JPAUtilityInterface;
import sample1.infrastructure.JpaRepoExampleI;


//http://localhost:8080/api/hello

@Path("jex")
public class JpaResource {
	
	@Inject
	JpaRepoExampleI jpaEx;
	
    @GET
    @Path("/1")
    public String getJpaResource() {
    	return jpaEx.getDatabyRepo();
    }
    
    
    
    
}


