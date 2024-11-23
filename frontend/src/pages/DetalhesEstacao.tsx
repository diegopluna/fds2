import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { DateTimePicker } from '@/components/datetime-picker';
import { Button } from '@/components/ui/button';

const DetalhesEstacao = () => {
    const [date, setDate] = useState<Date | undefined>(undefined);
    return (
        <div className='container-fluid'>
            <div className='row p-3 justify-content-center text-center'>
                <h1 className="text-[#2D3648] font-inter font-bold text-4xl mt-4">Estação 01</h1>
                <h3 className="text-[#2D3648] font-inter font-bold text-l mb-9 mt-2"><i>Detalhes da Estação</i></h3>
            </div>
            <div className='row p-3'>
                <div className='col-5'>
                    <p>Status: </p>
                    <p>Endereço: </p>
                    <p>Complemento: </p>
                    <p>Horário Funcionamento: </p>
                    <p>Preço Mínimo: </p>
                    <p>Preço por KWh: </p>
                    <p>Quantidade Carregadores: </p>
                </div>
                <div className='col-7 flex no-wrap justify-center items-center'>
                    <Button variant='default' className='bg-[#4A5468] text-white px-4 py-2 rounded-md hover:bg-[#2D3648]'>Agendar</Button>
                    <DateTimePicker value={date} onChange={setDate} min={new Date()} />
                </div>
            </div>
        </div>
    )
}

export default DetalhesEstacao;