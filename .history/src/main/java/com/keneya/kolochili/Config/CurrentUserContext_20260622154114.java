package com.keneya.kolochili.Config;

import com.keneya.kolochili.MODEL.Utilisateur;


public class CurrentUserContext {

    private final static ThreadLocal<Utilisateur> CURRENT_USER = new ThreadLocal<>();

    private CurrentUserContext() {
    }

    public static void set(Utilisateur user) {
        CURRENT_USER.set(user);
    }

    public static Utilisateur get() {
        return CURRENT_USER.get();
    }

    public static void clear() {
        CURRENT_USER.remove();
    }
}
