package com.example.menuservice.course.command.event;

import com.example.menuservice.course.data.Course;
import com.example.menuservice.course.data.CourseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseEventHandler {
    @Autowired
    private CourseRepository repository;

    @EventHandler
    public void on(CourseCreateEvent event){
        Course model = new Course();
        BeanUtils.copyProperties(event, model);
        repository.save(model);
    }

    @EventHandler
    public void on(CourseUpdateEvent event){
        Course model = new Course();
        model.setCourse_id(event.getId());
        model.setName(event.getName());
        model.setPrice(event.getPrice());
        model.setImage(event.getImage());
        model.setMenu1(event.getMenu1());
        model.setAmount1(event.getAmount1());
        model.setMenu2(event.getMenu2());
        model.setAmount2(event.getAmount2());
        model.setMenu3(event.getMenu3());
        model.setAmount3(event.getAmount3());
        model.setMenu4(event.getMenu4());
        model.setAmount4(event.getAmount4());
        model.setMenu5(event.getMenu5());
        model.setAmount5(event.getAmount5());
        repository.save(model);
    }
    @EventHandler
    public void on(CourseDeleteEvent event){
        repository.deleteById(event.getId());
    }
}
