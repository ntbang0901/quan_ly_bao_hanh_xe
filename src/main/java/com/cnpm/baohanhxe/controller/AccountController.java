package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.KhachHang;
import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.Role;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import com.cnpm.baohanhxe.model.RoleDto;
import com.cnpm.baohanhxe.model.RoleName;
import com.cnpm.baohanhxe.model.TaiKhoanDto;
import com.cnpm.baohanhxe.service.AccountService;
import com.cnpm.baohanhxe.service.RoleService;
import com.cnpm.baohanhxe.service.StaffService;
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
import org.thymeleaf.expression.Sets;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static javax.xml.bind.DatatypeConverter.parseString;

@Controller
@RequestMapping("admin/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    StaffService staffService;

    @ModelAttribute("roles")
    public List<RoleDto> getCRoles() {
        return roleService.findAll().stream().map(item -> {
            RoleDto dto = new RoleDto();
           dto.setRoleId(item.getRoleId());
           dto.setTenRole(item.getTenRole());
            System.out.println(dto);
            return dto;

        }).toList();
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("account", new TaiKhoanDto());
        return "accounts/addOrEdit";
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id,
            ModelMap model) {
        Optional<TaiKhoan> opt = accountService.findById(id);
        System.out.println(opt);
        TaiKhoanDto dto = new TaiKhoanDto();
        if (opt.isPresent()) {
            TaiKhoan entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            Set<Role> roles = opt.get().getRoles();
            for (Role role : roles) {
                dto.setRoleId(role.getRoleId());
            }
            dto.setMaNV(entity.getUser().getMaNV());
            dto.setIsEdit(true) ;
            dto.setPassword("");
            System.out.println(dto);
            model.addAttribute("account", dto);
            return new ModelAndView("accounts/addOrEdit", model);
        }
        model.addAttribute("message", "account not is existed");
        return new ModelAndView("redirect:/admin/accounts", model);
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
        accountService.deleteById(id);
        model.addAttribute("message", "account is deleted");
        return new ModelAndView("forward:/admin/accounts", model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @ModelAttribute("account") @Valid TaiKhoanDto dto,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/accounts/addOrEdit");
        }
        Optional<TaiKhoan> tk = accountService.findByUsername(dto.getUsername());
        if(!dto.getIsEdit() && tk.isPresent() && dto.getEnabled()){
            model.addAttribute("message1", "Tài khoản đã tồn tại");
            return new ModelAndView("/accounts/addOrEdit", model);
        }
        Optional<NhanVien> opt = staffService.findById(dto.getMaNV());
        if(!opt.isPresent()){
            model.addAttribute("message1", "Nhân viên không tồn tại!");
            return new ModelAndView("/accounts/addOrEdit", model);
        }
        Optional<TaiKhoan> opttk = accountService.findByUser_MaNV(dto.getMaNV());
        if(opttk.isPresent() && opttk.get().isEnabled() && !dto.getIsEdit()){
            model.addAttribute("message1", "Nhân viên đã được cấp tài khoản");
            return new ModelAndView("/accounts/addOrEdit", model);
        }

        System.out.println(dto);
        NhanVien nv = new NhanVien();
        TaiKhoan entity = new TaiKhoan();
        nv.setMaNV(dto.getMaNV());
        BeanUtils.copyProperties(dto, entity);
        entity.setUser(nv);
        Role role = roleService.findById(dto.getRoleId()).get();
        List<Role> roles = Collections.singletonList(role);
        entity.setRoles(Set.copyOf(roles));

        accountService.save(entity);
        model.addAttribute("message", "account is saved!");
        return new ModelAndView("redirect:/admin/accounts", model);
    }



    // @RequestParam(name = "name", required = false) String name,
    // @RequestParam("page") Optional<Integer> page,
    // @RequestParam("size") Optional<Integer> size
    @GetMapping("")
    public String search(ModelMap model,
            @RequestParam(name = "username", required = false) String username,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("username"));
        Page<TaiKhoan> resultPage = null;

        // System.out.println(resultPage);
        //
        if (StringUtils.hasText(username)) {
            resultPage = accountService.findByUsernameContaining(username, pageable);
            model.addAttribute("username", username);
        } else {
            resultPage = accountService.findAll(pageable);

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
        model.addAttribute("accountPage", resultPage);
        List<TaiKhoan> list = resultPage.getContent();
        List<TaiKhoanDto> listdto = new ArrayList<>();
        for(TaiKhoan account : list){
            TaiKhoanDto dto = new TaiKhoanDto();
            BeanUtils.copyProperties(account,dto);
            dto.setMaNV(account.getUser().getMaNV());
            dto.setTenNv(account.getUser().getHo() + ' ' +account.getUser().getTen());
            List<Role> stringsList = new ArrayList<>(account.getRoles());
            dto.setTenRole(stringsList.get(0).getTenRole());
            dto.setRoleId(stringsList.get(0).getRoleId());
            listdto.add(dto);
        }
        System.out.println(listdto);
        model.addAttribute("accountsdto", listdto);
        model.addAttribute("accounts", list);
        // System.out.println(resultPage.hasContent());
        return "accounts/searchpaginated";
    }

}
