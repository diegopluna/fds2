import { Station } from '../models/chargingStationsModel.tsx';

export const chargingStationsMock: Station[] = [
  {
    stationId: '1',
    supplierId: '1',
    name: 'Central Charging Station',
    numberOfChargers: 10,
    workingHours: {
      scheduleStart: '2023-11-21T06:00:00',
      scheduleEnd: '2023-11-21T23:00:00',
    },
    stationAddress: {
      cep: '50000-000',
      street: 'Rua Exemplo',
      number: 123,
      neighborhood: 'Centro',
      city: 'Recife',
      state: 'PE',
    },
    status: 'ACTIVE',
    minimumPrice: 50,
    pricePerKwh: 5,
    longitude: -34.8725274,
    latitude: -8.0584371,
    timePerSchedule: 30,
    availableDates: [
      {
        scheduleStart: '2023-11-22T06:00:00',
        scheduleEnd: '2023-11-22T23:00:00',
      },
      {
        scheduleStart: '2023-11-23T06:00:00',
        scheduleEnd: '2023-11-23T23:00:00',
      },
    ],
    usageHistory: [
      { id: 'schedule-001' },
      { id: 'schedule-002' },
    ],
  },
  {
    stationId: '2',
    supplierId: '2',
    name: 'North Charging Station',
    numberOfChargers: 8,
    workingHours: {
      scheduleStart: '2023-11-21T07:00:00',
      scheduleEnd: '2023-11-21T22:00:00',
    },
    stationAddress: {
      cep: '50000-001',
      street: 'Avenida Exemplo',
      number: 456,
      neighborhood: 'Zona Norte',
      city: 'Recife',
      state: 'PE',
    },
    status: 'INACTIVE',
    minimumPrice: 40,
    pricePerKwh: 4,
    longitude: -34.8700000,
    latitude: -8.0600000,
    timePerSchedule: 20,
    availableDates: [
      {
        scheduleStart: '2023-11-24T07:00:00',
        scheduleEnd: '2023-11-24T22:00:00',
      },
    ],
    usageHistory: [
      { id: 'schedule-003' },
    ],
  },
];
