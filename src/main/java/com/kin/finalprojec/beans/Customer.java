package com.kin.finalprojec.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity // This annotation is used to indicate that a class should be mapped to a database table.
@Table(name = "customers") //This annotation is used to specify the name of the table that a class should be mapped to.
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    int id;
    String firstName;
    String lastName;
    String email;
    String password;
//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}/*, orphanRemoval = true*/)
//    @JoinTable(
//            name = "customer_vs_coupons",
//            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "coupon_id", referencedColumnName = "id")})
//    public List<Coupon> coupons;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "customer_vs_coupons",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "coupon_id", referencedColumnName = "id")})
    private List<Coupon> coupons;
}
