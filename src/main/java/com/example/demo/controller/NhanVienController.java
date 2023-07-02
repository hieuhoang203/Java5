package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.service.impl.ChucVuService;
import com.example.demo.service.impl.CuaHangService;
import com.example.demo.service.impl.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping(value = "/nhan-vien")
public class NhanVienController {

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private NhanVienService nhanVienService;

    private Pageable pageable = PageRequest.of(0, 5);

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("list_cv", this.chucVuService.findAll());
        model.addAttribute("list_ch", this.cuaHangService.findAll());
        model.addAttribute("list_nv", this.nhanVienService.findAll(pageable));
        return "index";
    }

    @PostMapping(value = "/store")
    public String store(@Valid NhanVien nhanVien, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("nhanVien", nhanVien);
            model.addAttribute("list_cv", this.chucVuService.findAll());
            model.addAttribute("list_ch", this.cuaHangService.findAll());
            model.addAttribute("list_nv", this.nhanVienService.findAll(pageable));
            return "index";
        }
        this.nhanVienService.save(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping(value = "/index/{page}")
    public String pageNumber(@PathVariable String page, Model model, NhanVien nhanVien){
        pageable = PageRequest.of(Integer.parseInt(page), 5);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("list_cv", this.chucVuService.findAll());
        model.addAttribute("list_ch", this.cuaHangService.findAll());
        model.addAttribute("list_nv", this.nhanVienService.findAll(pageable));
        return "index";
    }

    @GetMapping("/index/next")
    public String next(Model model, NhanVien nhanVien){
        pageable = pageable.next();
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("list_cv", this.chucVuService.findAll());
        model.addAttribute("list_ch", this.cuaHangService.findAll());
        model.addAttribute("list_nv", this.nhanVienService.findAll(pageable));
        return "index";
    }

    @GetMapping("/index/previous")
    public String previous(Model model, NhanVien nhanVien){
        pageable = pageable.previousOrFirst();
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("list_cv", this.chucVuService.findAll());
        model.addAttribute("list_ch", this.cuaHangService.findAll());
        model.addAttribute("list_nv", this.nhanVienService.findAll(pageable));
        return "index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable UUID id){
        model.addAttribute("nhanVien", this.nhanVienService.findById(id));
        model.addAttribute("list_cv", this.chucVuService.findAll());
        model.addAttribute("list_ch", this.cuaHangService.findAll());
        return "edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(NhanVien nhanVien){
        this.nhanVienService.update(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable UUID id, Model model){
        model.addAttribute("nhanVien", this.nhanVienService.findById(id));
        model.addAttribute("list_cv", this.chucVuService.findAll());
        model.addAttribute("list_ch", this.cuaHangService.findAll());
        model.addAttribute("list_nv", this.nhanVienService.findAll(pageable));
        return "index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable UUID id){
        this.nhanVienService.delete(id);
        return "redirect:/nhan-vien/index";
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam(name = "min") int min, @RequestParam(name = "max") int max, Model model, NhanVien nhanVien){
        pageable = PageRequest.of(0, 5);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("list_cv", this.chucVuService.findAll());
        model.addAttribute("list_ch", this.cuaHangService.findAll());
        model.addAttribute("list_nv", this.nhanVienService.search(min, max, pageable));
        return "index";
    }
}
