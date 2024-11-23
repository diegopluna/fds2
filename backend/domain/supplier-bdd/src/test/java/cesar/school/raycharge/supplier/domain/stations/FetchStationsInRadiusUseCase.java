package cesar.school.raycharge.supplier.domain.stations;

import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.supplier.domain.SupplierUseCase;
import cesar.school.raycharge.supplier.domain.station.*;
import cesar.school.raycharge.supplier.domain.supplier.SupplierId;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FetchStationsInRadiusUseCase extends SupplierUseCase {
    SupplierId supplierId = new SupplierId();
    ScheduleId scheduleId = new ScheduleId();
    Address address = new Address("5555-555", "Rua de Teste", 150, "Algum Bairro", "Alguma Cidade", "Algum Estado");
    AvailableDate workingHours = new AvailableDate(LocalDateTime.of(2021, 1, 1, 0, 0), LocalDateTime.of(2021, 1, 1, 23, 59));
    ChargingStation station;
    List<ChargingStation> stations;

    @Given("a station with name {string}, latitude {double}, and longitude {double}")
    public void a_station_with_name_latitude_and_longitude(String name, double latitude, double longitude) {
        System.out.println("Creating station with name " + name + " at latitude " + latitude + " and longitude " + longitude);
        ChargingStation newStation = new ChargingStation(new StationId(), supplierId, name, 10, workingHours ,address, StationStatus.ACTIVE, 10 ,1,  latitude, longitude, 2, List.of(workingHours), List.of(scheduleId));
        chargingStationService.addStation(newStation);
    }

    @When("I fetch stations in radius {int} kilometers from latitude {double} and longitude {double}")
    public void i_fetch_stations_in_radius_kilometers_from_latitude_and_longitude(int radius, double latitude, double longitude) {
        System.out.println("Fetching stations in radius " + radius + " kilometers from latitude " + latitude + " and longitude " + longitude);
        stations = chargingStationService.fetchByDistance(latitude, longitude, radius);
    }

    @Then("I should get {int} stations")
    public void i_should_get_stations(int count) {
        assert stations.size() == count;
    }

}
