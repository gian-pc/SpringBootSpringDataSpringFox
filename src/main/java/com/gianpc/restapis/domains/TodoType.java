package com.gianpc.restapis.domains;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@XmlRootElement
public class TodoType  {
    private String code;
    private String description;
    private Date dateCreated;
    private Date lastUpdated;
}
