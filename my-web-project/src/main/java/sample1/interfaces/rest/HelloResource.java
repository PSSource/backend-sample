package sample1.interfaces.rest;

import java.util.UUID;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Swagger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.transaction.Transactional;

import io.swagger.annotations.Api;
import sample1.domain.model.Person;
import sample1.infrastructure.JPAUtilityInterface;


//http://localhost:8080/api/hello
//http://localhost:8080/api/swagger.json

@Api
@Path("hello")
public class HelloResource {
	
	@Inject
	JPAUtilityInterface jpau;
	
    @POST
    @Path("/1")
    public String hello1() {

        return "Hello World!";
    }
    
    
    @GET
    @Path("/2")
    public String saveUsingEM() {
    	jpau.saveUsingEM();
        return "Save Using Entity Manager---";
    }
    
    @GET
    @Path("/3")
    public String getUsingEM() {
    	jpau.getUsingEM();
    	return "Get using Entity Manager ---";
    }
    
    @GET
    @Path("/4")
    public String getUsingEMColumn(){
    	
    	jpau.getUsingEMColumn();
    	return "getUsingEMColumn() -- selective column selection";
    }
    
    @GET
    @Path("/5")   
    public void getUsingEMColumnQriteriaQuery (){
    	
    	jpau.getUsingEMColumnQriteriaQuery();
    }
    
    @GET
    @Path("/6")
    public void getUsingEMColumnQriteria(){
    	
    	jpau.getUsingEMColumnQriteria();
    }
    
    
    @GET
    @Path("/7")
    public  void getUsingHQL(){
    	jpau.getUsingHQL();
    }
   
    @GET
    @Path("/8")
    public void getUsingMultiSelect(){
    	
    	jpau.getUsingMultiSelectQriteria();
    }

    
}


