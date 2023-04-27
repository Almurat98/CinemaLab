package com.glt.entity;

import com.glt.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountDetails extends BaseEntity{

    private String address;
    private int age;
    private String city;
    private String country;
    private String name;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String state;


    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;

    @Override
    public String toString() {
        return "AccountDetails{" +
                "address='" + address + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                ", state='" + state + '\'' +
                '}';
    }
}
