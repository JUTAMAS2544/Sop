package com.example.reservservice.table.command.service;

import com.example.reservservice.table.command.commands.UpdateSeatCommand;
import com.example.reservservice.table.data.Seat;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class TableCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "UpdateTable")
    public String updateSeat(Seat model){
        UpdateSeatCommand command = UpdateSeatCommand
                .builder()
                .table_id(UUID.randomUUID().toString())
                .status(model.getStatus())
                .rest_id(model.getRest_id())
                .table_no(model.getTable_no())
                .id(model.getTable_id())
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
