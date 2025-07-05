import React from 'react';
import { useDispatch } from 'react-redux';
import { addToCart } from '../redux/actions/cartActions';
import products from '../data/products';

const ProductList = () => {
  const dispatch = useDispatch();

  return (
    <div>
      {products.map(p => (
        <div key={p.id}>
          <h4>{p.name}</h4>
          <p>₹{p.price}</p>
          <button onClick={() => dispatch(addToCart(p))}>Add to Cart</button>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
