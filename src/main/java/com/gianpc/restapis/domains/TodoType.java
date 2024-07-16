package com.gianpc.restapis.domains;

import java.util.Date;

public class TodoType  {
    private String code;
    private String description;
    private Date dateCreated;
    private Date lastUpdated;

    // getters and setters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
