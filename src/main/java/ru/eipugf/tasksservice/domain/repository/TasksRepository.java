package ru.eipugf.tasksservice.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.eipugf.tasksservice.domain.TaskHolder;
import ru.eipugf.tasksservice.domain.data.BaseTask;

/**
 * Репозиторий CRUD для хранения задания.
 * @since 0.0.1
 * @author eipugf
 */
public interface TasksRepository extends MongoRepository<TaskHolder<BaseTask>, String> {
}