package com.example.demo.controller;

import com.example.demo.entity.CuaHang;
import com.example.demo.service.CuaHang_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("cuahang")

public class CuaHang_Controller {

    @Autowired
    CuaHang_Service cuaHangService;
    @GetMapping("/getAll")
    public String getAll(Model model){
        model.addAttribute("listCuaHang",cuaHangService.getAll());
        return "/admin/CuaHang/cuaHang";
    }

    @PostMapping("/addCh")
    public String AddCh(@ModelAttribute @Valid CuaHang cuaHangAdd, BindingResult result,Model model){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());

            }
            model.addAttribute("errors", errors);
            return "/admin/CuaHang/cuaHang";
        }
        cuaHangAdd.setId(UUID.randomUUID().toString());
        cuaHangService.addCH(cuaHangAdd);
        return "redirect:/cuahang/getAll";
    }


    @GetMapping("/edit/{id}")
    public String editFrom(@PathVariable("id")String id,Model model){

        model.addAttribute("editCH",cuaHangService.deltail(id).get());
        return "/admin/CuaHang/updateCh";
    }

    @PostMapping("/updateCh")
    public String UpdateCh(@ModelAttribute @Valid CuaHang cuaHangUpdate, BindingResult result,Model model){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());

            }
            model.addAttribute("errors", errors);
            return "/admin/CuaHang/updateCh";
        }
        cuaHangService.updateCH(cuaHangUpdate);
        return "redirect:/cuahang/getAll";
    }

    @GetMapping("/delete/{id}")
    public String xoa(@PathVariable("id")String id){
        cuaHangService.delete(id);
        return "redirect:/cuahang/getAll";


    }


}
