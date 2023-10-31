package in.dev.gmsk.controller;

import in.dev.gmsk.model.User;
import org.junit.jupiter.api.Test;

class UserControllerTest {

    @Test
    void saveUserTest() {

        User user = new User();
        user.setId(1);
        user.setName("Gowtham Sankar Gunasekaran");
        user.setPassword("PWD@123");
        user.setEmail("gowthamsankar@gmsk.in");

        int saveUser = UserController.saveUser(user);

        System.out.println("saveUser = " + saveUser);
    }
}