package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NSX")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    @NotEmpty( message = "Khong de ma")
    private String ma;

    @Column(name = "Ten")
    @NotEmpty( message = "Khong de ten")
    private String ten;
}