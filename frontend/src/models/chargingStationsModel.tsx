export interface Address {
    cep: string;
    street: string;
    number: number;
    neighborhood: string;
    city: string;
    state: string;
  }
  
  export interface UserId {
    id: string;
  }
  
  export interface ScheduleId {
    id: string;
  }
  
  export interface AvailableDate {
    scheduleStart: string;
    scheduleEnd: string;
  }
  
  export type StationStatus = 'ACTIVE' | 'INACTIVE';
  
  export interface Station {
    stationId: string;
    supplierId: string;
    name: string;
    numberOfChargers: number;
    workingHours: AvailableDate;
    stationAddress: Address;
    status: StationStatus;
    minimumPrice: number;
    pricePerKwh: number;
    longitude: number;
    latitude: number;
    timePerSchedule: number;
    availableDates: AvailableDate[];
    usageHistory: ScheduleId[];
  }

  export interface StationsResponse {
    chargingStations: Station[];
  }
  