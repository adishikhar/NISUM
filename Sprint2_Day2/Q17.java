package Sprint2_Day2;

import java.util.*;

class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

public class Q17 {
    public static void main(String[] args) {
        List<Address> addresses = Arrays.asList(
            new Address("Paris", "France"),
            new Address("Berlin", "Germany"),
            new Address("Ranchi", "India"),
            new Address("Berlin", "USA"),
            new Address("Bhubaneswar", "India")
        );

        addresses.sort(
            Comparator.comparing(Address::getCity)
                      .thenComparing(Address::getCountry)
        );

        addresses.forEach(System.out::println);
    }
}

