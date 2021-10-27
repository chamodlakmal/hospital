package com.chamiviews.hostpital.service;

import com.chamiviews.hostpital.model.Hospital;
import com.chamiviews.hostpital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalImpl implements HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public void save(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public Hospital findById(Long id) {
        if (hospitalRepository.findById(id).isPresent()) {
            return hospitalRepository.findById(id).get();
        }
        return null;

    }

    @Override
    public void delete(Long id) {
        hospitalRepository.delete(findById(id));
    }

    @Override
    public List<Hospital> findByName(String name) {
       List<Hospital> hospitals= hospitalRepository.findByName("Asiri");
       return  hospitals;
    }

    @Override
    public List<Hospital> findByAddress(String address) {
        List<Hospital> hospitals=hospitalRepository.findByAddress(address);
        return hospitals;
    }
}
