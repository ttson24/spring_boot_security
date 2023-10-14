package com.spring.boot.security.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "isShow")
    private boolean isShow;

    public Review() {
    }

    public Review(String comment, boolean isShow) {
        this.comment = comment;
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", isShow=" + isShow +
                '}';
    }
}
