/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author kelvi
 */
public enum Query {

//    REGION
    GET_REGION("SELECT * FROM regions"),
    GET_BY_ID_REGION("SELECT * FROM regions WHERE region_id = ?"),
    UPDATE_REGION("UPDATE regions SET region_name = ? WHERE region_id = ?"),
    DELETE_REGION("DELETE FROM regions WHERE region_id = ?"),
    INSERT_REGION("INSERT INTO regions(region_name, region_id) VALUES (?, ?)"),
    
//    JOBS
    GET_JOB("SELECT * FROM jobs"),
    GET_BY_ID_JOB("SELECT * FROM jobs WHERE job_id = ?"),
    UPDATE_JOB("UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?"),
    DELETE_JOB("DELETE FROM jobs WHERE job_id = ?"),
    INSERT_JOB("INSERT INTO jobs(job_title, min_salary, max_salary, job_id) VALUES (?, ?, ?, ?) "),
    
    
//    DEPARTMENT
    GET_DEPARTMENT("SELECT * FROM departments"),
    GET_BY_ID_DEPARTMENT("SELECT * FROM departments WHERE department_id = ?"),
    UPDATE_DEPARTMENT("UPDATE departments SET department_name = ?, manager_id = ?, location_id = ? WHERE department_id = ?"),
    DELETE_DEPARTMENT("DELETE FROM departments WHERE department_id = ?"),
    INSERT_DEPARTMENT("INSERT INTO departments(department_name, manager_id, location_id, department_id) values (?,?,?,?)"),
    
//    EMPLOYEE
    GET_EMPLOYEE("SELECT * FROM employees"),
    GET_BY_ID_EMPLOYEE("SELECT * FROM employees WHERE employee_id = ?"),
    UPDATE_EMPLOYEE("UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, commission_pct = ?, manager_id = ?, department_id = ? WHERE employee_id = ?"),
    INSERT_EMPLOYEE("INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id, employee_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)"),
    DELETE_EMPLOYEE("DELETE FROM employees WHERE employee_id = ?"),

//    COUNTRIES
    GET_COUNTRIES("SELECT * FROM countries"),
    GET_BY_ID_COUNTRIES("SELECT * FROM countries WHERE country_id = ?"),
    UPDATE_COUNTRIES("UPDATE countries SET country_name = ?, region_id = ? WHERE country_id = ?"),
    DELETE_COUNTRIES("DELETE FROM countries WHERE country_id = ?"),
    INSERT_COUNTRIES("INSERT INTO countries (country_name, region_id, country_id) values (?,?,?)"),

//    COUNTRIES
    GET_LOCATIONS("SELECT * FROM locations"),
    GET_BY_ID_LOCATIONS("SELECT * FROM locations WHERE location_id = ?"),
    UPDATE_LOCATIONS("UPDATE locations SET street_address = ?, postal_code = ?, city = ?, state_province = ?, country_id = ? WHERE location_id = ?"),
    DELETE_LOCATIONS("DELETE FROM locations WHERE location_id = ?"),
    INSERT_LOCATIONS("INSERT INTO locations (street_address, postal_code, city, state_province, country_id, location_id) values (?,?,?)")
    ;


    private final String displayQuery;

    Query(String displayQuery){
        this.displayQuery = displayQuery;
    }

    public String getDisplayQuery(){
        return displayQuery;
    }
}

