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
@Table(name = "ChucVu")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private String id;

    @NotEmpty(message = "Không được để trống mã")
    @Column(name = "ma")
    private String ma;

    @NotEmpty(message = "Không được để trống tên")
    @Column(name = "ten")
    private String ten;
}
