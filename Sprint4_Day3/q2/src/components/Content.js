import React, { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';
import '../styles/Content.css';

const Content = () => {
  const { theme } = useContext(ThemeContext);

  return (
    <div className={`content ${theme}`}>
      <p>This is a content block that changes with the theme.</p>
    </div>
  );
};

export default Content;
