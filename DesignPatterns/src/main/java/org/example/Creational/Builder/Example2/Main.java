package org.example.Creational.Builder.Example2;

public class Main {

    public static void main(String[] args) {
        ComplexUser complexUser = new ComplexUser.UserBuilder()
                .setComplexProfile(new ComplexProfile.ProfileBuilder()
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setEmail("Bt7bG@example.com")
                        .setPhoneNumber("123-456-7890")
                        .build())
                .setComplexAddress(new ComplexAddress.AddressBuilder()
                        .setHouseNumber("123")
                        .setStreet("Main Street")
                        .setCity("New York")
                        .setState("NY")
                        .setZipCode("10001")
                        .build())
                .build();

        System.out.println(complexUser);

        System.out.println("------");

    }
}
