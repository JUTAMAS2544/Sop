package com.example.menuservice.course.command.event;

import lombok.Data;

@Data
public class CourseDeleteEvent {
    private String course_id;
    private String id;
}
