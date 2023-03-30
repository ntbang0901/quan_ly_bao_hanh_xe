package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import com.cnpm.baohanhxe.model.NhanVienDto;
import com.cnpm.baohanhxe.model.TaiKhoanDto;
import com.cnpm.baohanhxe.service.StaffService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static javax.xml.bind.DatatypeConverter.parseString;

@Controller
@RequestMapping("manager/staffs")
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("staff", new NhanVienDto());
        return "staffs/addOrEdit";
    }

    @GetMapping("edit/{staffId}")
    public ModelAndView edit(@PathVariable("staffId") Long staffId, ModelMap model) {
        Optional<NhanVien> opt = staffService.findById(staffId);
        NhanVienDto dto = new NhanVienDto();

        if (opt.isPresent()) {
            NhanVien entity = opt.get();

            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);
            model.addAttribute("staff", dto);
            return new ModelAndView("staffs/addOrEdit", model);
        }
        model.addAttribute("message", "staff not is existed");
        return new ModelAndView("redirect:/manager/staffs", model);
    }

    @GetMapping("delete/{staffId}")
    public ModelAndView delete(ModelMap model, @PathVariable("staffId") Long staffId) {

        try {
            Optional<NhanVien> opt = staffService.findById(staffId);
            if (opt.isPresent()) {
                System.out.println(opt.get());
                staffService.delete(opt.get());
                model.addAttribute("message", "staff is deleted");

            } else {
                model.addAttribute("message", "staff is not found");
            }
            return new ModelAndView("forward:/manager/staffs", model);
        }catch(Exception e) {
            model.addAttribute("message", "Xoa khong thanh cong");
            return new ModelAndView("forward:/manager/staffs", model);
        }


    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @Valid @ModelAttribute("staff") NhanVienDto dto,
            BindingResult result) {
        System.out.println(dto);
        System.out.println(result.hasErrors());
        Optional<NhanVien> nvsv = staffService.findByCmnd(dto.getCmnd());
        if(nvsv.isPresent() && !dto.getEdit()){
            model.addAttribute("message", "CMND đã tồn tại!");
            return new ModelAndView("/staffs/addOrEdit");
            
        }

        if (result.hasErrors()) {
            return new ModelAndView("/staffs/addOrEdit");
        }

        NhanVien entity = new NhanVien();
        BeanUtils.copyProperties(dto, entity);
        System.out.println(entity);
        staffService.save(entity);
        model.addAttribute("message", "staff is saved!");
        return new ModelAndView("redirect:/manager/staffs", model);
    }

 
    @GetMapping("")
    public String search(ModelMap model,
            @RequestParam(name = "ten", required = false) String ten,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize,Sort.by("ten"));
        Page<NhanVien> resultPage = null;

        // System.out.println(resultPage);
        //
        if (StringUtils.hasText(ten)) {
            resultPage = staffService.findByTenContaining(ten,pageable);
            model.addAttribute("ten", ten);
        } else {
            resultPage = staffService.findAll(pageable);

        }
        int totalPages = resultPage.getTotalPages();
        if (totalPages > 0) {
            int start = 1;
            int end = totalPages;

            if (totalPages > 5) {
                if (end == totalPages)
                    start = end - 5;
                else if (start == 1)
                    end = start + 5;
            }
            System.out.println("Start: " + start);
            System.out.println("End: " + end);

            List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            System.out.println("1" + pageNumbers);

        }
        System.out.println(resultPage.getNumber() + 1);
        model.addAttribute("staffPage", resultPage);
        List<NhanVien> list = resultPage.getContent();
        model.addAttribute("staffs", list);
        // System.out.println(resultPage.hasContent());
        return "staffs/searchpaginated";
    }
}
