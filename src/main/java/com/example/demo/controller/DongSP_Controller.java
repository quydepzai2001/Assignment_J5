package com.example.demo.controller;


import com.example.demo.entity.DongSP;
import com.example.demo.service.DongSP_Service;
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
@RequestMapping("/dongsp")
public class DongSP_Controller {

    @Autowired
    DongSP_Service dongSPService;

    @GetMapping("getAll")
    public String getPage(@RequestParam(value = "p",required = false,defaultValue = "1") Integer p, Model model){
        if(p<=0){
            model.addAttribute("pageError","Bạn đã về đầu trang");
            return "admin/dongsp/listDSP";
        }
        Pageable pageable = PageRequest.of(p-1,3);
        Page<DongSP> page = dongSPService.getPage(pageable);
        if (p > page.getTotalPages()) {
            p=page.getTotalPages()-1;
            model.addAttribute("pageError","Bạn đã đến cuôi trang");
            return "admin/DongSP/listDSP";
        }
        model.addAttribute("listDSP",page);
        return "admin/DongSP/listDSP";
    }
    @GetMapping("edit/{id}")
    public String editDSP(@PathVariable("id") String id, Model model){
        model.addAttribute("editDSP", dongSPService.deltail(id).get());
        return "admin/DongSP/updateDSP";

    }
    @GetMapping("remove/{id}")
    public String deletedongSP(@PathVariable("id") String id){
        dongSPService.deleteDSP(id);
        return "redirect:/dongsp/getAll";
    }

    @PostMapping("addDSP")
    public String adDDSP(@ModelAttribute @Valid DongSP dongSPAdd, BindingResult result, Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            Pageable pageable = PageRequest.of(1,3);
            Page<DongSP> page = dongSPService.getPage(pageable);
            model.addAttribute("listDSP",page);
            return "admin/DongSP/listDSP";
        }
        dongSPAdd.setId(UUID.randomUUID().toString());
        dongSPService.addDSP(dongSPAdd);
        return "redirect:/dongsp/getAll";
    }
    @PostMapping("updateDSP")
    public String updateDongSP(@ModelAttribute @Valid DongSP dongSPUpdate,BindingResult result,Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            Pageable pageable = PageRequest.of(1,3);
            Page<DongSP> page = dongSPService.getPage(pageable);
            model.addAttribute("listDSP",page);
            return "admin/DongSP/updateDSP";
        }
        dongSPService.updateDSP(dongSPUpdate);
        return "redirect:/dongsp/getAll";
    }



}
