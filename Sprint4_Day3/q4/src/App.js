import React from 'react';
import UserInfo from './features/user/UserInfo';
import Cart from './features/cart/Cart';
import ProductList from './components/ProductList';

function App() {
  return (
    <div>
      <UserInfo />
      <Cart />
      <ProductList />
    </div>
  );
}

export default App;
