package com.mkilikoglu.demo.controller;

import com.mkilikoglu.demo.dto.UserDTO;
import com.mkilikoglu.demo.dto.UserSaveDTO;
import com.mkilikoglu.demo.dto.UserUpdateDTO;
import com.mkilikoglu.demo.entity.User;
import com.mkilikoglu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/serviceTest")
    public String serviceTest(){
        return "OK";
    }

    @PostMapping("/saveUser")
    public  ResponseEntity<UserSaveDTO> saveUser(@RequestBody UserSaveDTO user){
        UserSaveDTO userSaveDTO = userService.saveUser(user);
        //return ResponseEntity.ok(userKaydetResult);
        return new ResponseEntity<UserSaveDTO>(userSaveDTO,HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> users = userService.getUsers();
       // return ResponseEntity.ok(users);
       return new ResponseEntity<List< UserDTO >>(users,HttpStatus.OK);

     }

    @GetMapping("/getUser")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){
        UserDTO user = userService.getUser(id);
       return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
    }
    @DeleteMapping("/deleteEmpById/{id}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable("id") Long id){
    userService.deleteUser(id);
    return  new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }
   @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody  UserUpdateDTO userUpdateDto){

        UserDTO user = userService.updateUser(id,userUpdateDto);
        return new ResponseEntity<UserDTO>(user,HttpStatus.OK);

    }


}
