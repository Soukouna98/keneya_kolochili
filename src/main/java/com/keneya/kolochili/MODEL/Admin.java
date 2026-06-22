package com.keneya.kolochili.MODEL;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admins")
@Getter
@Setter
public class Admin extends Utilisateur {
    @OneToMany(mappedBy = "admin")
    private List<CategorieActivite> categorieActivites;
    @OneToMany(mappedBy = "admin")
    private List<CategorieConseil> categorieConseils;
}
