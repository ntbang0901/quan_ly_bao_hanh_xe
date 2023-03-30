package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.*;
import com.cnpm.baohanhxe.model.*;
import com.cnpm.baohanhxe.model.PhieuBaoHanhDto;
import com.cnpm.baohanhxe.service.*;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("manager/phieubhs")
public class PhieuBHController {
    private static final long soluong = 1L;
    private String message1;
    @Autowired
    private XeService xeService;

    @Autowired
    private PhieuBHService phieuBHService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private CT_PBHService ct_pbhServicel;

    @Autowired
    private PhuTungService phuTungService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    AccountService accountService;

    @Autowired
    UserDetailsService userDetailsService;

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

        }

        return nvdto;
    }

    @ModelAttribute("phutungs")
    public List<PhuTungDto> getPhutung() {
        return phuTungService.findAll().stream().map(item -> {
            PhuTungDto dto = new PhuTungDto();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).toList();
    }

    @GetMapping("add")
    public String add(Model model) {
        PhieuBaoHanhDto dto = new PhieuBaoHanhDto();
        dto.setIsEdit(false);
        model.addAttribute("phieubh", dto);
        return "phieubaohanhs/addOrEdit";
    }

    @GetMapping("edit/{maXe}")
    public ModelAndView edit(@PathVariable("maXe") Long maXe, ModelMap model) throws IOException {
        Optional<PhieuBaoHanh> opt = phieuBHService.findById(maXe);
        List<CT_PhieuBH> ct_PhieuBHs = ct_pbhServicel.findByPhieuBaoHanh_MaPBH(maXe);
        List<Long> phuTung = new ArrayList<>();
        PhieuBaoHanhDto dto = new PhieuBaoHanhDto();
        
        if (opt.isPresent()) {
            PhieuBaoHanh entity = opt.get();
            
            for(CT_PhieuBH cBh : ct_PhieuBHs){
                phuTung.add(cBh.getPhuTung().getMaPhutung());
            }
            BeanUtils.copyProperties(entity, dto);
            dto.setMaNVBH(entity.getMaNVBH().getMaNV());
            dto.setMaXeBH(entity.getMaXeBH().getMaXe());
            dto.setNgayNhan(opt.get().getNgayNhan());
            dto.setIsEdit(true);
            model.addAttribute("phuTung", phuTung);
            model.addAttribute("phieubh", dto);
            return new ModelAndView("phieubaohanhs/addOrEdit", model);
        }

        model.addAttribute("ct_PhieuBHs", ct_PhieuBHs);
       
        model.addAttribute("message", "phieubh not is existed");
        return new ModelAndView("redirect:/manager/phieubhs", model);
    }

    @GetMapping("delete/{maPBH}")
    public ModelAndView delete(ModelMap model, @PathVariable("maPBH") Long maPBH) throws IOException {
        Optional<PhieuBaoHanh> opt = phieuBHService.findById(maPBH);
        List<CT_PhieuBH> ct_phieubhs = ct_pbhServicel.findByPhieuBaoHanh_MaPBH(maPBH);
        if (opt.isPresent()) {
            if(ct_phieubhs == null){
                phieuBHService.delete(opt.get());
                model.addAttribute("message", "phieubh is deleted");
            } else{
                model.addAttribute("message", "Phiếu đang xử lý. Không được xóa!");
            }
            

        } else {
            model.addAttribute("message", "phieubh is not found");
        }
        return new ModelAndView("forward:/manager/phieubhs", model);
    }


    public static Boolean printUnion(int[] A, int[] B, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j])
                    return true;
            }
        }

        return false;

    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(
            @RequestParam(name = "listPT", required = false) List<String> listPT,
            @RequestParam("manv") Long maNVBH,
            ModelMap model,
            @Valid @ModelAttribute("phieubh") PhieuBaoHanhDto dto,
            BindingResult result) {


        if (result.hasErrors() ) {
            return new ModelAndView("phieubaohanhs/addOrEdit");
        }

        if(dto.getNgayNhan().before(dto.getNgayLap()) ){
            model.addAttribute("message1", "Ngày nhận phải sau ngày lập");
            return new ModelAndView("phieubaohanhs/addOrEdit");
        }

        Optional<Xe> optxe = xeService.findById(dto.getMaXeBH());
        System.out.println("result.hasErrors()" + result.hasErrors());
        if (!optxe.isPresent()) {
            model.addAttribute("message1", "Mã xe không tồn tại");
            return new ModelAndView("phieubaohanhs/addOrEdit", model);
        }
        if(listPT != null ){
            if(listPT.size() == 0){
                model.addAttribute("message1", "Vui lòng nhập phụ tùng");
                return new ModelAndView("phieubaohanhs/addOrEdit", model);
            }
        }else{
            model.addAttribute("message1", "Vui lòng nhập phụ tùng");
            return new ModelAndView("phieubaohanhs/addOrEdit", model);
        }
        List<PhieuBaoHanh> opt = phieuBHService.findByMaXeBH_MaXe(dto.getMaXeBH());
        if (opt.size() > 0) {
            for (PhieuBaoHanh item : opt) {
                if (item.getStatus() != 2 && !dto.getisEdit()) {
                    model.addAttribute("message1", "Xe đang sữa chữa không thể lập phiếu");
                    return new ModelAndView("phieubaohanhs/addOrEdit", model);
                }
            }
        }


        PhieuBaoHanh entity = new PhieuBaoHanh();
        BeanUtils.copyProperties(dto, entity);
        Xe xe = new Xe();
        xe.setMaXe(dto.getMaXeBH());
        // xe = xeService.findById(dto.getMaXeBH()).get();

        NhanVien nhanVien = staffService.findById(maNVBH).get();
        // nhanVien.setMaNV(dto.getMaNVBH());
        entity.setMaXeBH(xe);
        entity.setNgayLap(dto.getNgayLap());
        entity.setMaNVBH(nhanVien);
        entity.setStatus(dto.getStatus());
        phieuBHService.save(entity);

        if(dto.getEdit() == Boolean.TRUE){
            List<CT_PhieuBH> ct_PhieuBHs = ct_pbhServicel.findByPhieuBaoHanh_MaPBH(dto.getMaPBH());
            List<String> maPhieuDB = new ArrayList<>() ;

            List<String> temp1 =  new ArrayList<>() ;;
            for(CT_PhieuBH ct: ct_PhieuBHs){
                maPhieuDB.add(ct.getPhuTung().getMaPhutung().toString());
            }

            for(CT_PhieuBH ct: ct_PhieuBHs){

                String mp = ct.getPhuTung().getMaPhutung().toString();
                    if(!listPT.contains(mp) ){
                        ct_pbhServicel.delete(ct);
                        PhuTung temp = phuTungService.findById(ct.getPhuTung().getMaPhutung()).get();
                        temp.setSoLoung((int) (temp.getSoLoung() + ct.getSoluong()));
                        phuTungService.save(temp);
                    }

            }
            for (String i : listPT) {
                if(!maPhieuDB.contains(i)){
                    PhuTung pt = phuTungService.findById(Long.parseLong(i)).get();
                    CT_PhieuBH ct_phieuBH = new CT_PhieuBH();
                    ct_phieuBH.setPhieuBaoHanh(entity);
                    ct_phieuBH.setSoluong(1L);

                    ct_phieuBH.setPhuTung(pt);
                    ct_pbhServicel.save(ct_phieuBH);
                    pt.setSoLoung(pt.getSoLoung()-1);
                    phuTungService.save(pt);

                }
            }

        }else{
            for (String i : listPT) {

                    PhuTung pt = phuTungService.findById(Long.parseLong(i)).get();
                    CT_PhieuBH ct_phieuBH = new CT_PhieuBH();
                    ct_phieuBH.setPhieuBaoHanh(entity);
                    ct_phieuBH.setSoluong(1L);

                    ct_phieuBH.setPhuTung(pt);
                    ct_pbhServicel.save(ct_phieuBH);
                    pt.setSoLoung(pt.getSoLoung()-1);
                    phuTungService.save(pt);


            }
        }

        model.addAttribute("message", "phieubh is saved!");
        return new ModelAndView("redirect:/manager/phieubhs", model);
    }

    @GetMapping("")
    public String search(ModelMap model,
            @RequestParam(name = "tenNV", required = false) String tenNV,
            @RequestParam(name = "status", required = false, defaultValue = "all") String status,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("maPBH"));
        Page<PhieuBaoHanh> resultPage = null;

        // System.out.println(resultPage);
        //
        if (StringUtils.hasText(tenNV)) {
            if (Objects.equals(status, "all")) {
                resultPage = phieuBHService.findByMaNVBH_TenContaining(tenNV, pageable);
            } else {
                resultPage = phieuBHService.findByMaNVBH_TenContainingOrStatus(tenNV, Short.parseShort(status),
                        pageable);
            }
            model.addAttribute("tenNV", tenNV);
        } else {
            if (Objects.equals(status, "all")) {
                resultPage = phieuBHService.findAll(pageable);
            } else {
                resultPage = phieuBHService.findByStatus(Short.parseShort(status), pageable);
            }

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
            model.addAttribute("phieubhNumbers", pageNumbers);
            System.out.println("1" + pageNumbers);

        }
        System.out.println();
        model.addAttribute("phieubhPage", resultPage);
        List<PhieuBaoHanh> list = resultPage.getContent();

        List<PhieuBaoHanhDto> listDto = new ArrayList<>();
        for (PhieuBaoHanh pbh : list) {
            PhieuBaoHanhDto dto = new PhieuBaoHanhDto();
            dto.setMaPBH(pbh.getMaPBH());
            dto.setNgayLap(pbh.getNgayLap());
            dto.setTinhTrangxe(pbh.getTinhTrangxe());
            dto.setNoiDungBaoHanh(pbh.getNoiDungBaoHanh());
            dto.setMaXeBH(pbh.getMaPBH());
            dto.setStatus(pbh.getStatus());
            dto.setSoXe(xeService.findById(pbh.getMaXeBH().getMaXe()).get().getSoXe());
            dto.setTenNV(pbh.getMaNVBH().getHo() + ' ' + pbh.getMaNVBH().getTen());
            listDto.add(dto);
        }
        System.out.println(listDto);
        model.addAttribute("phieubhsdto", listDto);
        model.addAttribute("phieubhs", list);
        // System.out.println(resultPage.hasContent());
        return "phieubaohanhs/searchpaginated";
    }

    @GetMapping("detail/{maPBH}")
    public String phieubhDetail(ModelMap model,@PathVariable("maPBH") Long maPBH) throws IOException {
        System.out.println(maPBH);
        
        
        List<CT_PhieuBH> ct_phieubhs = ct_pbhServicel.findByPhieuBaoHanh_MaPBH(maPBH);
        
        PhieuBaoHanh pbh = phieuBHService.findById(maPBH).get();
        
        Xe xe = xeService.findById(pbh.getMaXeBH().getMaXe()).get();
        KhachHang kh = customerService.findById(xe.getKhachHang().getMaKhach()).get();
        List<CT_PhieubhDto> ct_phieubhsdto = new ArrayList<>();
        
        Integer tongTien = 0;
        int stt = 0;
        for (CT_PhieuBH ct_phieubh : ct_phieubhs) {
            Integer thanhTien = 0;
            CT_PhieubhDto dto = new CT_PhieubhDto();
            PhuTung phutung = phuTungService.findById(ct_phieubh.getPhuTung().getMaPhutung()).get();
            dto.setMaPBH(ct_phieubh.getPhieuBaoHanh().getMaPBH());
            dto.setGia(phutung.getGia());
            dto.setTenPhutung(phutung.getTenPhutung());
            dto.setSoLuong(ct_phieubh.getSoluong());

            thanhTien = (int) (dto.getSoLuong() * Integer.parseInt(phutung.getGia().toString()));
            tongTien += thanhTien;
            dto.setThanhTien(thanhTien);
            ct_phieubhsdto.add(dto);
            
        }
        model.addAttribute("tongTien", tongTien);
        model.addAttribute("pbh", pbh);
        model.addAttribute("kh", kh);
        model.addAttribute("stt", stt);
        model.addAttribute("xe", xe);
        model.addAttribute("ct_phieubhsdto", ct_phieubhsdto);
        return "phieubaohanhs/phieubhDetail";
    }
}
