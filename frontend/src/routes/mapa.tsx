import { createFileRoute } from '@tanstack/react-router';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import { LatLngExpression } from 'leaflet';
import L from 'leaflet';

export const Route = createFileRoute('/mapa')({
  component: Mapa,
});

const customMarker = L.icon({
  iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon-2x.png', 
  iconSize: [25, 41], 
  iconAnchor: [12, 41], 
  popupAnchor: [1, -34], 
  shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-shadow.png', 
  shadowSize: [41, 41], 
});

function Mapa() {
  const position: LatLngExpression = [-8.0584371, -34.8725274];

  return (
    <div className="p-4 w-full">
      <h2 className="text-center text-2xl font-bold mb-4">Escolha sua estação</h2>
      <div className="h-[500px] w-full rounded-lg overflow-hidden shadow-lg">
        <MapContainer
          center={position}
          zoom={13}
          className="h-full w-full"
        >
          <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          <Marker position={position} icon={customMarker}>
        <Popup>
          <div>
            <h3 className="text-lg font-semibold text-center mb-2">Estação CESAR Apolo</h3>
            <div className="text-sm text-gray-600">
              <p className="m-0">Quantidade de estações: 5</p>
              <p className="m-0">Horário de funcionamento: 6:00 às 23:00 todos os dias</p>
            </div>
            <button
              className=" text-center px-4 py-2 bg-green-500 text-white rounded hover:bg-green-500"
              onClick={() => alert('Mais informações!')}
            >
              Saiba Mais
            </button>
          </div>
        </Popup>
      </Marker>
        </MapContainer>
      </div>
    </div>
  );
}

export default Mapa;
