package ru.eipugf.tasksservice.domain.infra.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

/**
 * Конфигурация AMQP.
 * @since 0.0.1
 * @author eipugf
 */
@Configuration
public class RabbitMQConfiguration {
    /**
     * Очередь.
     */
    private final String queue;
    /**
     * Точка доступа.
     */
    private final String exchange;
    /**
     * Ключ.
     */
    private final String routingKey;

    public RabbitMQConfiguration(
            @Value("${queue.gateway}") String queue,
            @Value("${exchange.gateway}") String exchange,
            @Value("${routing_key.gateway}") String routingKey) {
        this.queue = queue;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    /**
     * Метод для создания очереди.
     * @return очередь.
     */
    @Bean
    public Queue queue() {
        return new Queue(this.queue, true);
    }

    /**
     * Метод создания точки доступа.
     * @return точка доступа.
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(this.exchange, true, false);
    }

    /**
     * Метод создания биндинга точки доступа и очереди.
     * @param exchange точка доступа.
     * @param queue очередь.
     * @return биндинг.
     */
    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(this.routingKey);
    }

    /**
     * Метод для создания конвертера сообщений в объекты и наоброт для AMQP.
     * @return конвертер.
     */
    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Метод для создания аксессора к RabbitMQ.
     * @param factory фабрика соединений.
     * @param messageConverter конвертёр объектов.
     * @return аксессор.
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, Jackson2JsonMessageConverter messageConverter){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}