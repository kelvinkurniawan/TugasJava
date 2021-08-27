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

    // Region Query
    GET_REGION("SELECT * FROM regions"),
    GET_BY_ID_REGION("SELECT * FROM regions WHERE region_id = ?"),
    UPDATE_REGION("UPDATE regions SET region_name = ? WHERE region_id = ?"),
    DELETE_REGION("DELETE FROM regions WHERE region_id = ?"),
    INSERT_REGION("INSERT INTO regions(region_name, region_id) VALUES (?, ?)"),
    
    // Job Query
    GET_JOB("SELECT * FROM jobs"),
    GET_BY_ID_JOB("SELECT * FROM jobs WHERE job_id = ?"),
    UPDATE_JOB("UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?"),
    DELETE_JOB("DELETE FROM jobs WHERE job_id = ?"),
    INSERT_JOB("INSERT INTO jobs(job_title, min_salary, max_salary, job_id) VALUES (?, ?, ?, ?) ");
    

    private final String displayQuery;

    Query(String displayQuery){
        this.displayQuery = displayQuery;
    }

    public String getDisplayQuery(){
        return displayQuery;
    }
}

