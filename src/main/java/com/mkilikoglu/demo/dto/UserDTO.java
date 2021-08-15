package com.mkilikoglu.demo.dto;

import com.mkilikoglu.demo.entity.User;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Value
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String adi;
    private String soyadi;
    private String tcNo;
    private String kullaniciAdi;
    private String email;

    /*public static UserDTO of(User user) {
        return new UserDTO(user.getAdi(), user.getSoyadi(), user.getTcNo(), user.getKullaniciAdi(), user.getEmail());
    }*/
}
