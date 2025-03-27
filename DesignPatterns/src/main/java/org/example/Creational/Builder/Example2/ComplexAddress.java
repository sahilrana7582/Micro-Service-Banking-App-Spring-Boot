package org.example.Creational.Builder.Example2;

public class ComplexAddress {

    private final String houseNumber;
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;

    private ComplexAddress(AddressBuilder addressBuilder){
        this.houseNumber = addressBuilder.houseNumber;
        this.street = addressBuilder.street;
        this.city = addressBuilder.city;
        this.state = addressBuilder.state;
        this.zipCode = addressBuilder.zipCode;
    }

    public static final class AddressBuilder{
        private String houseNumber;
        private String street;
        private String city;
        private String state;
        private String zipCode;

        public AddressBuilder setHouseNumber(String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }
        public AddressBuilder setStreet(String street){
            this.street = street;
            return this;
        }
        public AddressBuilder setCity(String city){
            this.city = city;
            return this;
        }
        public AddressBuilder setState(String state){
            this.state = state;
            return this;
        }
        public AddressBuilder setZipCode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }
        public ComplexAddress build(){
            return new ComplexAddress(this);
        }
    }

}
