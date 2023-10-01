package com.spring.boot.security.management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="Employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="deleted_at")
    private Date deleteAt;

    public Employees() {
        super();
    }

    public Employees(String firstName, String lastName, String email, Date createdAt, Date updatedAt, Date deleteAt) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleteAt = deleteAt;
    }

}
