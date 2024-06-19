package com.example.LeAnhKiet.services;

import com.example.LeAnhKiet.entity.NhanVien;
import com.example.LeAnhKiet.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public Page<NhanVien> getAllNhanVienPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienRepository.findAll(pageable);
    }

    public NhanVien saveNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(String maNhanVien) {
        nhanVienRepository.deleteById(maNhanVien);
    }

    public NhanVien getNhanVienById(String maNhanVien) {
        return nhanVienRepository.findById(maNhanVien).orElse(null);
    }
}
