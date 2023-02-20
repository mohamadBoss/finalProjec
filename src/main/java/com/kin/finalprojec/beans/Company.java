package com.kin.finalprojec.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity // This annotation is used to indicate that a class should be mapped to a database table.
@Table(name = "companies") //This annotation is used to specify the name of the table that a class should be mapped to.
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "company_Id")
    private int id;
    private String name;
    private String email;
    private String password;
    //    @Transient  // used to indicate that a field in an entity should not be persisted to the database
//    private ArrayList<Coupon> coupons;
//
    @ManyToMany(mappedBy = "companyID",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Coupon> coupons = new ArrayList<>();


}
