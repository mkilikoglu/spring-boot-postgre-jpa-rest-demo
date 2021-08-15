package com.mkilikoglu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="kullanici")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="adi")
    private String adi;
    @Column(name="soyadi")
    private String soyadi;
    @Column(name="tcNo")
    private String tcNo;
    @Column(name="kullaniciAdi")
    private String kullaniciAdi;
    @Column(name="email")
    private String email;

}
