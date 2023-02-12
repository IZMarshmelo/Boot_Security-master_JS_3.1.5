package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Set;

@Component
public class Util {

    private final RoleRepository roleRepository;
    private final UserService userService;

    public Util(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @PostConstruct
    public void initialization() {
    Role roleUser = new Role("ROLE_USER");
    Role roleAdmin = new Role("ROLE_ADMIN");
			roleRepository.save(roleAdmin);
			roleRepository.save(roleUser);
			Arrays.asList(new User("admin", "admin", (byte) 22, "admin@bk.ru", "1111", Set.of(roleAdmin, roleUser)),
            new User( "user", "user", (byte) 20, "user@bk.ru", "2222", Set.of(roleUser)))
            .forEach(userService::addUser);
};
}
