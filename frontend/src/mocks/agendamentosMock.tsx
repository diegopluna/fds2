import { Schedule } from '../models/agendamentosModel.tsx';
export const mockSchedules: Schedule[] = [
    {
      id: { id: 'schedule-1' },
      chargerLiberationCode: 123456,
      totalRechargeValue: 50.75,
      station: { id: 'station-123' },
      driver: { id: 'driver-456' },
      vehicle: { id: 'vehicle-789' },
      date: {
        scheduleStart: '2024-11-26T08:00:00Z',
        scheduleEnd: '2024-11-26T09:00:00Z',
      },
      status: 'ACTIVE',
      review: {
        id: 'review-001',
        score: 4.5,
        comment: 'Ótima experiência de recarga!',
      },
    },
    {
      id: { id: 'schedule-2' },
      chargerLiberationCode: 987654,
      totalRechargeValue: 30.5,
      station: { id: 'station-321' },
      driver: { id: 'driver-654' },
      vehicle: { id: 'vehicle-987' },
      date: {
        scheduleStart: '2024-11-27T10:00:00Z',
        scheduleEnd: '2024-11-27T11:00:00Z',
      },
      status: 'COMPLETED',
      review: {
        id: 'review-002',
        score: 5,
        comment: 'Excelente atendimento!',
      },
    },
  ];