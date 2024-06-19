package com.example.LeAnhKiet.controller;

import com.example.LeAnhKiet.entity.NhanVien;
import com.example.LeAnhKiet.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String viewHomePage(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<NhanVien> nhanVienPage = nhanVienService.getAllNhanVienPaginated(page, 5);
        model.addAttribute("nhanVienPage", nhanVienPage);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "add";
    }

    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        model.addAttribute("nhanVien", nhanVien);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateNhanVien(@PathVariable("id") String id, @ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/xoa/{id}")
    public String deleteNhanVien(@PathVariable("id") String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }

    // Thêm đoạn này để tự động chuyển hướng tới /nhanvien khi truy cập vào địa chỉ gốc
    @Controller
    public static class HomeController {
        @GetMapping("/")
        public String home() {
            return "redirect:/nhanvien";
        }
    }
}
