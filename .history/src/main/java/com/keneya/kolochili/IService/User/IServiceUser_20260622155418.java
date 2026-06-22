package com.keneya.kolochili.IService.User;

import com.keneya.kolochili.MODEL.Utilisateur;

import aon.pheno.keneya.DTO.Request.LoginDTOResquest;
import aon.pheno.keneya.Entity.User.User;

public interface IServiceUser{
    Utilisateur login(LoginDTOResquest loginDTOResquest);
    void logout();
    User findUserByEmail(String email);
}
