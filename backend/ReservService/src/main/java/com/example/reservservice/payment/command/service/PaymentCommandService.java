package com.example.reservservice.payment.command.service;

import com.example.reservservice.payment.command.commands.CreatePaymentCommand;
import com.example.reservservice.payment.command.model.PaymentRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class PaymentCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "CreatePayment")
    public String createPayment(
            PaymentRestModel model
    )
    {
        CreatePaymentCommand command = CreatePaymentCommand
                .builder()
                .payment_id(UUID.randomUUID().toString())
                .image(model.getImage())
                .date(model.getDate())
                .time(model.getTime())
                .price(model.getPrice())
                .reserv_id(model.getReserv_id())
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
