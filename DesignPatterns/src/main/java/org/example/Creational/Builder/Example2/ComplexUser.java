package org.example.Creational.Builder.Example2;

public class ComplexUser {

    private final ComplexProfile complexProfile;
    private final ComplexAddress complexAddress;

    private ComplexUser(UserBuilder userBuilder) {
        this.complexProfile = userBuilder.complexProfile;
        this.complexAddress = userBuilder.complexAddress;
    }

    public ComplexProfile getComplexProfile() {
        return complexProfile;
    }

    public ComplexAddress getComplexAddress() {
        return complexAddress;
    }

    public static  class UserBuilder {
        private ComplexProfile complexProfile;
        private ComplexAddress complexAddress;

        public UserBuilder setComplexProfile(ComplexProfile complexProfile) {
            this.complexProfile = complexProfile;
            return this;
        }

        public UserBuilder setComplexAddress(ComplexAddress complexAddress) {
            this.complexAddress = complexAddress;
            return this;
        }

        public ComplexUser build() {
            return new ComplexUser(this);
        }
    }
}
