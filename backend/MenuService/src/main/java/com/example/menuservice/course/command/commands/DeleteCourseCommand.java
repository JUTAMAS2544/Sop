package com.example.menuservice.course.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteCourseCommand {
    @TargetAggregateIdentifier
    private String course_id;
    private String id;
}
