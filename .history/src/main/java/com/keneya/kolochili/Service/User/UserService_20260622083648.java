package aon.pheno.keneya.Service.User;

import org.springframework.stereotype.Service;

import aon.pheno.keneya.DTO.Request.LoginDTOResquest;
import aon.pheno.keneya.Entity.User.User;
import aon.pheno.keneya.IService.User.IServiceUser;
import aon.pheno.keneya.Repository.User.UserRepository;
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
