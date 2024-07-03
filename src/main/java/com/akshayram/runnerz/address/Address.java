package com.akshayram.runnerz.address;

public record Address(String street,
                      String suite,
                      String city,
                      String zipcode,
                      Geo geo) {
}
