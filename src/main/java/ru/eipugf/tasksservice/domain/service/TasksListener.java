package ru.eipugf.tasksservice.domain.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.eipugf.tasksservice.TaskHolder;
import ru.eipugf.tasksservice.domain.data.BaseTask;

@Service
public class TasksProcessorService {

    @RabbitListener(id = "tasks-request-processor-listener", queues = "${queue.gateway}")
    public void process(TaskHolder<BaseTask> task){
        System.out.println("processing " + task);
    }

}
