package com.chamiviews.hostpital.service;

import com.chamiviews.hostpital.model.Hospital;

import java.util.List;

public interface HospitalService {

    List<Hospital> findAll();

    void save(Hospital hospital);

    Hospital findById(Long id);

    void delete(Long id);

    List<Hospital> findByName(String name);

    List<Hospital> findByAddress(String address);

}
