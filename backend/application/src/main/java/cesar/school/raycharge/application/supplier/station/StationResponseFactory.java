package cesar.school.raycharge.application.supplier.station;

import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.supplier.domain.station.Address;

import java.util.List;

public class StationResponseFactory {

    public static StationResponse createStationResponse(
            String stationId,
            String supplierId,
            String name,
            int numberOfChargers,
            AvailableDateResponse workingHours,
            Address stationAddress,
            String status,
            int minimumPrice,
            int pricePerKwh,
            double longitude,
            double latitude,
            int timePerSchedule,
            List<AvailableDateResponse> availableDates,
            List<ScheduleIdResponse> usageHistory) {

        return new StationResponse(
                stationId,
                supplierId,
                name,
                numberOfChargers,
                workingHours,
                stationAddress,
                status,
                minimumPrice,
                pricePerKwh,
                longitude,
                latitude,
                timePerSchedule,
                availableDates,
                usageHistory
        );
    }
}
