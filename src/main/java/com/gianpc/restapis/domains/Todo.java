package com.gianpc.restapis.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity

// selecciona todos los objetos Todo donde el campo done es verdadero.
@NamedQuery(name = "Todo.fetchAllDone", query = "SELECT t FROM Todo t WHERE t.done = true")

// selecciona todos los objetos Todo donde el campo title es igual al valor dado.
@NamedQuery(name = "Todo.fetchAllByName", query = "SELECT t FROM Todo t WHERE t.title = ?1")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // IDENTITY, SEQUENCE, TABLE
    private Long id;

    @NotNull
    private String title;

    @JsonIgnore
    private String description;
    private boolean done; // 1 = true, 0 = False

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dateCreated;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dueDate;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dateDone;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date lastUpdated;

    @ManyToOne
    @JsonProperty("type")
    private TodoType todoType;
}
