package com.example.demo.controller;


import com.example.demo.entity.NSX;
import com.example.demo.service.NSX_Service;
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
@RequestMapping("/nsx")
public class NSX_Controller {

    @Autowired
    NSX_Service nsxService;


    @GetMapping("getAll")
    public String getAll(@RequestParam(value = "p",required = false,defaultValue = "1") Integer p, Model model){
        if(p<=0){
            model.addAttribute("pageError","Bạn đã về đầu trang");
            return "admin/NSX/listNSX";
        }
        Pageable pageable = PageRequest.of(p-1,3);
        Page<NSX> page = nsxService.getPage(pageable);
        if (p > page.getTotalPages()) {
            p=page.getTotalPages()-1;
            model.addAttribute("pageError","Bạn đã đến cuôi trang");
            return "admin/NSX/listNSX";
        }
        model.addAttribute("listNSX",page);
        return "admin/NSX/listNSX";
    }
    @GetMapping("/detail/{id}")
    public String detailNSX(@PathVariable("id") String id, Model model){
        model.addAttribute("editNSX",nsxService.detail(id).get());
        return "forward:/nsx/getAll";
    }
    @GetMapping("remove/{id}")
    public String removeNSX(@PathVariable("id") String id){
        nsxService.deleteNSX(id);
        return "redirect:/nsx/getAll";
    }
    @GetMapping("/create")
    public String createNsx(){
        return "redirect:/nsx/getAll";
    }
    @PostMapping("/addNSX")
    public String addNSX(@ModelAttribute @Valid NSX NSXAdd, BindingResult result, Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            return "admin/NSX/listNSX";
        }
        NSXAdd.setId(UUID.randomUUID().toString());
        nsxService.addNSX(NSXAdd);
        return "redirect:/nsx/getAll";
    }
    @GetMapping("/edit/{id}")
    public String editNsx(@PathVariable("id") String id,Model model){
        model.addAttribute("editNSX",nsxService.detail(id).get());
        return "admin/NSX/updateNSX";
    }
    @PostMapping("updateNSX")
    public String updateNsx(@ModelAttribute @Valid NSX NSXUpdate,BindingResult result,Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            return "admin/NSX/updateNSX";
        }
        nsxService.addNSX(NSXUpdate);
        return "redirect:/nsx/getAll";
    }
}
