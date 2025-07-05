import React from 'react';
import { useSelector } from 'react-redux';

const Cart = () => {
  const items = useSelector(state => state.cart.items);
  const total = items.reduce((sum, item) => sum + item.price, 0);

  return (
    <div>
      <h3>Cart</h3>
      <p>Total Items: {items.length}</p>
      <p>Total: ₹{total}</p>
    </div>
  );
};

export default Cart;
