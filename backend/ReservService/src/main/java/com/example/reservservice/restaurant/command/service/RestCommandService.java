package com.example.reservservice.restaurant.command.service;

import com.example.reservservice.restaurant.command.commands.UpdateRatingCommand;
import com.example.reservservice.restaurant.command.model.RatingModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "UpdateRating")
    public String updateRating(RatingModel model)
    {
        UpdateRatingCommand command = UpdateRatingCommand
                .builder()
                .rest_id(UUID.randomUUID().toString())
                .rating(model.getRating())
                .id(model.getRest_id())
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
