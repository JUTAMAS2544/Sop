package com.example.menuservice.course.command.service;

import com.example.menuservice.course.command.commands.CreateCourseCommand;
import com.example.menuservice.course.command.commands.DeleteCourseCommand;
import com.example.menuservice.course.command.commands.UpdateCourseCommand;
import com.example.menuservice.course.command.model.CourseRestModel;
import com.example.menuservice.course.command.model.DeleteModel;
import com.example.menuservice.course.data.Course;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "CreateCourse")
    public String createCourse(
            CourseRestModel model
    )
    {
        CreateCourseCommand command = CreateCourseCommand
                .builder()
                .course_id(UUID.randomUUID().toString())
                .name(model.getName())
                .image(model.getImage())
                .price(model.getPrice())
                .menu1(model.getMenu1())
                .amount1(model.getAmount1())
                .menu2(model.getMenu2())
                .amount2(model.getAmount2())
                .menu3(model.getMenu3())
                .amount3(model.getAmount3())
                .menu4(model.getMenu4())
                .amount4(model.getAmount4())
                .menu5(model.getMenu5())
                .amount5(model.getAmount5())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "UpdateCourse")
    public String updateCourse(
            Course model
    ){
        UpdateCourseCommand command = UpdateCourseCommand
                .builder()
                .course_id(UUID.randomUUID().toString())
                .name(model.getName())
                .image(model.getImage())
                .price(model.getPrice())
                .menu1(model.getMenu1())
                .amount1(model.getAmount1())
                .menu2(model.getMenu2())
                .amount2(model.getAmount2())
                .menu3(model.getMenu3())
                .amount3(model.getAmount3())
                .menu4(model.getMenu4())
                .amount4(model.getAmount4())
                .menu5(model.getMenu5())
                .amount5(model.getAmount5())
                .id(model.getCourse_id())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "DeleteCourse")
    public String deleteCourse(
            DeleteModel model
    ){
        DeleteCourseCommand command = DeleteCourseCommand
                .builder()
                .course_id(UUID.randomUUID().toString())
                .id(model.getId())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
