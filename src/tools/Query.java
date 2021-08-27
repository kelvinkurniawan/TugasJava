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

    GET_REGION("SELECT * FROM regions"),
    GET_BY_ID_REGION("SELECT * FROM regions WHERE region_id = ?"),
    UPDATE_REGION("UPDATE regions SET region_name = ? WHERE region_id = ?"),
    DELETE_REGION("DELETE FROM regions WHERE region_id = ?"),
    INSERT_REGION("INSERT INTO regions(region_name, region_id) VALUES (?, ?)"),
    INSERT_OR_UPDATE_REGION("INSERT INTO regions(region_id, region_name) VALUES (?, ?) ON DUPLICATE KEY UPDATE region_name = ?");

    private final String displayQuery;

    Query(String displayQuery){
        this.displayQuery = displayQuery;
    }

    public String getDisplayQuery(){
        return displayQuery;
    }
}

