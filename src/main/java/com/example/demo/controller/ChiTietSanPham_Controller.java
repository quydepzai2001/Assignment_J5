package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.ChiTietSanPham_Repository;
import com.example.demo.service.ChiTietSanPham_Service;
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
@RequestMapping("chitietSp")
public class ChiTietSanPham_Controller {

    @Autowired
    ChiTietSanPham_Service chiTietSanPhamService;

//    @GetMapping("/getAll")
//    public String getAll(Model model){
//        model.addAttribute("listCtsp",chiTietSanPhamService.getAll());
//        model.addAttribute("cbbSp",chiTietSanPhamService.getSp());
//        model.addAttribute("cbbMc",chiTietSanPhamService.getMS());
//        model.addAttribute("cbbDongSP",chiTietSanPhamService.getDSP());
//        return "/admin/ChiTietSanPham/chiTietSp";
//    }

    @GetMapping("/getAll")
    public String getPage(@RequestParam(value = "p",required = false,defaultValue = "1") Integer p, Model model){
        if(p<=0){
            model.addAttribute("pageError","Bạn đã về đầu trang");
            return "/admin/ChiTietSanPham/chiTietSp";
        }
        Pageable pageable = PageRequest.of(p-1,3);
        Page<ChiTietSanPham> page = chiTietSanPhamService.getPage(pageable);
        if (p > page.getTotalPages()) {
            p=page.getTotalPages()-1;
            model.addAttribute("pageError","Bạn đã đến cuôi trang");
            return "/admin/ChiTietSanPham/chiTietSp";
        }
        model.addAttribute("listCtsp",page);
        model.addAttribute("cbbSp",chiTietSanPhamService.getSp());
        model.addAttribute("cbbMc",chiTietSanPhamService.getMS());
        model.addAttribute("cbbDongSP",chiTietSanPhamService.getDSP());
        return "/admin/ChiTietSanPham/chiTietSp";
    }

    @PostMapping("/add")
    public String AddCh(@ModelAttribute @Valid ChiTietSanPham chiTietSanPhamAdd, BindingResult result, Model model){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());

            }
            model.addAttribute("errors", errors);
            return "/admin/ChiTietSanPham/chiTietSp";
        }
        chiTietSanPhamAdd.setId(UUID.randomUUID().toString());
        chiTietSanPhamService.addCH(chiTietSanPhamAdd);
        return "redirect:/chitietSp/getAll";
    }


    @GetMapping("/delete/{id}")
    public String xoa(@PathVariable("id")String id){
        chiTietSanPhamService.delete(id);

        return "redirect:/chitietSp/getAll";
    }
    @GetMapping("/detail/{id}")
    public String Deltail(@PathVariable("id")String id,Model model){
        model.addAttribute("editctsp",chiTietSanPhamService.deltail(id).get());
        model.addAttribute("cbbSp",chiTietSanPhamService.getSp());
        model.addAttribute("cbbMc",chiTietSanPhamService.getMS());
        model.addAttribute("cbbDongSP",chiTietSanPhamService.getDSP());
        return "/admin/ChiTietSanPham/updateSp";
    }

    @PostMapping("/update")
    public String Update(@ModelAttribute @Valid ChiTietSanPham chiTietSanPhamUpdate, BindingResult result, Model model){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "/admin/ChiTietSanPham/updateSp";
        }
        chiTietSanPhamService.addCH(chiTietSanPhamUpdate);
        return "redirect:/chitietSp/getAll";
    }


}
