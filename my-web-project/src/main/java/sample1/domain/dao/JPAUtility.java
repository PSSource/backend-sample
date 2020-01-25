package sample1.domain.dao;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.Bind;
import org.seedstack.seed.transaction.Transactional;
import sample1.domain.model.Student;
import sample1.infrastructure.JPAUtilityInterface;


public class JPAUtility implements JPAUtilityInterface{
	
	@Inject   
	EntityManager em;
	
	
	@Transactional
	@JpaUnit("myJpaUnit")
	public void saveUsingEM() {
		Student s = new Student();
		s.setGuid(UUID.randomUUID());
		s.setFirstName("prakash");
		s.setLastName("sahu");
		em.merge(s);
	}
	  

	@Transactional
	@JpaUnit("myJpaUnit")
	public void getUsingEM() {
		Query query = em.createQuery("SELECT st FROM Student st");
		List lst = query.getResultList();
		Iterator it = lst.iterator();

		while (it.hasNext()) {
			Student student = (Student) it.next();
			System.out.print("Id:" + student.getGuid());
			System.out.print(" Name:" + student.getFirstName());
			System.out.println(" Course:" + student.getLastName());
		}
	}
	
	
	@Transactional
	@JpaUnit("myJpaUnit")
	public void getUsingEMColumn() {
		Query query = em.createQuery("select c.guid, c.firstName from Student c");
		List<Object[]> rows = query.getResultList();
	

		for (Object[] row: rows) {
		    System.out.println(" ------------------- ");
		    System.out.println("id: " + row[0]);
		    System.out.println("name: " + row[1]);
		}
		  	
	}
	
	@Transactional
	@JpaUnit("myJpaUnit")
	public void getUsingHQL() {
		Query query = em.createQuery("select c from Student c");
		List<Student> result = query.getResultList();
	

		for (Student st : result) {
		    System.out.println(" ------------------- ");
		    System.out.println("fName: " + st.getFirstName());
		    System.out.println("lName: " + st.getLastName());
		}
		  	
	}
	
	@Transactional
	@JpaUnit("myJpaUnit")
	public void getUsingEMColumnQriteriaQuery() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
		 
		Root<Student> c = q.from(Student.class);
		q.select(cb.array(c.get("firstName"), c.get("lastName")));
		  
		  
		List<Object[]> results = em.createQuery(q).getResultList();
	
		for (Object[] row: results) {
		    System.out.println(" ------------------- ");
		    System.out.println("id: " + row[0]);
		    System.out.println("name: " + row[1]);
		}
		  	
	}
	
	@Transactional
	@JpaUnit("myJpaUnit")
	public void getUsingEMColumnQriteria() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Student> q = cb.createQuery(Student.class);
		 
		Root<Student> c = q.from(Student.class);
		q.select(c);
		  
		  
		List<Student> results = em.createQuery(q).getResultList();
	
		for (Student st: results) {
		    System.out.println(" ------------------- ");
		    System.out.println("id: " + st.getFirstName());
		    System.out.println("name: " + st.getLastName());
		}
		  	
	}
	
	@Transactional
	@JpaUnit("myJpaUnit")
	public void getUsingMultiSelectQriteria() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Student> q = cb.createQuery(Student.class);
		 
		Root<Student> c = q.from(Student.class);
//		q.select(c);
		q.multiselect(c.get("firstName"));  
		  
		List<Student> results = em.createQuery(q).getResultList();
	
		for (Student st: results) {
		    System.out.println(" ------------------- ");
		    System.out.println("id: " + st.getFirstName());
		    System.out.println("name: " + st.getLastName());
		}
		  	
	}
	
/*	 public List<ProductRepresentation> computeResultList(Range range, String criteria) {
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Product> q = cb.createQuery(Product.class);
	        Root<Product> product = q.from(Product.class);

	        q.select(product);
	        if (criteria != null) {
	            q.where(cb.like(product.<String>get("name"), buildSqlLikeQuery(criteria)));
	        }

	        TypedQuery<Product> query = entityManager.createQuery(q);
	        if (range != null) {
	            query.setFirstResult((int) range.getOffset()).setMaxResults((int) range.getSize());
	        }

	        return fluently.assemble(query.getResultList()).toListOf(ProductRepresentation.class);
	    }*/

}
