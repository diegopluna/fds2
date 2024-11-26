package cesar.school.raycharge.presentation.recharge;

import cesar.school.raycharge.application.common.ErrorResponse;
import cesar.school.raycharge.application.recharge.schedule.CreateScheduleRequest;
import cesar.school.raycharge.application.recharge.schedule.ScheduleHandler;
import cesar.school.raycharge.driver.domain.vehicle.VehicleNotFound;
import cesar.school.raycharge.recharge.domain.schedule.*;
import cesar.school.raycharge.supplier.domain.station.StationNotAvailable;
import cesar.school.raycharge.supplier.domain.station.StationNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recharge/schedule")
public class ScheduleController {
    @Autowired
    ScheduleHandler scheduleHandler;

    @PostMapping("/new")
    public ResponseEntity<?> createSchedule(@RequestBody CreateScheduleRequest request) {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        try {
            scheduleHandler.scheduleRecharge(request, login);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DriverNotFound | StationNotFound | VehicleNotFound e) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            ErrorResponse errorResponse = new ErrorResponse(
                    httpStatus.value(), e.getMessage()
            );
            return ResponseEntity.status(httpStatus).body(errorResponse);
        } catch (ActiveScheduleFound | StationNotAvailable e) {
            HttpStatus httpStatus = HttpStatus.CONFLICT;
            ErrorResponse errorResponse = new ErrorResponse(
                    httpStatus.value(), e.getMessage()
            );
            return ResponseEntity.status(httpStatus).body(errorResponse);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> fetchSchedules() {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        List<Schedule> schedules = scheduleHandler.fetchSchedules(login);
        return ResponseEntity.ok(schedules);
    }

    @PatchMapping("/{scheduleId}/cancel")
    public ResponseEntity<?> cancelSchedule(@PathVariable("scheduleId") String scheduleId) {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        try {
            scheduleHandler.cancelSchedule(scheduleId, login);
            return ResponseEntity.ok().build();
        } catch (ScheduleDoesNotBelongToDriver e) {
            HttpStatus httpStatus = HttpStatus.FORBIDDEN;
            ErrorResponse errorResponse = new ErrorResponse(
                    httpStatus.value(), e.getMessage()
            );
            return ResponseEntity.status(httpStatus).body(errorResponse);
        } catch (ScheduleNotFound e) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            ErrorResponse errorResponse = new ErrorResponse(
                    httpStatus.value(), e.getMessage()
            );
            return ResponseEntity.status(httpStatus).body(errorResponse);
        } catch (ScheduleNotActive e) {
            HttpStatus httpStatus = HttpStatus.CONFLICT;
            ErrorResponse errorResponse = new ErrorResponse(
                    httpStatus.value(), e.getMessage()
            );
            return ResponseEntity.status(httpStatus).body(errorResponse);
        }
    }
}
