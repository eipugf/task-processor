package ru.eipugf.tasksservice.domain.data;

public class AddPayment extends BaseTask {

    private String strtest;

    public AddPayment() {
    }

    public AddPayment(String strtest) {
        this.strtest = strtest;
    }

    public String getStrtest() {
        return strtest;
    }

    @Override
    public String toString() {
        return "AddPayment{" +
                "strtest='" + strtest + '\'' +
                '}';
    }
}
