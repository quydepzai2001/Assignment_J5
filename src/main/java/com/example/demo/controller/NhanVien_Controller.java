package com.example.demo.controller;

import com.example.demo.entity.DongSP;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.NhanVien__Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/nhanvien")
public class NhanVien_Controller {

    @Autowired
    NhanVien__Service nhanVien__service;

//    @GetMapping("/getAll")
//    public String getAll(Model model){
//    model.addAttribute("lisNv",nhanVien__service.getAll());
//    model.addAttribute("nvcuaHang",nhanVien__service.getAllLpb());
//    model.addAttribute("nvChucVu",nhanVien__service.getAllcv());
//    return "/admin/NhanVien/nhanVien";
//
//    }

    @GetMapping("/getAll")
    public String getPage(@RequestParam(value = "p",required = false,defaultValue = "1") Integer p, Model model){
        if(p<=0){
            model.addAttribute("pageError","Bạn đã về đầu trang");
            return "admin/NhanVien/nhanVien";
        }
        Pageable pageable = PageRequest.of(p-1,3);
        Page<NhanVien> page = nhanVien__service.getPage(pageable);
        if (p > page.getTotalPages()) {
            p=page.getTotalPages()-1;
            model.addAttribute("pageError","Bạn đã đến cuôi trang");
            return "admin/NhanVien/nhanVien";
        }
        model.addAttribute("lisNv",page);
        model.addAttribute("nvcuaHang",nhanVien__service.getAllLpb());
        model.addAttribute("nvChucVu",nhanVien__service.getAllcv());
        return "admin/NhanVien/nhanVien";
    }

    @PostMapping("/addNv")
    public String addNV(@ModelAttribute @Valid NhanVien nhanVienAdd, BindingResult result,Model model){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());

            }
            model.addAttribute("errors", errors);
            return "/admin/NhanVien/nhanVien";
        }
        nhanVienAdd.setId(UUID.randomUUID().toString());
        nhanVien__service.addNv(nhanVienAdd);
        return "redirect:/nhanvien/getAll";
    }


    @GetMapping("/detail/{id}")
    public String Deltail(@PathVariable("id")String id,Model model){
        model.addAttribute("editNV",nhanVien__service.deltail(id).get());

        return "forward:/getAll";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")String id, Model model){
        model.addAttribute("editNV",nhanVien__service.deltail(id).get());
        model.addAttribute("nvcuaHang",nhanVien__service.getAllLpb());
        model.addAttribute("nvChucVu",nhanVien__service.getAllcv());

        return "/admin/NhanVien/updateNV";
    }

    @PostMapping("/updateNv")
    public String updateNV(@ModelAttribute @Valid NhanVien nhanVienUpdate, BindingResult result,Model model){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());

            }
            model.addAttribute("errors", errors);
            return "/admin/NhanVien/updateNV";
        }
        nhanVien__service.updateDv(nhanVienUpdate);
        return "redirect:/nhanvien/getAll";
    }

    @GetMapping("/create")
    public String createDv(){
        return "redirect:/nhanvien/getAll";
    }

    @GetMapping("/delete/{id}")
    public String xoa(@PathVariable("id")String id){
        nhanVien__service.delete(id);

        return "redirect:/nhanvien/getAll";
    }

}
