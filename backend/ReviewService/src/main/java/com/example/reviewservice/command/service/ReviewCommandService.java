package com.example.reviewservice.command.service;

import com.example.reviewservice.command.commands.CreateReviewCommand;
import com.example.reviewservice.command.commands.DeleteReviewCommand;
import com.example.reviewservice.command.commands.UpdateReviewCommand;
import com.example.reviewservice.command.model.DeleteModel;
import com.example.reviewservice.command.model.ReviewRestModel;
import com.example.reviewservice.data.Review;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "CreateReview")
    public String createReview(ReviewRestModel model)
    {
        CreateReviewCommand command = CreateReviewCommand
                .builder()
                .rv_id(UUID.randomUUID().toString())
                .comment(model.getComment())
                .rating(model.getRating())
                .user_id(model.getUser_id())
                .rest_id(model.getRest_id())
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

    @RabbitListener(queues = "UpdateReview")
    public String updateReview(Review model){
        UpdateReviewCommand command = UpdateReviewCommand
                .builder()
                .rv_id(UUID.randomUUID().toString())
                .comment(model.getComment())
                .rating(model.getRating())
                .user_id(model.getUser_id())
                .rest_id(model.getRest_id())
                .id(model.getRv_id())
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

    @RabbitListener(queues = "DeleteReview")
    public String deleteReview(DeleteModel model){
        DeleteReviewCommand command = DeleteReviewCommand
                .builder()
                .rv_id(UUID.randomUUID().toString())
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
