package org.example.Creational.Builder.Example1;

public class Main {
    public static void main(String[] args) {


        // ------- Simple Builder --------
        User user = new User.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("Bt7bG@example.com")
                .setPhoneNumber("123-456-7890")
                .setAddress("123 Main St")
                .setAge(30)
                .setGender("Male")
                .setCountry("USA")
                .setCity("New York")
                .setState("NY")
                .setZipCode("12345")
                .setUsername("johndoe")
                .setPassword("password123")
                .setIsVerified(true)
                .setIsPremiumUser(true)
                .setProfilePictureUrl("https://example.com/profile.jpg")
                .setBio("I'm a software developer")
                .setWebsite("https://example.com")
                .setLinkedIn("https://linkedin.com/johndoe")
                .setGithub("https://github.com/johndoe")
                .build();


    }
}
