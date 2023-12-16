package com.example.demo.repository;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSac_Repository extends JpaRepository<MauSac,String> {
}
