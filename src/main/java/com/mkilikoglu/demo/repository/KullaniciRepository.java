package com.mkilikoglu.demo.repository;

import com.mkilikoglu.demo.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici,Long>{

}
