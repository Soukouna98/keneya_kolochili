package com.keneya.kolochili.Service.User;

import org.springframework.stereotype.Service;

import com.keneya.kolochili.DTO.Request.LoginDTOResquest;
import com.keneya.kolochili.IService.User.IServiceUser;
import com.keneya.kolochili.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IServiceUser {

    protected final UserRepository userRepository;
    
    public void supprimer(Long id) {

    }

    @Override
    public User login(LoginDTOResquest loginDTOResquest) {
        User user = userRepository.findByEmail(loginDTOResquest.email()).orElseThrow(()-> new EntityNotFoundException("Email introuvable"));
        if(!user.getPassword().equals(loginDTOResquest.password())){
            throw new EntityNotFoundException("Mot de passe incorrect pour l'email: "+loginDTOResquest.email());
        }
        return user;
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
