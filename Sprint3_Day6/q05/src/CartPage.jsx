
import React, { useContext } from "react";
import CartContext from "./CartContext";

function CartPage() {
  const { cart, removeFromCart, clearCart } = useContext(CartContext);

  return (
    <div>
      <h2>Cart</h2>
      {cart.length === 0 ? (
        <p>No items in cart.</p>
      ) : (
        <>
          <ul>
            {cart.map((item, index) => (
              <li key={index}>
                {item.name} - ₹{item.price}
                <button onClick={() => removeFromCart(index)}>Remove</button>
              </li>
            ))}
          </ul>
          <button onClick={clearCart}>Clear All</button>
        </>
      )}
    </div>
  );
}

export default CartPage;
