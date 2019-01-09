package ru.eipugf.tasksservice.domain.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Базовый объект для всех типов заданий.
 * @since 0.0.1
 * @author eipugf
 */
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(RegisterClient.class),
        @JsonSubTypes.Type(AddPayment.class)})
@Document(collection = "task-holder")
public class BaseTask {
}