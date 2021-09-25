package net.software.backendcursojava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import net.software.backendcursojava.models.request.UserDetailRequestModel;
import net.software.backendcursojava.models.responses.UserRest;
import net.software.backendcursojava.services.UserServiceInterface;
import net.software.backendcursojava.shared.dto.UserDTO;

@RestController
@RequestMapping("/users") //localhost/users
public class UserController{

    @Autowired
    UserServiceInterface userService;
    

    @GetMapping //Obtener, consultar informacion
    public String getUser(){
        return "Obtener usuarios";
    }

    @PostMapping //Creando informacion
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){
        UserRest UserToReturn= new UserRest();

        UserDTO userDTO =new UserDTO();

        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser= userService.createUser(userDTO);

        BeanUtils.copyProperties(createdUser, UserToReturn);

        return UserToReturn;
    }

}
