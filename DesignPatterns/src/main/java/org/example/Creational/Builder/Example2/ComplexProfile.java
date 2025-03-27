package org.example.Creational.Builder.Example2;

public class ComplexProfile {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final int age;
    private final String gender;
    private final String bio;

    private ComplexProfile(ProfileBuilder profileBuilder){
        this.firstName = profileBuilder.firstName;
        this.lastName = profileBuilder.lastName;
        this.email = profileBuilder.email;
        this.phoneNumber = profileBuilder.phoneNumber;
        this.age = profileBuilder.age;
        this.gender = profileBuilder.gender;
        this.bio = profileBuilder.bio;
    }


    public static final class ProfileBuilder{
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private int age;
        private String gender;
        private String bio;

        private boolean isBuilt = false;

        public ProfileBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public ProfileBuilder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public ProfileBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public ProfileBuilder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ProfileBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public ProfileBuilder setGender(String gender){
            this.gender = gender;
            return this;
        }

        public ProfileBuilder setBio(String bio){
            this.bio = bio;
            return this;
        }

        public ComplexProfile build(){
            checkBuilt();
            isBuilt = true;
            return new ComplexProfile(this);
        }

        public void checkBuilt(){
            if(isBuilt){
                throw new IllegalStateException("Profile is already built");
            }
        }


    }
}
