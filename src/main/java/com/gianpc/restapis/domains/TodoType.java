package com.gianpc.restapis.domains;

import lombok.Data;

import java.util.Date;

@Data
public class TodoType  {
    private String code;
    private String description;
    private Date dateCreated;
    private Date lastUpdated;
}
