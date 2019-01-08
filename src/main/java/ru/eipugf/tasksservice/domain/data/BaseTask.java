package ru.eipugf.tasksservice.domain.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(RegisterClient.class),
        @JsonSubTypes.Type(AddPayment.class)})
public abstract class BaseTask {

    public abstract void execute();
}

