package acolina.demo;

import acolina.demo.model.entity.User;
import acolina.demo.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    @Autowired
    public void loadUsers(JwtUserDetailsService userService) {
        userService.addUser(User.builder().name("angel").password("123").build());
        userService.addUser(User.builder().name("vito").password("1234").build());
        userService.addUser(User.builder().name("manuel").password("12345").build());
        userService.addUser(User.builder().name("angel2").password("123456").build());
        userService.addUser(User.builder().name("ana").password("1234567").build());
        userService.addUser(User.builder().name("daniel").password("12345678").build());
        userService.addUser(User.builder().name("mari").password("123456789").build());
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
