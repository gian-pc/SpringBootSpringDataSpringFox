package com.gianpc.restapis.domains;

import java.util.Date;

public class Todo {
    private Long id;
    private String title;
    private String description;
    private boolean done;
    private Date dateCreated;
    private Date dueDate;
    private Date dateDone;
    private Date lastUpdated;
    private TodoType todoType;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
