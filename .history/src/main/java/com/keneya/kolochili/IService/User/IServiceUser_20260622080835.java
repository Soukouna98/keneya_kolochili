package aon.pheno.keneya.IService.User;

import aon.pheno.keneya.DTO.Request.LoginDTOResquest;
import aon.pheno.keneya.Entity.User.User;

public interface IServiceUser{
    User login(LoginDTOResquest loginDTOResquest);
    void logout();
    User findUserByEmail(String email);
}
