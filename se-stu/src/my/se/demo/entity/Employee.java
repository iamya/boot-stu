package my.se.demo.entity;

import my.se.demo.enums.Status;

public class Employee {

    private String name;

    private Integer age;

    private Double salary;

    private Status status;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee(String name, Integer age, Double salary, Status status) {

        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
