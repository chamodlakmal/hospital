package com.chamiviews.hostpital;

import com.chamiviews.hostpital.model.Hospital;
import com.chamiviews.hostpital.service.HospitalImpl;
import com.chamiviews.hostpital.service.HospitalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HostpitalApplicationTests {

    @Autowired
    HospitalImpl hospitalIm;

    @Test
    void contextLoads() {
        List<Hospital> hospitals =hospitalIm.findByAddress("jfjjgj");
        System.out.println(hospitals);
    }


}
