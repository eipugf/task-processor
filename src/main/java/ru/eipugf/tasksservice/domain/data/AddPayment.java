package ru.eipugf.tasksservice.domain.data;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Объект для добавления платежа.
 * @since 0.0.1
 * @author eipugf
 */
@Document(collection = "task-holder")
@TypeAlias("AddPayment")
public class AddPayment extends BaseTask {
    /**
     * Номер телефона.
     */
    private String phone;
    /**
     * Услуга.
     */
    private int service;
    /**
     * Сумма.
     */
    private int sum;

    public AddPayment() {
    }

    public AddPayment(String phone, int service, int sum) {
        this.phone = phone;
        this.service = service;
        this.sum = sum;
    }

    public String getPhone() {
        return phone;
    }

    public int getService() {
        return service;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "AddPayment{" +
                "phone='" + phone + '\'' +
                ", service=" + service +
                ", sum=" + sum +
                '}';
    }
}
