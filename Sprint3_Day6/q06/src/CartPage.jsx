import React, { useContext } from "react";
import CartContext from "./CartContext";

function CartPage() {
  const { cart, increment, decrement } = useContext(CartContext);

  const total = cart.reduce((sum, item) => sum + item.price * item.qty, 0);

  return (
    <div>
      <h2>Your Cart</h2>
      {cart.length === 0 ? (
        <p>Cart is empty</p>
      ) : (
        <div>
          {cart.map((item, index) => (
            <div className="cart-item" key={index}>
  <p>{item.name} - ₹{item.price} × {item.qty}</p>
  <button onClick={() => decrement(index)} disabled={item.qty === 1}>-</button>
  <button onClick={() => increment(index)}>+</button>
</div>

          ))}
          <h3>Total: ₹{total}</h3>
        </div>
      )}
    </div>
  );
}

export default CartPage;
