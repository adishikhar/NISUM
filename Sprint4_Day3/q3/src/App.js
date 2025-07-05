import React from 'react';
import Header from './components/Header';
import ProductList from './components/ProductList';
import CartSummary from './components/CartSummary';

const App = () => {
  return (
    <div>
      <Header />
      <ProductList />
      <CartSummary />
    </div>
  );
};
console.log("App is rendering");


export default App;
