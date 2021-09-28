package com.evgeniy.web.jpa.hibernate.crud;

import com.evgeniy.web.jpa.hibernate.crud.entity.*;
import com.evgeniy.web.jpa.hibernate.crud.service.ObjectService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class App {
    public static void main(String[] args) {
        ObjectService objectService = new ObjectService();

//        objectService.deleteAll(City.class);
//        objectService.deleteAll(Role.class);
//        objectService.deleteAll(User.class);
//        objectService.deleteAll(UserAccount.class);
//        objectService.deleteAll(Country.class);

        Country country = new Country("Belarus");
        objectService.add(country);

        UserAccount userAccount = new UserAccount("Evgeniy","Leshevich",
                "EvgeniyLeshevich", "06919991","jeniya.leshevich@yandex.by");
        userAccount.setCountry(country);
        objectService.add(userAccount);

        User userOne = new User(userAccount.getLogin(), userAccount.getPassword());
        userOne.setUserAccount(userAccount);
        objectService.add(userOne);

        Role role = new Role("Student");
        objectService.add(role);

        userOne.getRole().add(role);
        role.getUsers().add(userOne);

        City city = new City("Minsk");
        city.setCountry(country);
        objectService.add(city);
    }
}
