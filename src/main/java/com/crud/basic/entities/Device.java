package com.crud.basic.entities;

import com.jayway.jsonpath.internal.filter.ValueNodes;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;


import java.net.InetAddress;
import java.sql.Types;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "devices")
public class Device {

    private static final double CONSTANT = 6.25;
    private static final int PORCENTUAL = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    private String device;
    private double price;
    private double cost;

    @PostLoad
    private void valueOneVersion(){
        double value = (price * cost / CONSTANT) * PORCENTUAL;
    }

    @Formula("((price * cost) / 6.25 ) * 100")
    private double valueTwoVersion;

    @NotEmpty  //Usar en listas
    private List<String> elements;

    // mapped as VARCHAR
    private Currency currency;

    @Nationalized
    private String warranty;

    // mapped as VARCHAR
    private Locale locale;

    private InetAddress address;

    // Mapping JSON
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> stringMapJSON;

    //Mapping XML
    @JdbcTypeCode(SqlTypes.SQLXML)
    private Map<String, ValueNodes.StringNode> stringMapXML;

    @JdbcTypeCode(Types.VARBINARY)
    private BitSet bitSet;


}

/*
private double value;
public void calculateValue() {
        this.value = ((this.price * this.cost) / 6.25) * 100;
    }


     @Embeddable, @Embedded, @AttributeOverrides, @AssociationOverrides
     @Converted, @Convert, @SuppressWarnings, @JavaType(BitSetJavaType.class)
 */