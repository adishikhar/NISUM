import React from 'react';
import './styles/App.css';
import { ThemeProvider } from './context/ThemeContext';
import Header from './components/Header';
import Content from './components/Content';

function App() {
  return (
    <ThemeProvider>
      <div className="app">
        <Header />
        <Content />
      </div>
    </ThemeProvider>
  );
}

export default App;
