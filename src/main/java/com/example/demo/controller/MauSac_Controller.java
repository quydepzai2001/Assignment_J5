package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.service.MauSac_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
@RequestMapping("mausac")
public class MauSac_Controller {

    @Autowired
    MauSac_Service mauSacService;

    @GetMapping("/getAll")
    public String getPage(@RequestParam(value = "p", required = false,defaultValue = "1") Integer p, Model model){
        if(p<=0){
            model.addAttribute("pageError","Bạn đã về đầu trang");
            return "admin/MauSac/listMS";
        }
        Pageable pageable = PageRequest.of(p-1,3);
        Page<MauSac> page = mauSacService.getPage(pageable);
        if (p > page.getTotalPages()) {
            p=page.getTotalPages()-1;
            model.addAttribute("pageError","Bạn đã đến cuôi trang");
            return "admin/MauSac/listMS";
        }
        model.addAttribute("listMS",page);
        return "admin/MauSac/listMS";
    }

    @GetMapping("/edit/{id}")
    public String editMS(@PathVariable("id") String id, Model model){
        model.addAttribute("editMS",mauSacService.deltail(id).get());
        return "admin/MauSac/updateMS";
    }

    @PostMapping("/addMS")
    public String addMS(@ModelAttribute @Valid MauSac mauSacAdd, BindingResult result, Model model){
        if ( mauSacAdd.getTen().matches(".*\\s+.*")) {
            model.addAttribute("checktrong", "Không được chứa khoảng trắng");
            return "admin/MauSac/listMS";
        }
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            Pageable pageable = PageRequest.of(0,5);
            Page<MauSac> page = mauSacService.getPage(pageable);
            model.addAttribute("listMS",page);
            return "admin/MauSac/listMS";
        }
        mauSacAdd.setId(UUID.randomUUID().toString());
        mauSacService.addMS(mauSacAdd);
        return "redirect:/mausac/getAll";
    }

    @PostMapping("/updateMS")
    public String update(@ModelAttribute @Valid MauSac mauSacUpdate, BindingResult result,Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            Pageable pageable = PageRequest.of(0,5);
            Page<MauSac> page = mauSacService.getPage(pageable);
            model.addAttribute("listMS",page);
            return "admin/MauSac/updateMS";
        }
        mauSacService.addMS(mauSacUpdate);
        return "redirect:/mausac/getAll";
    }

    @GetMapping("/remove/{id}")
    public String deleteMS(@PathVariable("id") String id){
        mauSacService.deleteMS(id);
        return "redirect:/mausac/getAll";
    }

    @GetMapping("/detail/{id}")
    public String detailMS(@PathVariable("id") String id, Model model){
        model.addAttribute("editMS",mauSacService.deltail(id).get());
        return "forward:/mausac/getAll";
    }
}
