package com.nicholas.officemanager.services;

public class UsersNotFoundException extends Exception {
    public UsersNotFoundException(String message) {
        super(message);
    }
}
