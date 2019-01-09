package ru.eipugf.tasksservice.domain.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.eipugf.tasksservice.domain.TaskHolder;
import ru.eipugf.tasksservice.domain.ProcessException;
import ru.eipugf.tasksservice.domain.data.BaseTask;
import ru.eipugf.tasksservice.domain.repository.TasksRepository;

/**
 * Сервис прослушивающий очередь AMQP.
 * @since 0.0.1
 * @author eipugf
 */
@Service
public class TasksListener {
    /**
     * Обработчие заданий.
     */
    private final TaskProcessor taskProcessor;
    /**
     * Репозиторий для хранения заданий.
     */
    private final TasksRepository tasksRepository;

    public TasksListener(TaskProcessor taskProcessor, TasksRepository tasksRepository) {
        this.taskProcessor = taskProcessor;
        this.tasksRepository = tasksRepository;
    }

    /**
     * Метод, принимающий сообщение очереди.
     * @param task задача на обработку.
     */
    @RabbitListener(id = "tasks-request-processor-listener", queues = "${queue.gateway}")
    public void process(TaskHolder<BaseTask> task) {
        try {
            TaskHolder<BaseTask> result = taskProcessor.process(task);
            System.out.println("try save to repository " + result);
            tasksRepository.save(result);
        } catch (ProcessException ex) {
            ex.printStackTrace();
        }
    }

}
