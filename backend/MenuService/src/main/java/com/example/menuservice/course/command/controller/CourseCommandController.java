package com.example.menuservice.course.command.controller;

import com.example.menuservice.course.command.commands.CreateCourseCommand;
import com.example.menuservice.course.command.commands.DeleteCourseCommand;
import com.example.menuservice.course.command.commands.UpdateCourseCommand;
import com.example.menuservice.course.command.model.CourseRestModel;
import com.example.menuservice.course.command.model.DeleteModel;
import com.example.menuservice.course.data.Course;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String createCourse(
            @RequestBody CourseRestModel model
    )
    {
        Object result = rabbitTemplate.convertSendAndReceive("MenuExchange", "create", model);
        return ((String) result);
    }

    @PutMapping
    public String updateCourse(
            @RequestBody Course model
    ){
        Object result = rabbitTemplate.convertSendAndReceive("MenuExchange", "update", model);
        return ((String) result);
    }

    @DeleteMapping
    public String deleteCourse(
            @RequestBody DeleteModel model
    ){
        Object result = rabbitTemplate.convertSendAndReceive("MenuExchange", "delete", model);
        return ((String) result);
    }
}
