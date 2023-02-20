//package com.kin.finalprojec.beans;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity // This annotation is used to indicate that a class should be mapped to a database table.
//@Table(name = "categories") //This annotation is used to specify the name of the table that a class should be mapped to.
//public class Categories {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
//    private int id;
//    @Enumerated(EnumType.ORDINAL)
////    @Enumerated(EnumType.STRING)
//    private Category name;
//
//}
//
//
//enum Category{
//    Food,Electricity,Restaurant,Vacation;
//}