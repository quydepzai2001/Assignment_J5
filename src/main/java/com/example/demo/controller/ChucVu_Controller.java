package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.service.ChucVu_Service;
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
@RequestMapping("/chucvu")
public class ChucVu_Controller {

    @Autowired
    private ChucVu_Service chucVuService;

    @GetMapping("/getAll")
    public String getAll(Model model, @RequestParam(value = "p",required = false,defaultValue = "1") int p){
        Pageable pageable = PageRequest.of(p-1,3);
        Page<ChucVu> page = chucVuService.page(pageable);
        model.addAttribute("listCV",page);
        return "admin/ChucVu/listCV";
    }

    @PostMapping("/addCV")
    public String addCV(@ModelAttribute @Valid ChucVu chucVuAdd, BindingResult result, Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            return "admin/ChucVu/listCV";
        }
        chucVuAdd.setId(UUID.randomUUID().toString());
        chucVuService.addChucVu(chucVuAdd);
        return "redirect:/chucvu/getAll";
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable("id") String id){
        chucVuService.delete(id);
        return "redirect:/chucvu/getAll";
    }
    @GetMapping("edit/{id}")
    public String formUpdateCV(@PathVariable("id") String id,Model model){
        model.addAttribute("editCV",chucVuService.detail(id).get());
        return "admin/ChucVu/updateCV";
    }
    @PostMapping("/updateCV")
    public String updateCV(@ModelAttribute @Valid ChucVu chucVuUpdate,BindingResult result,Model model){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            return "admin/ChucVu/updateCV";
        }
        chucVuService.addChucVu(chucVuUpdate);
        return "redirect:/chucvu/getAll";
    }

}
