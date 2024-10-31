/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.conferencia.config;

import java.nio.charset.StandardCharsets;
import org.springframework.context.annotation.Configuration;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
/**
 *
 * @author Ashlee Campaz
 */
@Configuration
public class RabbitConfig {
    private final static String QUEUE_NAME = "conferencia-creada";
    
    @Bean
    public Channel generateChannerl(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Channel channel = null;
        try  {
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return channel;
    }

    public static String getQUEUE_NAME() {
        return QUEUE_NAME;
    }
    
}
