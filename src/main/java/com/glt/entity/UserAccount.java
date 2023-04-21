package com.glt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String userName;

    @OneToOne
    private AccountDetail accountDetail;

    @OneToMany(mappedBy = "userAccount")
    private List<Ticket> tickets;











}
