import React, { ReactNode } from 'react';

interface CardProps {
  title: string;
  description?: string;
  onClick?: () => void;
  imageSrc?: string; 
  children?: ReactNode;
}

const Card: React.FC<CardProps> = ({
  title,
  description = '',
  onClick = () => {},
  imageSrc = '', 
  children = null,
}) => {
  return (
    <div
      className="bg-white border border-gray-300 rounded-lg shadow-sm hover:shadow-md cursor-pointer transition-transform transform hover:-translate-y-1 focus:outline-none focus:ring-2 focus:ring-green-500"
      onClick={onClick}
      role="button"
      tabIndex={0}
      onKeyPress={(e) => {
        if (e.key === 'Enter') onClick();
      }}
    >
      {imageSrc && (
        <img
          src={imageSrc}
          alt={title}
          className="w-full h-48 object-cover rounded-t-lg"
        />
      )}
      <div className="p-4">
        <h3 className="text-lg font-semibold text-gray-800 mb-2">{title}</h3>
        <p className="text-sm text-gray-600">{description}</p>
        {children}
      </div>
    </div>
  );
};

export default Card;
