package com.example.promotionservice.command.servvice;

import com.example.promotionservice.command.commands.CreatePromotionCommand;
import com.example.promotionservice.command.commands.DeletePromotionCommand;
import com.example.promotionservice.command.commands.UpdatePromotionCommand;
import com.example.promotionservice.command.model.DeleteModel;
import com.example.promotionservice.command.model.PromotionRestModel;
import com.example.promotionservice.command.model.UseCodeModel;
import com.example.promotionservice.data.Promotion;
import com.example.promotionservice.data.PromotionService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@Service
public class PromotionCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "CreatePromotion")
    public String createPromotion(PromotionRestModel model)
    {
        CreatePromotionCommand createPromotionCommand = CreatePromotionCommand
                .builder()
                .promotion_id(UUID.randomUUID().toString())
                .code(model.getCode())
                .quantity(model.getQuantity())
                .discount(model.getDiscount())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(createPromotionCommand);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "UpdatePromotion")
    public String updatePromotion(Promotion model){
        UpdatePromotionCommand promotionCommand = UpdatePromotionCommand
                .builder()
                .promotion_id(UUID.randomUUID().toString())
                .code(model.getCode())
                .quantity(model.getQuantity())
                .discount(model.getDiscount())
                .id(model.getPromotion_id())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(promotionCommand);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "DeletePromotion")
    public String deletePromotion(DeleteModel model){
        DeletePromotionCommand promotionCommand = DeletePromotionCommand
                .builder()
                .promotion_id(UUID.randomUUID().toString())
                .id(model.getId())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(promotionCommand);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
