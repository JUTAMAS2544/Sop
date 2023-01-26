package com.example.reservservice.payment.query.service;

import com.example.reservservice.payment.data.Payment;
import com.example.reservservice.payment.query.query.ReadPaymentQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PaymentQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadPayment")
    public List<Payment> getPayment(String s){
        ReadPaymentQuery query = new ReadPaymentQuery();
        List<Payment> models = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Payment.class)).join();
        return models;
    }
}
