package com.kin.finalprojec.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This annotation is used to indicate that a class should be mapped to a database table.
@Table(name = "coupons") //This annotation is used to specify the name of the table that a class should be mapped to.
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int id;
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "company_id", referencedColumnName = "id")
//    private Company company;

    private int companyID;
    private Category category;
    private String title;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    private Date endDate;
    private int amount;
    private double price;
    private String image;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = false)
    @JoinTable(
            name="customer_vs_coupons",
            joinColumns={@JoinColumn(name="customer_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="coupon_id", referencedColumnName="id")})
    private List<Customer>customers;

}
