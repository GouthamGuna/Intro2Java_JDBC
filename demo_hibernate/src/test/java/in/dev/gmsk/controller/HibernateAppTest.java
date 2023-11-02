package in.dev.gmsk.controller;

import in.dev.gmsk.model.Address;
import in.dev.gmsk.model.User;
import org.junit.jupiter.api.Test;

class HibernateAppTest {

    @Test
    void mainMethodTest() {

        User user = new User(2427, "Gowtham Sankar",
                "dummy@PWD", "dummy@gmsk.in");

        Address address = new Address("Electronic City", "2427",
                "Bangalore", "Karnataka", "India", "12345");

        int i = HibernateApp.mainMethod(user, address);

        System.out.println("i = " + i);
    }
}