package ru.eipugf.tasksservice;

import ru.eipugf.tasksservice.domain.data.BaseTask;

public class TaskHolder <T extends BaseTask> {

    private String id;

    private T task;

    public TaskHolder() {
    }

    public TaskHolder(String id, T task) {
        this.id = id;
        this.task = task;
    }

    public String getId() {
        return id;
    }

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
