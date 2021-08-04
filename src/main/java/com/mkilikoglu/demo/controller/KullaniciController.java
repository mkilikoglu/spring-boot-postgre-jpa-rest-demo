package com.mkilikoglu.demo.controller;

import com.mkilikoglu.demo.dto.KullaniciDTO;
import com.mkilikoglu.demo.dto.KullaniciKaydetDTO;
import com.mkilikoglu.demo.entity.Kullanici;
import com.mkilikoglu.demo.service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;

    @GetMapping("/servis-test")
    public String servisTest(){
        return "OK";
    }

    @PostMapping("/kullanici-kaydet")
    public  ResponseEntity<KullaniciKaydetDTO> kullaniciKaydet(@RequestBody KullaniciKaydetDTO kullanici){
        KullaniciKaydetDTO kullaniciKaydetResult =kullaniciService.kullaniciKaydet(kullanici);
        return ResponseEntity.ok(kullaniciKaydetResult);
    }

    @GetMapping("/get-kullanicilar")
    public ResponseEntity<List<KullaniciDTO>> getKullanicilar(){
        List<KullaniciDTO> kullanicilar = kullaniciService.getKullanicilar();
        return ResponseEntity.ok(kullanicilar);

    }

    @GetMapping("/get-kullanici")
    public ResponseEntity<List<KullaniciDTO>> getKullanici(){
        List<KullaniciDTO> kullanicilar = kullaniciService.getKullanicilar();
        return ResponseEntity.ok(kullanicilar);

    }
    @GetMapping("/servis-deneme")
    public String servisDeneme(String a){
        return "OK";
    }

}
