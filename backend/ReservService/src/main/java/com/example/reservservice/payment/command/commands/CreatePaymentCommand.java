package com.example.reservservice.payment.command.commands;

import com.example.reservservice.payment.command.model.PaymentRestModel;
import lombok.Builder;
import lombok.Data;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Data
@Builder
public class CreatePaymentCommand {
    @TargetAggregateIdentifier
    private String payment_id;
    private String image;
    private Date date;
    private Time time;
    private Double price;
    private String reserv_id;
}
