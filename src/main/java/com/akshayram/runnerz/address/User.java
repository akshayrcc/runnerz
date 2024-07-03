package com.akshayram.runnerz.address;

public record User(Integer id,
                   String name,
                   String username,
                   String email,
                   Address address,
                   String phone,
                   String website,
                   Company company) {
}
