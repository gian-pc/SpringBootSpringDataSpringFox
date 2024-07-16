package com.gianpc.restapis.domains;

import lombok.Data;

import java.util.Date;

@Data
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
}
