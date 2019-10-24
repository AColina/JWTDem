package acolina.demo.service;

import acolina.demo.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface JwtUserDetailsService extends UserDetailsService {

    void addUser(User user);
}
