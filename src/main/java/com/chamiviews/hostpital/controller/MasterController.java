package com.chamiviews.hostpital.controller;

import com.chamiviews.hostpital.model.Hospital;
import com.chamiviews.hostpital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
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
        ModelAndView mav = new ModelAndView("home");

        List<Hospital> hospitals = hospitalService.findAll();

        mav.addObject("hospitals", hospitals);
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
        hospitalService.save(hospital);
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
