package com.catolica.web.service.consumer;

import com.catolica.web.service.model.Email;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


    @Component
    public class Consumidor {

        @RabbitListener(queues = {"${queue.name}"})
        public void receive(@Payload String fileBody) {
            //System.out.println("Message " + fileBody);
             String emailRecebido= fileBody;
        }

    }

