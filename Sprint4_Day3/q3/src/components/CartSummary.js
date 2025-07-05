import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { removeFromCart } from '../redux/actions/cartActions';

const CartSummary = () => {
  const items = useSelector(state => state.cart.items);
  const dispatch = useDispatch();

  const total = items.reduce((acc, item) => acc + item.price, 0);

  return (
    <div>
      <h3>Cart ({items.length} items)</h3>
      <p>Total: ₹{total}</p>
      {items.map(item => (
        <div key={item.id}>
          {item.name} - ₹{item.price}
          <button onClick={() => dispatch(removeFromCart(item.id))}>X</button>
        </div>
      ))}
    </div>
  );
};

export default CartSummary;
