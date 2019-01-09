package ru.eipugf.tasksservice.domain.data;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Объект с описанием ошибки результата выполнения задания.
 * @since 0.0.1
 * @author eipugf
 */
@Document(collection = "task-holder")
@TypeAlias("ErrorTask")
public class ErrorTask extends BaseTask {
    /**
     * Текстовое описание ошибки.
     */
    private String textError;

    public ErrorTask() {
    }

    public ErrorTask(String textError) {
        this.textError = textError;
    }

    public String getTextError() {
        return textError;
    }

    @Override
    public String toString() {
        return "ErrorTask {" +
                "textError='" + textError + '\'' +
                '}';
    }
}
