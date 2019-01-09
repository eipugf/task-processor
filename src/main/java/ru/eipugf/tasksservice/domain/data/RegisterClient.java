package ru.eipugf.tasksservice.domain.data;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Объект для регистрации клиента в систеие.
 * @author eipugf.
 * @since 0.0.1
 */
@Document(collection = "task-holder")
@TypeAlias("RegisterClient")
public class RegisterClient extends BaseTask {
    /**
     * Имя.
     */
    private String firstName;
    /**
     * Фамилия.
     */
    private String lastName;
    /**
     * Пол.
     */
    private Integer gender;

    public RegisterClient() {
    }

    public RegisterClient(String firstName, String lastName, Integer gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    /**
     * Метод получения имени.
     * @return имя.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Метод получения фамилии.
     * @return фамилия.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Метод получения признака пола.
     * @return 1 - М, 0 - Ж.
     */
    public Integer getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "RegisterClient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}


