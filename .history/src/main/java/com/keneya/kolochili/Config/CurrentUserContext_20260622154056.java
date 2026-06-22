package com.keneya.kolochili.Config;


public class CurrentUserContext {

    private final static ThreadLocal<User> CURRENT_USER = new ThreadLocal<>();

    private CurrentUserContext() {
    }

    public static void set(User user) {
        CURRENT_USER.set(user);
    }

    public static User get() {
        return CURRENT_USER.get();
    }

    public static void clear() {
        CURRENT_USER.remove();
    }
}
