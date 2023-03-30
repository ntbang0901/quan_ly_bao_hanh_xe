package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.KhachHang;
import com.cnpm.baohanhxe.entity.LoaiXe;
import com.cnpm.baohanhxe.entity.Role;
import com.cnpm.baohanhxe.entity.Xe;
import com.cnpm.baohanhxe.model.LoaiXeDto;
import com.cnpm.baohanhxe.model.XeDto;
import com.cnpm.baohanhxe.service.CustomerService;
import com.cnpm.baohanhxe.service.LoaixeService;
import com.cnpm.baohanhxe.service.XeService;
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
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/manager/cars")
public class XeController {
    @Autowired
    private XeService xeService;

    @Autowired
    private LoaixeService loaixeService;

    @Autowired
    private CustomerService customerService;

    @ModelAttribute("loaixes")
    public List<LoaiXeDto> getLoaixe() {
        return loaixeService.findAll().stream().map(item -> {
            LoaiXeDto dto = new LoaiXeDto();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).toList();
    }


    @GetMapping("add")
    public String add(Model model) {
        XeDto dto = new XeDto();
        dto.setIsEdit(false);
        model.addAttribute("car", dto);
        return "cars/addOrEdit";
    }


    @GetMapping("edit/{maXe}")
    public ModelAndView edit(@PathVariable("maXe") Long maXe, ModelMap model) throws IOException {
        Optional<Xe> opt = xeService.findById(maXe);
        XeDto dto = new XeDto();

        if (opt.isPresent()) {
            Xe entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            dto.setMaLoaiXe(entity.getLoaixe().getMaLoaiXe());
            dto.setMaKhach(entity.getKhachHang().getMaKhach());
            dto.setIsEdit(true);
            model.addAttribute("car", dto);
            return new ModelAndView("cars/addOrEdit", model);
        }

        model.addAttribute("message", "Car not is existed");
        return new ModelAndView("redirect:/manager/cars", model);
    }


    @GetMapping("delete/{maXe}")
    public ModelAndView delete(ModelMap model, @PathVariable("maXe") Long maXe) throws IOException {
        Optional<Xe> opt = xeService.findById(maXe);
        if (opt.isPresent()) {
            xeService.delete(opt.get());
            model.addAttribute("message", "Car is deleted");

        } else {
            model.addAttribute("message", "Car is not found");
        }
        return new ModelAndView("forward:/manager/cars", model);
    }


    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @Valid @ModelAttribute("car") XeDto dto,
            BindingResult result) {

        if (result.hasErrors()) {
            return new ModelAndView("cars/addOrEdit");
        }
        Optional<KhachHang> opt = customerService.findById(dto.getMaKhach());
        if(!opt.isPresent()){

            model.addAttribute("message", "Khach hang khong ton tai!");
            return new ModelAndView("/cars/addOrEdit", model);
        }
        Xe entity = new Xe();
        BeanUtils.copyProperties(dto, entity);
        LoaiXe loaixe = new LoaiXe();
        loaixe.setMaLoaiXe(dto.getMaLoaiXe());
        entity.setLoaixe(loaixe);
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKhach(dto.getMaKhach());
        entity.setKhachHang(khachHang);
        System.out.println(entity);
        xeService.save(entity);

        model.addAttribute("message", "Car is saved!");
        return new ModelAndView("redirect:/manager/cars", model);
    }
    @GetMapping("")
    public String search(ModelMap model,
                         @RequestParam(name = "tenXe", required = false) String tenXe,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("tenXe"));
        Page<Xe> resultPage = null;

        // System.out.println(resultPage);
        //
        if (StringUtils.hasText(tenXe)) {
            resultPage = xeService.findByTenXeContaining(tenXe, pageable);
            model.addAttribute("tenXe", tenXe);
        } else {
            resultPage = xeService.findAll(pageable);

        }
        int totalPages = resultPage.getTotalPages();
        if (totalPages > 0) {
            int start = Math.max(1, currentPage);
            int end = Math.min(currentPage + 2, totalPages);

            if (totalPages > 5) {
                if (end == totalPages)
                    start = end - 5;
                else if (start == 1)
                    end = start + 5;
            }

            List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("carNumbers", pageNumbers);
            System.out.println("1" + pageNumbers);

        }
        System.out.println();
        model.addAttribute("carPage", resultPage);
        List<Xe> list = resultPage.getContent();

//        List<XeDto> listDto = new ArrayList<>();
//        BeanUtils.copyProperties(listDto, list);
        model.addAttribute("cars", list);
        // System.out.println(resultPage.hasContent());
        return "cars/searchpaginated";
    }


}
