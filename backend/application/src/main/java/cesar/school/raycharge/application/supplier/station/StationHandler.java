package cesar.school.raycharge.application.supplier.station;

import cesar.school.raycharge.recharge.domain.schedule.ScheduleId;
import cesar.school.raycharge.supplier.domain.station.AvailableDate;
import cesar.school.raycharge.supplier.domain.station.ChargingStation;
import cesar.school.raycharge.supplier.domain.station.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class StationHandler {
    @Autowired
    private ChargingStationService chargingStationService;

    public StationsResponse fetchStationsByDistance(StationsByDistanceRequest request) {
        List<ChargingStation> stations = chargingStationService.fetchByDistance(request.getLatitude(), request.getLongitude(), request.getDistance());
        List<StationResponse> stationResponses = new ArrayList<>();

        for (ChargingStation station : stations) {
            AvailableDateResponse workingHours = new AvailableDateResponse(
                    station.getWorkingHours().getScheduleStart().format(DateTimeFormatter.ISO_DATE_TIME),
                    station.getWorkingHours().getScheduleEnd().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            List<AvailableDateResponse> availableDates = new ArrayList<>();
            for (AvailableDate availableDate : station.getAvailableDates()) {
                availableDates.add(new AvailableDateResponse(
                        availableDate.getScheduleStart().format(DateTimeFormatter.ISO_DATE_TIME),
                        availableDate.getScheduleEnd().format(DateTimeFormatter.ISO_DATE_TIME)
                ));
            }

            List<ScheduleIdResponse> usageHistory = new ArrayList<>();
            for (ScheduleId scheduleId : station.getUsageHistory()) {
                usageHistory.add(new ScheduleIdResponse(scheduleId.toString()));
            }

            stationResponses.add(new StationResponse(
                    station.getId().toString(),
                    station.getSupplierId().toString(),
                    station.getName(),
                    station.getNumberOfChargers(),
                    workingHours,
                    station.getStationAddress(),
                    station.getStatus().toString(),
                    station.getMinimumPrice(),
                    station.getPricePerKwh(),
                    station.getLongitude(),
                    station.getLatitude(),
                    station.getTimePerSchedule(),
                    availableDates,
                    usageHistory
            ));
        }

        return new StationsResponse(stationResponses);
    }
}
