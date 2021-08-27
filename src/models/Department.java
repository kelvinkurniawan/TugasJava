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
public class Department {
    private int id, manager, location;
    private String name;

    public Department(int id, String name, int manager_id, int location_id) {
        this.id = id;
        this.manager = manager_id;
        this.location = location_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager_id) {
        this.manager = manager_id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location_id) {
        this.location = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", manager_id=" + manager + ", location_id=" + location + ", name=" + name + '}';
    }
}
