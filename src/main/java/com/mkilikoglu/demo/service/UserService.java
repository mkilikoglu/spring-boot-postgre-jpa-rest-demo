package com.mkilikoglu.demo.service;

import com.mkilikoglu.demo.dto.UserDTO;
import com.mkilikoglu.demo.dto.UserSaveDTO;
import com.mkilikoglu.demo.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserSaveDTO saveUser(UserSaveDTO userSaveDTO);

    UserDTO getUser(Long id);

    void deleteUser(Long id);

    UserDTO updateUser(Long id,UserUpdateDTO userUpdateDTO);



}
