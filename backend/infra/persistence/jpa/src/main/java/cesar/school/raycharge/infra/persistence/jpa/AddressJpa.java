package cesar.school.raycharge.infra.persistence.jpa;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressJpa {
    String cep;
    String street;
    int number;
    String neighborhood;
    String city;
    String state;

    protected AddressJpa() {
    }

    public AddressJpa(String cep, String street, int number, String neighborhood, String city, String state) {
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
