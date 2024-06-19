package com.example.LeAnhKiet.services;

import com.example.LeAnhKiet.entity.PhongBan;
import com.example.LeAnhKiet.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {

    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> findAllPhongBan() {
        return phongBanRepository.findAll();
    }
}

