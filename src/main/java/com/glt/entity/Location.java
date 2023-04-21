package com.glt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Location extends BaseEntity {

    private String name;
    @Transient
    private BigDecimal latitude;
    @Transient
    private BigDecimal longitude;

    private String address;
    private String postalCode;
    private String country;
    private String state;
    private String city;

    @OneToMany(mappedBy = "location")
    private List<Cinema> cinemas;















}
