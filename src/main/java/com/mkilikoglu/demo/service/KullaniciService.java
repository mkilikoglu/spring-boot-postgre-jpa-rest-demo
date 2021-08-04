package com.mkilikoglu.demo.service;

import com.mkilikoglu.demo.dto.KullaniciDTO;
import com.mkilikoglu.demo.dto.KullaniciGuncelleDTO;
import com.mkilikoglu.demo.dto.KullaniciKaydetDTO;
import com.mkilikoglu.demo.entity.Kullanici;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface KullaniciService {

    List<KullaniciDTO> getKullanicilar();

    KullaniciKaydetDTO kullaniciKaydet(KullaniciKaydetDTO kullaniciKaydetDTO);

    /*KullaniciGuncelleDTO kullaniciGuncelle(KullaniciGuncelleDTO kullaniciGuncelleDTO);*/


}
