import React, { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';
import '../styles/Header.css';

const Header = () => {
  const { theme, toggleTheme } = useContext(ThemeContext);

  return (
    <header className={`header ${theme}`}>
      <h1>Theme Switcher App</h1>
      <button onClick={toggleTheme}>Toggle Theme</button>
    </header>
  );
};

export default Header;
