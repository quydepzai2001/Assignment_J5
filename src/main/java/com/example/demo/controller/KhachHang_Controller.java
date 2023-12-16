package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHang_Service;
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
@RequestMapping("/khachhang")
public class KhachHang_Controller {

    @Autowired
    KhachHang_Service khachHangService;

    @GetMapping("getAll")
    public String getPageKH(@RequestParam(value = "p",required = false,defaultValue = "1") Integer p, Model model){
        Pageable pageable = PageRequest.of(p-1,5);
        Page<KhachHang> page = khachHangService.getPage(pageable);
        model.addAttribute("listKH",page);
        return "admin/KhachHang/listKH";
    }

    @PostMapping("addKH")
    public String addKH(@ModelAttribute @Valid KhachHang khachHangAdd, BindingResult result, Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            return "admin/KhachHang/listKH";
        }
        khachHangAdd.setId(UUID.randomUUID().toString());
        khachHangService.addKH(khachHangAdd);
        return "redirect:/khachhang/getAll";
    }
    @GetMapping("/remove/{id}")
    public String deleteKH(@PathVariable("id") String id){
        khachHangService.delete(id);
        return "redirect:/khachhang/getAll";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id,Model model){
        model.addAttribute("editKH", khachHangService.detail(id).get());
        return "forward:/khachhang/getAll";
    }
    @GetMapping("/edit/{id}")
    public String editKH(Model model,@PathVariable("id") String id){
        model.addAttribute("editKH", khachHangService.detail(id).get());
        return "admin/KhachHang/updateKH";
    }
    @PostMapping("/updateKH")
    public String updateKH(@ModelAttribute @Valid KhachHang khachHangUpdate,BindingResult result,Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            return "admin/KhachHang/listKH";
        }
        khachHangService.addKH(khachHangUpdate);
        return "redirect:/khachhang/getAll";

    }

}
