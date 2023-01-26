package com.example.menuservice.course.query.controller;

import com.example.menuservice.course.data.Course;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Course> getCourse(){
        Object model = rabbitTemplate.convertSendAndReceive("MenuExchange", "read", "");
        return ((List<Course>) model);
    }
}
