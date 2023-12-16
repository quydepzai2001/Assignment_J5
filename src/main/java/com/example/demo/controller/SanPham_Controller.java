package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPham_Service;
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
@RequestMapping("sanpham")
public class SanPham_Controller {

    @Autowired
    private SanPham_Service sanPhamService;

    @GetMapping("getAll")
    public String getPage(@RequestParam(value = "p",required = false,defaultValue = "1") Integer p, Model model){
        if(p<=0){
            model.addAttribute("pageError","Bạn đã về đầu trang");
            return "admin/sanPham/listSP";
        }
        Pageable pageable = PageRequest.of(p-1,3);
        Page<SanPham> page = sanPhamService.getPage(pageable);
        if (p > page.getTotalPages()) {
            p=page.getTotalPages()-1;
            model.addAttribute("pageError","Bạn đã đến cuôi trang");
            return "admin/SanPham/listSP";
        }
        model.addAttribute("listSP",page);
        return "admin/SanPham/listSP";
    }

    @PostMapping("/addSP")
    public String addSP(@ModelAttribute @Valid SanPham sanPhamAdd, BindingResult result, Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            Pageable pageable = PageRequest.of(1,3);
            Page<SanPham> page = sanPhamService.getPage(pageable);
            model.addAttribute("listSP",page);
            return "admin/SanPham/listSP";
        }
        sanPhamAdd.setId(UUID.randomUUID().toString());
        sanPhamService.addSP(sanPhamAdd);
        return "redirect:/sanpham/getAll";
    }

    @GetMapping("remove/{id}")
    public String removeSP(@PathVariable("id") String id){
        sanPhamService.delete(id);
        return "redirect:/sanpham/getAll";
    }

    @GetMapping("edit/{id}")
    public String editSP(@PathVariable("id") String id,Model model){
        model.addAttribute("editSP",sanPhamService.detailSP(id).get());
        return "admin/SanPham/updateSP";
    }

    @PostMapping("/updateSP")
    public String updateSP(@ModelAttribute @Valid SanPham sanPhamUpdate,BindingResult result,Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            Pageable pageable = PageRequest.of(1,3);
            Page<SanPham> page = sanPhamService.getPage(pageable);
            model.addAttribute("listSP",page);
            return "admin/SanPham/updateSP";
        }
        sanPhamService.addSP(sanPhamUpdate);
        return "redirect:/sanpham/getAll";
    }
    @GetMapping("detail/{id}")
    public String detaiSP(@PathVariable("id") String id,Model model){
        model.addAttribute("editSP",sanPhamService.detailSP(id).get());
        return "forward:/sanpham/getAll";
    }

}
