package com.example.demo.repository;

import com.example.demo.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHang_Repository extends JpaRepository<CuaHang,String> {
}
