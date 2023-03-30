package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.entity.*;
import com.cnpm.baohanhxe.model.PhieuBaoHanhDto;
import com.cnpm.baohanhxe.model.ReCaptchaResponse;
import com.cnpm.baohanhxe.model.XeDto;
import com.cnpm.baohanhxe.service.*;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;

import java.net.URL;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/WEB")
public class LayoutController {

    private  String message ;
    @Autowired
    private XeService xeService;

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${recaptcha.secret}")
    private String recaptchaSecret;

    @Value("${recaptcha.url}")
    private String recaptchaUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PhieuBHService phieuBHService;

    @Autowired
    private StaffService staffService;
    @GetMapping("")
    public String getLayout(ModelMap model){
        message = null;return "/layout/CNPM/content";
    }

    @GetMapping("checktrangthaibaohanh")
    public String checkTrangthaiBaohanh(ModelMap model) {
        message = null;return "/clients/checktrangthaibaohanh";
    }

    @GetMapping("checkthoihanbaohanh")
    public String checkThoiHanBaohanh(ModelMap model) {
        message = null;return "/clients/checkthoihanbaohanh";
    }

    @GetMapping("yeucaubaohanh")
    public String yeuCauBaoHanh(ModelMap model) {
        System.out.println(message);
        model.addAttribute("message",message);
        return "/clients/yeucaubaohanh";
    }

    @GetMapping("xacnhanyeucau")
    public String xacnhanyeucau(ModelMap model) {
        message = null;
        return "/clients/xacnhanyeucau";
    }


    @PostMapping("xacnhanyeucau")
    public String xacNhanYeuCau(ModelMap model,
                                HttpServletRequest request,
                                @RequestParam(name="g-recaptcha-response") String captchaResponse,
                                @RequestParam("email") String email ,
                                @RequestParam("msg") String msg) {

        try{
            String param = "?secret="+recaptchaSecret+"&response="+captchaResponse;
            System.out.println(recaptchaUrl+param);

            ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(recaptchaUrl+param, HttpMethod.POST,null,ReCaptchaResponse.class).getBody();


            System.out.println(reCaptchaResponse.isSuccess());
            if(reCaptchaResponse.isSuccess()){
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject("Yêu cầu bảo hành xe");
                message.setText( "Khách hàng yêu cầu:" +" \nYêu cầu đã được ghi nhận vui lòng chờ phản hồi mới nhất từ chúng tôi \nLỗi xe: "+msg +" \nForm Trung tâm bảo hành xe LTWEB");
                javaMailSender.send(message);
                return "redirect:xacnhanyeucau";
            }
            else{
                message = "Please verify captcha";
                return "redirect:yeucaubaohanh";
            }



        }catch(Exception e) {
            model.addAttribute("status","Gửi yêu cầu thất bại");
            return "/clients/yeucaubaohanh";
        }

    }

    @GetMapping("checkedtrangthai")
    public String checkedTrangThai(ModelMap model,
                                   @RequestParam(name = "maPBH", required = false) Long maPBH,
                                   @RequestParam(name = "sdt", required = false) String sdt)throws NoSuchElementException{
        Optional<PhieuBaoHanh> pbh  = phieuBHService.findById(maPBH);
        PhieuBaoHanhDto dto = new PhieuBaoHanhDto();
        if(!pbh.isPresent()) {
            model.addAttribute("message", "Mã phiếu không đúng");
        } else {
            Long ma_xe = pbh.get().getMaXeBH().getMaXe();
            Optional<Xe> xe = xeService.findById(ma_xe);
            if(xe.get().getKhachHang().getSdt().equals(sdt)) {
                dto.setMaPBH(pbh.get().getMaPBH());
                dto.setNgayLap(pbh.get().getNgayLap());
                dto.setTinhTrangxe(pbh.get().getTinhTrangxe());
                dto.setNoiDungBaoHanh(pbh.get().getNoiDungBaoHanh());
                dto.setMaXeBH(pbh.get().getMaPBH());
                dto.setStatus(pbh.get().getStatus());
                dto.setSoXe(xe.get().getSoXe());
                dto.setTenNV(pbh.get().getMaNVBH().getHo() + ' ' +  pbh.get().getMaNVBH().getTen());
                model.addAttribute("sdt", sdt);
                model.addAttribute("dto", dto);
                return "/clients/checkedtrangthai";
            }
            model.addAttribute("message", "Số điện thoại không đúng");
        }
        return "/clients/checktrangthaibaohanh";
    }

    @GetMapping("checkedthoihan")
    public String checkedThoiHan(ModelMap model,
                                 @RequestParam(name = "soXe", required = false) String soXe,
                                 @RequestParam(name = "sdt", required = false) String sdt)throws NoSuchElementException{
        List<Xe> listCar  = xeService.findAll();
        List<XeDto> listDto = new ArrayList<>();
        for (Xe car : listCar) {
            if(car.getSoXe().equalsIgnoreCase(soXe)) {
                if(car.getKhachHang().getSdt().equals(sdt)) {
                    XeDto dto = new XeDto();
                    dto.setMaXe(car.getMaXe());
                    dto.setNgayMua(car.getNgayMua());
                    dto.setSoXe(car.getSoXe());
                    dto.setTenXe(car.getTenXe());
                    dto.settGBH(car.gettGBH());
                    dto.setTrangThaiBH(car.getTrangThaiBH());
                    model.addAttribute("chuXe", car.getKhachHang().getHo() + ' ' + car.getKhachHang().getTen());
                    model.addAttribute("sdt", sdt);
                    listDto.add(dto);

                }
            }
        }

        model.addAttribute("carsDto", listDto);
        model.addAttribute("cars", listCar);
        return "/clients/checkedthoihan";


    }
}
