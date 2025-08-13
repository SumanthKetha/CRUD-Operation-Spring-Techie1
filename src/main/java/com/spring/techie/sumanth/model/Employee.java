package com.spring.techie.sumanth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private double salary;

}
