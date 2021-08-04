package com.mkilikoglu.demo.service;

import com.mkilikoglu.demo.dto.KullaniciDTO;
import com.mkilikoglu.demo.dto.KullaniciGuncelleDTO;
import com.mkilikoglu.demo.dto.KullaniciKaydetDTO;
import com.mkilikoglu.demo.entity.Kullanici;
import com.mkilikoglu.demo.repository.KullaniciRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KullaniciServiceImpl  implements KullaniciService{

    @Autowired
    private KullaniciRepository kullaniciRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<KullaniciDTO> getKullanicilar() {
        List<Kullanici> kullanicilar =kullaniciRepository.findAll();
        List<KullaniciDTO> kullaniciDTOList = kullanicilar.stream().map(kul->modelMapper.map(kul,KullaniciDTO.class)).collect(Collectors.toList());
        return kullaniciDTOList;
    }

    @Override
    @Transactional
    public KullaniciKaydetDTO kullaniciKaydet(KullaniciKaydetDTO kullaniciKaydetDTO) {
        Kullanici kullanici = modelMapper.map(kullaniciKaydetDTO,Kullanici.class);
        kullanici.setKullaniciAdi(kullanici.getKullaniciAdi());
        kullanici.setAdi(kullaniciKaydetDTO.getKullaniciAdi());
        kullanici.setSoyadi(kullaniciKaydetDTO.getSoyadi());
        kullanici.setEmail(kullaniciKaydetDTO.getEmail());
        return modelMapper.map(kullaniciRepository.save(kullanici),KullaniciKaydetDTO.class);
    }


   /* @Override
    public KullaniciGuncelleDTO kullaniciGuncelle(KullaniciGuncelleDTO kullaniciGuncelleDTO) {
        return null;
    }*/
}
