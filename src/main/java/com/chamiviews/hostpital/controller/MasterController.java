package com.chamiviews.hostpital.controller;

import com.chamiviews.hostpital.model.Hospital;
import com.chamiviews.hostpital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MasterController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping(value = "/")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("hospital");

//        List<Hospital> hospitals = hospitalService.findAll();
//
//        mav.addObject("hospitals", hospitals);
        //hospitalService.findByName("Asiri");
        Hospital hospital = new Hospital();
        mav.addObject("hospital", hospital);
        return mav;
    }

    @GetMapping(value = "/hospital")
    public ModelAndView addHospital() {
        ModelAndView mav = new ModelAndView("hospital");
        mav.addObject("hospital", new Hospital());
        return mav;
    }

    @PostMapping(value = "/hospital")
    public String save(@ModelAttribute("hospital") Hospital hospital) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        hospital.setName(encoder.encode(hospital.getName()));
//        hospitalService.save(hospital);

        List<Hospital> hospitals = hospitalService.findByAddress(hospital.getAddress());

        if(hospitals.size()>0){
            Hospital hospital1=hospitals.get(0);
            if(encoder.matches(hospital.getName(),hospital1.getName())){
                return "redirect:/";
            }
        }

        return "redirect:/";
    }

    @PutMapping(value = "/hospital/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("hospital");
        Hospital hospital = hospitalService.findById(id);
        mav.addObject("hospital", hospital);
        return mav;
    }

    @DeleteMapping(value = "/hospital/{id}/delete")
    public String delete(@PathVariable("id") Long id) {

        hospitalService.delete(id);
        return "redirect:/";
    }
}
