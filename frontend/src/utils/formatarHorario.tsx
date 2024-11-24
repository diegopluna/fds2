export function formatarHorario(startTime: string, endTime: string): string {
    const formattedStartTime = new Date(startTime).toLocaleTimeString('pt-BR', {
      hour: '2-digit',
      minute: '2-digit',
    });
    const formattedEndTime = new Date(endTime).toLocaleTimeString('pt-BR', {
      hour: '2-digit',
      minute: '2-digit',
    });
  
    return `${formattedStartTime} às ${formattedEndTime}`;
  }