package com.darshan.app.rest.Repo;

import com.darshan.app.rest.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long>{
}
