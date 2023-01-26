package com.example.reservservice.reservation.command.service;

import com.example.reservservice.reservation.command.commands.CreateReservationCommand;
import com.example.reservservice.reservation.command.commands.UpdateReservationCommand;
import com.example.reservservice.reservation.command.model.ReservationRestModel;
import com.example.reservservice.reservation.data.Reservation;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResevCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "CreateResv")
    public String createReservation(ReservationRestModel model)
    {
        CreateReservationCommand command = CreateReservationCommand
                .builder()
                .reserv_id(UUID.randomUUID().toString())
                .booking_date(model.getBooking_date())
                .eating_date(model.getEating_date())
                .eating_time(model.getEating_time())
                .status("Waiting")
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

    @RabbitListener(queues = "UpdateResv")
    public String updateReservation(
            Reservation model
    )
    {
        UpdateReservationCommand command = UpdateReservationCommand
                .builder()
                .reserv_id(UUID.randomUUID().toString())
                .booking_date(model.getBooking_date())
                .eating_date(model.getEating_date())
                .eating_time(model.getEating_time())
                .status(model.getStatus())
                .user_id(model.getUser_id())
                .rest_id(model.getRest_id())
                .id(model.getReserv_id())
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
