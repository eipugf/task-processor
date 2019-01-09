package ru.eipugf.tasksservice.domain.service;

import org.springframework.stereotype.Service;
import ru.eipugf.tasksservice.domain.TaskHolder;
import ru.eipugf.tasksservice.domain.ProcessException;
import ru.eipugf.tasksservice.domain.data.BaseTask;

/**
 * Сервис по обработке заданий.
 * @since 0.0.1
 * @author eipugf
 */
@Service
public class TaskProcessor {

    /**
     * Метод для обработки заданий.
     *
     * @param taskHolder задание.
     * @return результат обработки.
     * @throws ProcessException в случае, если произошла ошибка при обработке.
     */
    public TaskHolder<BaseTask> process (TaskHolder<BaseTask> taskHolder) throws ProcessException {
        try {
            System.out.println(taskHolder);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new ProcessException("thread stopped..");
        }
        return taskHolder;
    }

}
