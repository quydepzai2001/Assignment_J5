package com.example.demo.repository;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSP_Repository extends JpaRepository<DongSP,String> {
}
