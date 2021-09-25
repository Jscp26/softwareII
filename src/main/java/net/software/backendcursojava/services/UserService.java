package net.software.backendcursojava.services;

import org.springframework.stereotype.Service;
import net.software.backendcursojava.shared.dto.UserDTO;

@Service
public class UserService implements  UserServiceInterface{

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //TODO lógica de la creación de usuario.
        return null;
    }

    
}
