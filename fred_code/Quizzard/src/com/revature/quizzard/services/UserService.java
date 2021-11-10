package com.revature.quizzard.services;

import com.revature.quizzard.exceptions.InvalidRequestException;
import com.revature.quizzard.models.AppUser;

import java.io.File;
import java.io.FileWriter;

public class UserService {

    public <AppUser> boolean registerNewUser(AppUser newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        // TODO: write logic that verifies that the new user's username and email are not already taken

        // TODO: Find a better place for this logic (hint: DAO pattern)
        try {
            File usersFile = new File("resources/data.txt");
            FileWriter fileWriter = new FileWriter(usersFile, true);
            fileWriter.write(newUser.toString() + "\n");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    private <AppUser> boolean isUserValid(AppUser newUser) {
        return true;
    }

    public AppUser authenticateUser(String username, String password) {
        return null;
    }

    public boolean isUserValid(AppUser user) {
        System.out.println(user);
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return user.getPassword() != null && !user.getPassword().trim().equals("");
    }

}
