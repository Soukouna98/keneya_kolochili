package com.keneya.kolochili.IService.User;

import com.keneya.kolochili.DTO.Request.LoginDTOResquest;
import com.keneya.kolochili.MODEL.Utilisateur;


public interface IServiceUser{
    Utilisateur login(LoginDTOResquest loginDTOResquest);
    void logout();
    Utilisateur findUserByEmail(String email);
}
