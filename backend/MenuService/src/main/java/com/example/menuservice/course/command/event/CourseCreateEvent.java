package com.example.menuservice.course.command.event;

import lombok.Data;

@Data
public class CourseCreateEvent {
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
}
