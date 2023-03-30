package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.LoaiXe;
import com.cnpm.baohanhxe.model.LoaiXeDto;

import com.cnpm.baohanhxe.service.LoaixeService;
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
@RequestMapping("manager/loaixes")
public class LoaiXeController {
    @Autowired
    LoaixeService loaixeService;




    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("loaixe", new LoaiXeDto());
        return "loaixes/addOrEdit";
    }

    @GetMapping("edit/{maLoaiXe}")
    public ModelAndView edit(@PathVariable("maLoaiXe") Long maLoaiXe, ModelMap model) {
        Optional<LoaiXe> opt = loaixeService.findById(maLoaiXe);
        LoaiXeDto dto = new LoaiXeDto();

        if (opt.isPresent()) {
            LoaiXe entity = opt.get();

            BeanUtils.copyProperties(entity, dto);
            dto.setEdit(true);
            model.addAttribute("loaixe", dto);
            return new ModelAndView("/loaixes/addOrEdit", model);
        }
        model.addAttribute("message", "loaixe not is existed");
        return new ModelAndView("redirect:/manager/loaixes", model);
    }

    @GetMapping("delete/{loaixeId}")
    public ModelAndView delete(ModelMap model, @PathVariable("loaixeId") Long loaixeId) {
        Optional<LoaiXe> opt = loaixeService.findById(loaixeId);
        if (opt.isPresent()) {
            loaixeService.delete(opt.get());
            model.addAttribute("message", "loaixe is deleted");

        } else {
            model.addAttribute("message", "loaixe is not found");
        }
        return new ModelAndView("forward:/manager/loaixes", model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @Valid @ModelAttribute("loaixe") LoaiXeDto dto,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/loaixes/addOrEdit");
        }
        LoaiXe entity = new LoaiXe();
        BeanUtils.copyProperties(dto, entity);
        loaixeService.save(entity);
        model.addAttribute("message", "loaixe is saved!");
        return new ModelAndView("redirect:/manager/loaixes", model);
    }

    @GetMapping("")
    public String search(ModelMap model,
                         @RequestParam(name = "tenLoai", required = false) String tenLoai,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("tenLoai"));
        Page<LoaiXe> resultPage = null;

        if (StringUtils.hasText(tenLoai)) {
            resultPage = loaixeService.findByTenLoaiContaining(tenLoai, pageable);
            model.addAttribute("tenLoai", tenLoai);
        } else {
            resultPage = loaixeService.findAll(pageable);

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
        model.addAttribute("loaixePage", resultPage);
        List<LoaiXe> list = resultPage.getContent();
        model.addAttribute("loaixes", list);
        // System.out.println(resultPage.hasContent());
        return "loaixes/searchpaginated";
    }
}
