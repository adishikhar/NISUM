import React from 'react';
import { useDispatch } from 'react-redux';
import { addToCart } from '../features/cart/cartSlice';

const products = [
  { id: 1, name: 'T-shirt', price: 499 },
  { id: 2, name: 'Shoes', price: 1299 },
];

const ProductList = () => {
  const dispatch = useDispatch();

  return (
    <div>
      <h2>Products</h2>
      {products.map(p => (
        <div key={p.id}>
          <span>{p.name} - ₹{p.price}</span>
          <button onClick={() => dispatch(addToCart(p))}>Add to Cart</button>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
