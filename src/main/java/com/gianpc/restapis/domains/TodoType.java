package com.gianpc.restapis.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder(alphabetic = true) // muestra los datos en orden alfabético
//@JsonPropertyOrder({"description", "code"}) // ordenamiento personalizado
//@JsonInclude(JsonInclude.Include.NON_NULL) // or NON_EMPTY, ALWAYS, CUSTOM
@XmlRootElement // cambiamos el root element
@XmlAccessorType(XmlAccessType.FIELD) // aplicar tecnica de serialización y deserialización
@XmlType(propOrder = {"code","dateCreated","lastUpdated"}) // orden de los elementos en el xml
public class TodoType  {
    private String code;
    //@JsonIgnore // ignora el campo description en Json
    @XmlTransient // ignora el campo description en Xml
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateCreated;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date lastUpdated;
}

















