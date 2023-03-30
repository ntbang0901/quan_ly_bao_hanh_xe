package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.KhachHang;
import com.cnpm.baohanhxe.model.KhachHangDto;
import com.cnpm.baohanhxe.model.LoaiXeDto;
import com.cnpm.baohanhxe.model.XeDto;
import com.cnpm.baohanhxe.service.CustomerService;

import com.cnpm.baohanhxe.service.LoaixeService;
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
    @RequestMapping("manager/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    LoaixeService loaixeService;

    @Autowired

    @ModelAttribute("loaixes")
    public List<LoaiXeDto> getLoaixe() {
        return loaixeService.findAll().stream().map(item -> {
            LoaiXeDto dto = new LoaiXeDto();
            BeanUtils.copyProperties(item, dto);
            System.out.println(dto);
            return dto;
        }).toList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("customer", new KhachHangDto());
        return "customers/addOrEdit";
    }

    @GetMapping("edit/{maKhach}")
    public ModelAndView edit(@PathVariable("maKhach") Long maKhach, ModelMap model) {
        Optional<KhachHang> opt = customerService.findById(maKhach);
        KhachHangDto dto = new KhachHangDto();

        if (opt.isPresent()) {
            KhachHang entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);
            model.addAttribute("customer", dto);
            return new ModelAndView("customers/addOrEdit", model);
        }
        model.addAttribute("message", "customer not is existed");
        return new ModelAndView("redirect:/manager/customers", model);
    }

    @GetMapping("delete/{maKhach}")
    public ModelAndView delete(ModelMap model, @PathVariable("maKhach") Long maKhach) {
        Optional<KhachHang> opt = customerService.findById(maKhach);
        if (opt.isPresent()) {
            customerService.delete(opt.get());
            model.addAttribute("message", "customer is deleted");

        } else {
            model.addAttribute("message", "customer is not found");
        }
        return new ModelAndView("forward:/manager/customers", model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @Valid @ModelAttribute("customer") KhachHangDto dto,
            BindingResult result) {

        System.out.println(dto);
        System.out.println(result.hasErrors());

        Optional<KhachHang> khsv = customerService.findByCmnd(dto.getCmnd());
        if(khsv.isPresent() && !dto.getEdit()){
            model.addAttribute("message", "CMND đã tồn tại!");
            return new ModelAndView("/customers/addOrEdit");
            
        }
        if (result.hasErrors()) {
            return new ModelAndView("/customers/addOrEdit");
        }

        KhachHang entity = new KhachHang();
        BeanUtils.copyProperties(dto, entity);
        System.out.println(entity);
        customerService.save(entity);
        model.addAttribute("message", "customers is saved!");
        return new ModelAndView("redirect:/manager/customers", model);
    }

    // @RequestParam(name = "name", required = false) String name,
    // @RequestParam("page") Optional<Integer> page,
    // @RequestParam("size") Optional<Integer> size
    @GetMapping("")
    public String search(ModelMap model,
            @RequestParam(name = "ten", required = false) String ten,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("ten"));
        Page<KhachHang> resultPage = null;

        // System.out.println(resultPage);
        //
        if (StringUtils.hasText(ten)) {
            resultPage = customerService.findByTenContaining(ten, pageable);
            model.addAttribute("ten", ten);
        } else {
            resultPage = customerService.findAll(pageable);

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
        model.addAttribute("number", resultPage.getNumber());
        model.addAttribute("customerPage", resultPage);
        List<KhachHang> list = resultPage.getContent();
        model.addAttribute("customers", list);
        // System.out.println(resultPage.hasContent());
        return "customers/searchpaginated";
    }
}
