package ru.eipugf.tasksservice.domain.infra.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitMQConfiguration {

    private final String queue;

    private final String exchange;

    private final String routingKey;

    public RabbitMQConfiguration(
            @Value("${queue.gateway}") String queue,
            @Value("${exchange.gateway}") String exchange,
            @Value("${routing_key.gateway}") String routingKey) {
        this.queue = queue;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    @Bean
    public Queue queue() {
        return new Queue(this.queue, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(this.exchange, true, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(this.routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, Jackson2JsonMessageConverter messageConverter){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
