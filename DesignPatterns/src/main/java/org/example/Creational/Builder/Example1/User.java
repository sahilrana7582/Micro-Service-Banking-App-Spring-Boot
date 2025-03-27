package org.example.Creational.Builder.Example1;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final int age;
    private final String gender;
    private final String country;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String username;
    private final String password;
    private final boolean isVerified;
    private final boolean isPremiumUser;
    private final String profilePictureUrl;
    private final String bio;
    private final String website;
    private final String linkedIn;
    private final String github;

    private User(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.age = builder.age;
        this.gender = builder.gender;
        this.country = builder.country;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.username = builder.username;
        this.password = builder.password;
        this.isVerified = builder.isVerified;
        this.isPremiumUser = builder.isPremiumUser;
        this.profilePictureUrl = builder.profilePictureUrl;
        this.bio = builder.bio;
        this.website = builder.website;
        this.linkedIn = builder.linkedIn;
        this.github = builder.github;
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String address;
        private int age;
        private String gender;
        private String country;
        private String city;
        private String state;
        private String zipCode;
        private String username;
        private String password;
        private boolean isVerified;
        private boolean isPremiumUser;
        private String profilePictureUrl;
        private String bio;
        private String website;
        private String linkedIn;
        private String github;

        public   Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setIsVerified(boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        public Builder setIsPremiumUser(boolean isPremiumUser) {
            this.isPremiumUser = isPremiumUser;
            return this;
        }

        public Builder setProfilePictureUrl(String profilePictureUrl) {
            this.profilePictureUrl = profilePictureUrl;
            return this;
        }

        public Builder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder setLinkedIn(String linkedIn) {
            this.linkedIn = linkedIn;
            return this;
        }

        public Builder setGithub(String github) {
            this.github = github;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
