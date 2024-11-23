package cesar.school.raycharge.supplier.domain.station;

import org.jmolecules.ddd.types.ValueObject;

public class Address implements ValueObject {
    private final String cep;
    private final String street;
    private final int number;
    private final String neighborhood;
    private final String city;
    private final String state;

    public Address(String cep, String street, int number, String neighborhood, String city, String state) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Address) {
            var address = (Address) obj;
            return cep.equals(address.cep) && street.equals(address.street) && number == address.number && neighborhood.equals(address.neighborhood) && city.equals(address.city) && state.equals(address.state);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return cep.hashCode() + street.hashCode() + number + neighborhood.hashCode() + city.hashCode() + state.hashCode();
    }

    @Override
    public String toString() {
        return cep + ", " + street + ", " + number + ", " + neighborhood + ", " + city + ", " + state;
    }
}
