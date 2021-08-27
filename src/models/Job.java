/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kelvi
 */
public class Job {
    private String id, title;
    private double min_salary, max_salary;

    public Job(String id, String title, double min_salary, double max_salary) {
        this.id = id;
        this.title = title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", title=" + title + ", min_salary=" + min_salary + ", max_salary=" + max_salary + '}';
    }

    public Job() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(double min_salary) {
        this.min_salary = min_salary;
    }

    public double getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(double max_salary) {
        this.max_salary = max_salary;
    }
}
