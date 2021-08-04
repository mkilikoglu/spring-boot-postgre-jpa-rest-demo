package com.mkilikoglu.demo.dto;

import com.mkilikoglu.demo.entity.Kullanici;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Value
public class KullaniciDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String adi;
    private String soyadi;
    private String tcNo;
    private String kullaniciAdi;
    private String email;

    public static KullaniciDTO of(Kullanici kullanici) {
        return new KullaniciDTO(kullanici.getAdi(), kullanici.getSoyadi(), kullanici.getTcNo(), kullanici.getKullaniciAdi(),kullanici.getEmail());
    }
}
