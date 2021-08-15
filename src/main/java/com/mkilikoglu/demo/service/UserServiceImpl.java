package com.mkilikoglu.demo.service;

import com.mkilikoglu.demo.dto.UserDTO;
import com.mkilikoglu.demo.dto.UserSaveDTO;
import com.mkilikoglu.demo.dto.UserUpdateDTO;
import com.mkilikoglu.demo.entity.User;
import com.mkilikoglu.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOList = users.stream().map(kul->modelMapper.map(kul, UserDTO.class)).collect(Collectors.toList());
        return userDTOList;
    }

    @Override
    @Transactional
    public UserSaveDTO saveUser(UserSaveDTO userSaveDTO) {
        User user = modelMapper.map(userSaveDTO, User.class);
        user.setKullaniciAdi(user.getKullaniciAdi());
        user.setAdi(userSaveDTO.getKullaniciAdi());
        user.setSoyadi(userSaveDTO.getSoyadi());
        user.setEmail(userSaveDTO.getEmail());
        return modelMapper.map(userRepo.save(user), UserSaveDTO.class);
    }

    @Override
    public UserDTO getUser(Long id) {
        User user = userRepo.findById(id).get();
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO updateUser(Long id,UserUpdateDTO userUpdateDTO) {
        User user =userRepo.findById(id).get();

        user.setAdi(userUpdateDTO.getAdi());
        user.setSoyadi(userUpdateDTO.getSoyadi());
        user.setEmail(userUpdateDTO.getEmail());
        user.setKullaniciAdi(userUpdateDTO.getKullaniciAdi());
        user.setTcNo(userUpdateDTO.getTcNo());

        User updatedUser = userRepo.save(user);

       return modelMapper.map(updatedUser,UserDTO.class);

    }


   /* @Override
    public KullaniciGuncelleDTO kullaniciGuncelle(KullaniciGuncelleDTO kullaniciGuncelleDTO) {
        return null;
    }*/
}
