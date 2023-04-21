package com.glt.entity;

import com.glt.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@NoArgsConstructor
public class AccountDetail extends BaseEntity{

    private String address;
    private int age;
    private String city;
    private String country;
    private String name;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String state;












}
