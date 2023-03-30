package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;
import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.PhuTung;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import com.cnpm.baohanhxe.model.LoaiPhuTungDto;
import com.cnpm.baohanhxe.model.NhanVienDto;
import com.cnpm.baohanhxe.model.PhuTungDto;
import com.cnpm.baohanhxe.service.AccountService;
import com.cnpm.baohanhxe.service.LoaiPhutungService;
import com.cnpm.baohanhxe.service.LoaixeService;
import com.cnpm.baohanhxe.service.PhuTungService;
import com.cnpm.baohanhxe.service.RoleService;
import com.cnpm.baohanhxe.service.StaffService;
import com.cnpm.baohanhxe.service.StorageService;

import groovyjarjarpicocli.CommandLine.Parameters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static javax.xml.bind.DatatypeConverter.parseString;

@Controller
@RequestMapping("manager/phutungs")
public class PhuTungController {
    @Autowired
    private PhuTungService phutungService;

    @Autowired
    private LoaiPhutungService loaiphutungService;

    @Autowired
    private StaffService staffService;

    @Autowired
    ServletContext application;

    @Autowired
    StorageService storageService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AccountService accountService;

    @ModelAttribute("loaiphutungs")
    public List<LoaiPhuTungDto> getLoaiPhutung() {
        return loaiphutungService.findAll().stream().map(item -> {
            LoaiPhuTungDto dto = new LoaiPhuTungDto();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).toList();
    }

    @ModelAttribute("nvdto")
    public NhanVienDto getMaNhanVien() {
        NhanVienDto nvdto = new NhanVienDto();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String login = authentication.getName();
        UserDetails user = userDetailsService.loadUserByUsername(login);
        TaiKhoan tk = accountService.getUserByUsername(user.getUsername());
        NhanVien nhanVien = staffService.findById(tk.getUser().getMaNV()).get();
        if (nhanVien != null) {
            BeanUtils.copyProperties(nhanVien, nvdto);
            nvdto.setEdit(false);
        }

        return nvdto;
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("phutung", new PhuTungDto());
        return "phutungs/addOrEdit";
    }

    @GetMapping("edit/{maPhutung}")
    public ModelAndView edit(@PathVariable("maPhutung") Long maPhutung, ModelMap model) throws IOException {
        Optional<PhuTung> opt = phutungService.findById(maPhutung);
        PhuTungDto dto = new PhuTungDto();

        if (opt.isPresent()) {
            PhuTung entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            dto.setMaLoaiPhutung(entity.getLoaiPhutung().getMaLoaiPhutung());
            
            dto.setEdit(true);
            model.addAttribute("phutung", dto);
            return new ModelAndView("/phutungs/addOrEdit", model);

        }
        model.addAttribute("message", "Phụ tùng không tồn tại");
        return new ModelAndView("redirect:/manager/phutungs", model);
    }

    @GetMapping("/images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("delete/{maPhutung}")
    public ModelAndView delete(ModelMap model, @PathVariable("maPhutung") Long maPhutung) throws IOException {
        Optional<PhuTung> opt = phutungService.findById(maPhutung);
        if (opt.isPresent()) {
            phutungService.delete(opt.get());
            model.addAttribute("message", "Phụ tùng đã bị xóa");

        } else {
            model.addAttribute("message", "Không tìm thấy phụ tùng");
        }
        return new ModelAndView("forward:/manager/phutungs", model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @Valid @ModelAttribute("phutung") PhuTungDto dto,
            BindingResult resultE
            ) {

        System.out.println(dto.getGia() + dto.getImage() + dto.getTenPhutung());
        
        

        PhuTung entity = new PhuTung();
        BeanUtils.copyProperties(dto, entity);
        LoaiPhuTung loaiphutung = new LoaiPhuTung();
        loaiphutung.setMaLoaiPhutung(dto.getMaLoaiPhutung());
        
        entity.setLoaiPhutung(loaiphutung);

        System.out.println(entity);

        if (!dto.getImageFile().isEmpty()) {
            UUID uuid = UUID.randomUUID();
            String uuString = uuid.toString();

            entity.setImage(storageService.getStoredFilename(dto.getImageFile(), uuString));
            storageService.store(dto.getImageFile(), entity.getImage());
        }

        phutungService.save(entity);

        model.addAttribute("message", "Phụ tùng đã được lưu!");
        return new ModelAndView("redirect:/manager/phutungs", model);
    }

    @GetMapping("")
    public String search(ModelMap model,
            @RequestParam(name = "tenPhutung", required = false) String tenPhutung,
            @RequestParam(name = "maLoaiPhutung", required = false, defaultValue = "all") String maLoaiPhutung,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(12);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("tenPhutung"));
        Page<PhuTung> resultPage = null;
        PhuTung pt = new PhuTung();
        LoaiPhuTung lpt = new LoaiPhuTung();
        if (StringUtils.hasText(tenPhutung)) {
            if (Objects.equals(maLoaiPhutung, "all")) {
                resultPage = phutungService.findByTenPhutungContaining(tenPhutung, pageable);
            } else {

                lpt.setMaLoaiPhutung(Long.parseLong(maLoaiPhutung));
                pt.setLoaiPhutung(lpt);
                resultPage = phutungService.findByTenPhutungContainingOrMaLoaiPhutung(tenPhutung, pt.getLoaiPhutung(),
                        pageable);
            }

            model.addAttribute("tenPhutung", tenPhutung);
            model.addAttribute("maLoaiPhutung", maLoaiPhutung);
        } else {
            if (Objects.equals(maLoaiPhutung, "all")) {
                resultPage = phutungService.findAll(pageable);
            } else {
                lpt.setMaLoaiPhutung(Long.parseLong(maLoaiPhutung));
                pt.setLoaiPhutung(lpt);

                pt.getLoaiPhutung().setMaLoaiPhutung(Long.parseLong(maLoaiPhutung));
                resultPage = phutungService.findByMaLoaiPhutung(pt.getLoaiPhutung(), pageable);
            }
        }
        int totalPages = resultPage.getTotalPages();
        if (totalPages > 0) {
            int start = 1;
            int end = totalPages;

            if (totalPages > 12) {
                if (end == totalPages)
                    start = end - 12;
                else if (start == 1)
                    end = start + 12;
            }
            System.out.println("Start: " + start);
            System.out.println("End: " + end);

            List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            System.out.println("1" + pageNumbers);

        }
        System.out.println();
        model.addAttribute("number", resultPage.getNumber());
        System.out.println(resultPage.getNumber() + 1);
        model.addAttribute("phutungPage", resultPage);
        List<PhuTung> list = resultPage.getContent();
        model.addAttribute("phutungs", list);

        // System.out.println(resultPage.hasContent());
        return "phutungs/searchpaginated";
    }
}
