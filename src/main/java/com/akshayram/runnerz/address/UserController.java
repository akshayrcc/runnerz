package com.akshayram.runnerz.address;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserHttpClient client;

    UserController(UserHttpClient client) {
        this.client = client;
    }

    @GetMapping("")
    List<User> findAll() {
        return client.findAll();
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Integer id) {
        return client.findById(id);
    }

}
