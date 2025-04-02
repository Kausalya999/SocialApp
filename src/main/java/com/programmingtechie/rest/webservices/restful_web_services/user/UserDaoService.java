package com.programmingtechie.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //with static list below

    private static List<User> users=new ArrayList<>();
    private static int userCount=0;
    static{
        users.add(new User(++userCount,1,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,2,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,3,"Jim", LocalDate.now().minusYears(20)));

    }
    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
       Predicate<? super User> p= user->user.getId().equals(id);
       return users.stream().filter(p).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
    public void deleteById(int id){
        Predicate<? super User> p= user->user.getId().equals(id);
        users.removeIf(p);
    }
}
