package com.keneya.kolochili.IService;

import java.util.List;

public interface IService<REQUEST,ID,RESPONSE> {
    void creer(REQUEST entity);
    void modifier(REQUEST entity,ID id);
    void supprimer(ID id);
    RESPONSE findById(ID id);
    List<RESPONSE> getAll();
}
