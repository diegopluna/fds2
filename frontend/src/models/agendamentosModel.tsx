// // private final ScheduleId scheduleId;
// //     private int chargerLiberationCode;
// //     private AvailableDate scheduleDate;
// //     private ScheduleStatus scheduleStatus;
// //     private float totalRechargeValue;
// //     private Review review;
// //     private StationId chargingStation;
// //     private DriverId driver;
// //     private VehicleId vehicle;

// // nome da classe + atributos para transformar em models

export interface ScheduleId {
    id: string;
}

export interface AvailableDate {
    scheduleStart: string;
    scheduleEnd: string;
}

export type ScheduleStatus = 'ACTIVE' | 'CANCELLED' | 'COMPLETED';

export interface Review {
    id: string;
    score: number;
    comment: string;
}

export interface StationId {
    id:string;
}

export interface DriverId {
    id: string;
}

export interface VehicleId {
    id: string;
}

export interface Schedule {
    id: ScheduleId; // Identificador único do agendamento
    station: StationId; // Identificador da estação associada
    driver: DriverId; // Identificador do motorista
    vehicle: VehicleId; // Identificador do veículo
    date: AvailableDate; // Datas e horários do agendamento
    status: ScheduleStatus; // Status do agendamento
    review?: Review; // Avaliação opcional associada ao agendamento
}


// // export type ScheduleStatus = 'ACTIVE' | 'CANCELLED' | 'COMPLETED'

// public class ScheduleId implements ValueObject, Identifier {
//     private final String id;


// public class AvailableDate implements ValueObject {
//     private final LocalDateTime scheduleStart;
//     private final LocalDateTime scheduleEnd;
// }

// public enum ScheduleStatus {
//     ACTIVE,
//     CANCELLED,
//     COMPLETED
// }


// public class Review implements ValueObject {
//     private final ReviewId id;
//     private final ReviewScore score;
//     private final String comment;

// }

// public class StationId implements ValueObject, Identifier {
//     private final String id;

// public class DriverId implements ValueObject, Identifier {
//         private final String id;

// public class VehicleId implements ValueObject, Identifier {
//             private final String id;