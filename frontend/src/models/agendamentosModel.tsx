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
    id: ScheduleId; 
    station: StationId; 
    driver: DriverId; 
    vehicle: VehicleId; 
    date: AvailableDate; 
    status: ScheduleStatus; 
    review?: Review; 
    chargerLiberationCode: number;
    totalRechargeValue: number;
}
