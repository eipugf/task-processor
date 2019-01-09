package ru.eipugf.tasksservice.domain;

/**
 * Тип исключения, которое может возникнуть в результате
 * выполнения ассинхронной задачи.
 * @since 0.0.1
 * @author eipugf
 */
public class ProcessException extends Exception {

    public ProcessException(String s) {
        super(s);
    }
}
