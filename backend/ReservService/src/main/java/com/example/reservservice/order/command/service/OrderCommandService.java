package com.example.reservservice.order.command.service;

import com.example.reservservice.order.command.commands.CreateOrdercourseCommand;
import com.example.reservservice.order.command.model.OrdercourseRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class OrderCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "CreateOrder")
    public String createReview(
            OrdercourseRestModel model
    )
    {
        CreateOrdercourseCommand command = CreateOrdercourseCommand
                .builder()
                .order_id(UUID.randomUUID().toString())
                .price(model.getPrice())
                .discount(model.getDiscount())
                .reserv_id(model.getReserv_id())
                .total_price(model.getTotal_price())
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
