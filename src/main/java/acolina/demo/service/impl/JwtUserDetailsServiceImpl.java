package acolina.demo.service.impl;

import acolina.demo.model.entity.User;
import acolina.demo.service.JwtUserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
    private static List<User> users;

    static {
        users = new ArrayList<>();
    }

    @Override
    public User loadUserByUsername(String name) {
        return users.stream()
                .filter(user -> user.getUsername().equals(name))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username " + name));
    }

    @Override
    public void addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        users.add(user);
    }
}
