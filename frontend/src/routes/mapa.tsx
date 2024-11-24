import { createFileRoute, useNavigate } from '@tanstack/react-router'
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import { LatLngExpression } from 'leaflet'
import L from 'leaflet'
import EstacaoBox from '@/components/estacao-box'
import { chargingStationsMock } from '@/mocks/chargingStationsMock'

export const Route = createFileRoute('/mapa')({
  component: mapa,
})

const customMarker = L.icon({
  iconUrl:
    'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon-2x.png',
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  shadowUrl:
    'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-shadow.png',
  shadowSize: [41, 41],
})

function mapa() {
  const position: LatLngExpression = [-8.0584371, -34.8725274]
  const navigate = useNavigate()

  const handleDetailsRedirect = (stationId: string) => {
    console.log('station id enviado de mapa: ', stationId )
    console.log('Station ID (typeof):', typeof stationId)
    navigate({ to: `/detalhesEstacao/${stationId}` }) 
  }

  return (
    <div className="px-16 py-4 w-full">
      <h2 className="text-[#2D3648] text-center text-2xl font-bold mb-4">
        Escolha sua estação
      </h2>
      <div className="h-[500px] w-full rounded-lg overflow-hidden shadow-lg mb-6">
        <MapContainer center={position} zoom={13} className="h-full w-full">
          <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          {chargingStationsMock.map((station) => (
            <Marker
              key={station.stationId}
              position={
                [station.latitude, station.longitude] as LatLngExpression
              }
              icon={customMarker}
            >
              <Popup>
                <div>
                  <h3 className="text-lg font-semibold text-center mb-2">
                    {station.name}
                  </h3>
                  <div className="text-sm text-gray-600">
                    <p className="m-0">
                      Quantidade de estações: {station.numberOfChargers}
                    </p>
                    <p className="m-0">
                      Horário de funcionamento:{' '}
                      {station.workingHours.scheduleStart} às{' '}
                      {station.workingHours.scheduleEnd}
                    </p>
                    <p className="m-0">
                      Endereço: {station.stationAddress.street},{' '}
                      {station.stationAddress.number},{' '}
                      {station.stationAddress.neighborhood},{' '}
                      {station.stationAddress.city} -{' '}
                      {station.stationAddress.state}
                    </p>
                  </div>
                  <button
                    className="text-center px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600"
                    onClick={() => handleDetailsRedirect(station.stationId)} // Redireciona ao clicar
                  >
                    Saiba Mais
                  </button>
                </div>
              </Popup>
            </Marker>
          ))}
        </MapContainer>
      </div>

      <div>
        <h2 className="text-center text-2xl font-bold mb-4">
          Confira a lista de estações
        </h2>
        {chargingStationsMock.map((station) => (
          <EstacaoBox
            key={station.stationId}
            nome={station.name}
            endereco={station.stationAddress}
            precoMininimo={station.minimumPrice}
            precoKwh={station.pricePerKwh}
            onDetalhes={() => handleDetailsRedirect(station.stationId)} // Redireciona ao clicar
          />
        ))}
      </div>
    </div>
  )
}

export default mapa
