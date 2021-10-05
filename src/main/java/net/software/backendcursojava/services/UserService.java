package net.software.backendcursojava.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import net.software.backendcursojava.UserRepository;
import net.software.backendcursojava.entities.UserEntity;
import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements  UserServiceInterface{

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        
        if(userRepository.findUserByEmail(userDTO.getEmail()) != null) throw new RuntimeException("Su correo ya existe.");


        UserEntity userEntity =new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);

        userEntity.setEncryptedPassword("testpassword");
        UUID userId= UUID.randomUUID();
        userEntity.setUserId(userId.toString());
        


        UserEntity storedUserDetail= userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDetail, userToReturn);


        return userToReturn;
    }

    
}
