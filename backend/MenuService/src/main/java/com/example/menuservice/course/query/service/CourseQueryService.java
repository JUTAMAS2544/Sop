package com.example.menuservice.course.query.service;

import com.example.menuservice.course.data.Course;
import com.example.menuservice.course.query.query.ReadCourseQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CourseQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadCourse")
    public List<Course> getCourse(String s){
        ReadCourseQuery query = new ReadCourseQuery();
        List<Course> models = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Course.class)).join();
        return models;
    }
}
