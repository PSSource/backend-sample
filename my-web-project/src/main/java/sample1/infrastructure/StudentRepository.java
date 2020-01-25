package sample1.infrastructure;

import java.util.List;
import java.util.UUID;

import org.seedstack.business.domain.Repository;

import sample1.domain.model.Student;

public interface StudentRepository extends Repository<Student, UUID> { 
    Student findStudentByFirstName(String name);
    List<Student> findAll();
}
