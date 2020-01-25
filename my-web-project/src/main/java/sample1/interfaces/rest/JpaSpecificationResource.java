package sample1.interfaces.rest;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import sample1.domain.dao.JpaRepoExample;
import sample1.domain.dao.JpaSpecification;
import sample1.domain.dao.PersonRepository;
import sample1.domain.model.Person;
import sample1.infrastructure.JPAUtilityInterface;
import sample1.infrastructure.JpaRepoExampleI;
import sample1.infrastructure.JpaSpecificationI;


//http://localhost:8080/api/spec

@Path("spec")
public class JpaSpecificationResource {
	
	@Inject
	JpaSpecificationI specificationEx;
	
    @GET
    @Path("/1")
    public String getSpecificationResource() {
    	return specificationEx.getDatabyRepo();
    }
    
    @GET
    @Path("/2")
    public String getSpecificationColResource() {
    	return specificationEx.getDatabySpecCol();
    }
    
}


