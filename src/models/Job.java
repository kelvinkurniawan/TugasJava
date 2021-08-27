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
    private double minSalary, maxSalary;

    public Job(String id, String title, double min_salary, double max_salary) {
        this.id = id;
        this.title = title;
        this.minSalary = min_salary;
        this.maxSalary = max_salary;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", title=" + title + ", min_salary=" + minSalary + ", max_salary=" + maxSalary + '}';
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

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double min_salary) {
        this.minSalary = min_salary;
    }

    public double getMaxsalary() {
        return maxSalary;
    }

    public void setMaxSalary(double max_salary) {
        this.maxSalary = max_salary;
    }
}
