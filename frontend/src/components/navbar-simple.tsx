import React from 'react';
import logo from '/RayCharge.png';

// Componente da Navbar
const Navbar: React.FC = () => {
  return (
    <nav className="flex justify-between items-center p-4 bg-white shadow-md">
      <div className="flex items-center ml-6">
        <a href="/"><img src={logo} alt="RayCharge Logo" /></a>
      </div>
    </nav>
  );
};

export default Navbar;

// .navbar {
//     display: flex;
//     justify-content: space-between; /* Espaço entre logo e links */
//     align-items: center; /* Centraliza verticalmente */
//     padding: 10px 20px; /* Ajusta o espaçamento */
//     background-color: #ffffff; /* Cor de fundo (pode ajustar) */
//     box-shadow: 0 2px 5px rgba(18, 48, 82, 0.1); /* Adiciona uma sombra para melhorar o visual */
//   }
// .logo {
//     display: flex;
//     align-items: center; /* Centraliza o conteúdo da logo verticalmente */
//     margin-left: 26px;
// }
  
// .nav-links {
//     display: flex;
//     gap: 52px; /* Espaçamento entre os links */
//     list-style: none;
//     margin-right: 26px;
    
//     }

//   .nav-links li {
//     display: flex;
//     align-items: center;
//   }

//   .nav-links a:hover {
//     color: #007bff; /* Cor ao passar o mouse */
//   }
  