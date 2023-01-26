package com.example.menuservice.course.query.projection;

import com.example.menuservice.course.data.Course;
import com.example.menuservice.course.data.CourseRepository;
import com.example.menuservice.course.query.query.ReadCourseQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseProjection {
    @Autowired
    private CourseRepository repository;

    @QueryHandler
    public List<Course> handler(ReadCourseQuery query){
        List<Course> models = repository.findAll();
        return models;
    }
}
