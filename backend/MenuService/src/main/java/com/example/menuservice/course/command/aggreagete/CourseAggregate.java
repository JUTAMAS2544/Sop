package com.example.menuservice.course.command.aggreagete;

import com.example.menuservice.course.command.commands.CreateCourseCommand;
import com.example.menuservice.course.command.commands.DeleteCourseCommand;
import com.example.menuservice.course.command.commands.UpdateCourseCommand;
import com.example.menuservice.course.command.event.CourseCreateEvent;
import com.example.menuservice.course.command.event.CourseDeleteEvent;
import com.example.menuservice.course.command.event.CourseUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
@Aggregate
public class CourseAggregate {
    @AggregateIdentifier
    private String course_id;
    private String name;
    private String image;
    private Double price;
    private String menu1;
    private Integer amount1;
    private String menu2;
    private Integer amount2;
    private String menu3;
    private Integer amount3;
    private String menu4;
    private Integer amount4;
    private String menu5;
    private Integer amount5;
    private String id;

    public CourseAggregate() {
    }

    @CommandHandler
    public CourseAggregate(CreateCourseCommand command) {
        if(command.getName() == null || command.getName().isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if(command.getPrice() <= 0){
            throw new IllegalArgumentException("Price can't be less than or equal to 0");
        }

        CourseCreateEvent event = new CourseCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CourseCreateEvent event){
        this.course_id = event.getCourse_id();
        this.name = event.getName();
        this.price = event.getPrice();
        this.image = event.getImage();
        this.menu1 = event.getMenu1();
        this.amount1 = event.getAmount1();
        this.menu2 = event.getMenu2();
        this.amount2 = event.getAmount2();
        this.menu3 = event.getMenu3();
        this.amount3 = event.getAmount3();
        this.menu4 = event.getMenu4();
        this.amount4 = event.getAmount4();
        this.menu5 = event.getMenu5();
        this.amount5 = event.getAmount5();
    }

    @CommandHandler
    public CourseAggregate(UpdateCourseCommand command) {
        if(command.getName() == null || command.getName().isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if(command.getPrice() <= 0){
            throw new IllegalArgumentException("Price can't be less than or equal to 0");
        }

        CourseUpdateEvent event = new CourseUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CourseUpdateEvent event){
        this.course_id = event.getCourse_id();
        this.name = event.getName();
        this.price = event.getPrice();
        this.image = event.getImage();
        this.menu1 = event.getMenu1();
        this.amount1 = event.getAmount1();
        this.menu2 = event.getMenu2();
        this.amount2 = event.getAmount2();
        this.menu3 = event.getMenu3();
        this.amount3 = event.getAmount3();
        this.menu4 = event.getMenu4();
        this.amount4 = event.getAmount4();
        this.menu5 = event.getMenu5();
        this.amount5 = event.getAmount5();
        this.id = event.getId();
    }

    @CommandHandler
    public CourseAggregate(DeleteCourseCommand command) {
        CourseDeleteEvent event = new CourseDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CourseDeleteEvent event){
        this.course_id = event.getCourse_id();
        this.id = event.getId();
    }
}
