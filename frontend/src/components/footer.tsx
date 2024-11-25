import React from 'react';

const Footer: React.FC = () => {
  return (
    <footer className="bg-[#2D3648] text-white py-5 text-center">
    <p>Copyright 2024 RayCharge</p>
      <div className="mt-4">
        <ul className="flex justify-center list-none">
          <li className='mx-4'>
            <a href="#" className='text-[#A0ABC0] hover:underline'>Privacy Policy</a>
          </li>
          <li className='mx-4'>
            <a href="#" className='text-[#A0ABC0] hover:underline'>Terms & Conditions</a>
          </li>
          <li className='mx-4'>
            <a href="#" className='text-[#A0ABC0] hover:underline'>Cookie Policy</a>
            </li>
          <li className='mx-4'>
            <a href="#" className='text-[#A0ABC0] hover:underline'>Contact</a>
          </li>
        </ul>
      </div>
    </footer>
  );
};

export default Footer;
// .footer {
//     background-color: #2D3648;
//     color: #fff;
//     padding: 20px;
//     text-align: center;
//   }
  
//   .footer-links {
//     list-style: none;
//     display: flex;
//     justify-content: center;
//     margin-top: 10px;
//   }
  
//   .footer-links li {
//     margin: 0 15px;
//   }
  
//   .footer-links a {
//     color: #A0ABC0;
//     text-decoration: none;
//   }
