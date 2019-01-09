package ru.eipugf.tasksservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.eipugf.tasksservice.domain.data.BaseTask;

/**
 * Объект для отправки задания в очередь с идентификатором.
 * @since 0.0.1
 * @author eipugf
 * @param <T>
 */
@Document(collection = "task-holder")
public class TaskHolder <T extends BaseTask> {

    /**
     * Идентификатор задания.
     */
    @Id
    private String id;

    /**
     * Объект задания.
     */
    private T task;

    public TaskHolder() {
    }

    public TaskHolder(String id, T task) {
        this.id = id;
        this.task = task;
    }

    /**
     * Метод получения идентификатора задания.
     * @return идентификатор.
     */
    public String getId() {
        return id;
    }

    /**
     * Метод получения идентификатора задания.
     * @return объект задания.
     */
    public T getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "TaskHolder{" +
                "id='" + id + '\'' +
                ", task=" + task +
                '}';
    }
}
