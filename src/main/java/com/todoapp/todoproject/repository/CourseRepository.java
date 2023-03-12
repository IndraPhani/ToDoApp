package com.todoapp.todoproject.repository;

import com.todoapp.todoproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
   Course findByName(String name);

    List<Course> findAllByUserName(String username);


}
