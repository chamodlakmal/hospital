package com.chamiviews.hostpital.repository;

import com.chamiviews.hostpital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    public List<Hospital> findByName(String name);

    public List<Hospital> findByAddress(String address);
}
