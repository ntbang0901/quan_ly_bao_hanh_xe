package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;
import com.cnpm.baohanhxe.model.LoaiPhuTungDto;

import com.cnpm.baohanhxe.service.LoaiPhutungService;
import com.cnpm.baohanhxe.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
@RequestMapping("manager/loaiphutungs")
public class LoaiPhutungController {
    @Autowired
    private LoaiPhutungService loaiphutungService;




    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("loaiphutung", new LoaiPhuTungDto());
        return "loaiphutungs/addOrEdit";
    }

    @GetMapping("edit/{maLoaiPhutung}")
    public ModelAndView edit(@PathVariable("maLoaiPhutung") Long maLoaiPhutung, ModelMap model) {
        Optional<LoaiPhuTung> opt = loaiphutungService.findById(maLoaiPhutung);
        LoaiPhuTungDto dto = new LoaiPhuTungDto();

        if (opt.isPresent()) {
            LoaiPhuTung entity = opt.get();

            BeanUtils.copyProperties(entity, dto);
            dto.setEdit(true);
            model.addAttribute("loaiphutung", dto);
            return new ModelAndView("/loaiphutungs/addOrEdit", model);
        }
        model.addAttribute("message", "Loại phụ tùng không tồn tại");
        return new ModelAndView("redirect:/manager/loaiphutungs", model);
    }

    @GetMapping("delete/{loaiphutungId}")
    public ModelAndView delete(ModelMap model, @PathVariable("loaiphutungId") Long loaiphutungId) {
        Optional<LoaiPhuTung> opt = loaiphutungService.findById(loaiphutungId);
        if (opt.isPresent()) {
            loaiphutungService.delete(opt.get());
            model.addAttribute("message", "Loại phụ tùng đã được xóa");

        } else {
            model.addAttribute("message", "Không tìm thấy loại phụ tùng");
        }
        return new ModelAndView("forward:/manager/loaiphutungs", model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @Valid @ModelAttribute("loaiphutung") LoaiPhuTungDto dto,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/loaiphutungs/addOrEdit");
        }
        LoaiPhuTung entity = new LoaiPhuTung();
        BeanUtils.copyProperties(dto, entity);
        loaiphutungService.save(entity);
        model.addAttribute("message", "Phụ tùng đã được lưu!");
        return new ModelAndView("redirect:/manager/loaiphutungs", model);
    }

    @GetMapping("")
    public String search(ModelMap model,
                         @RequestParam(name = "tenLoai", required = false) String tenLoai,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("tenLoai"));
        Page<LoaiPhuTung> resultPage = null;

        if (StringUtils.hasText(tenLoai)) {
            resultPage = loaiphutungService.findByTenLoaiContaining(tenLoai, pageable);
            model.addAttribute("tenLoai", tenLoai);
        } else {
            resultPage = loaiphutungService.findAll(pageable);

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
        model.addAttribute("number", resultPage.getNumber());
        System.out.println(resultPage.getNumber() + 1);
        model.addAttribute("loaiphutungPage", resultPage);
        List<LoaiPhuTung> list = resultPage.getContent();
        model.addAttribute("loaiphutungs", list);
        // System.out.println(resultPage.hasContent());
        return "loaiphutungs/searchpaginated";
    }
}
