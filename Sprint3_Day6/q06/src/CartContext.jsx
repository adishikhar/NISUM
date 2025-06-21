import React, { createContext, useReducer } from "react";

const CartContext = createContext();

const initialState = {
  cartItems: [],
};

function cartReducer(state, action) {
  switch (action.type) {
    case "ADD":
      const exist = state.cartItems.find((item) => item.id === action.payload.id);
      if (exist) {
        return {
          ...state,
          cartItems: state.cartItems.map((item) =>
            item.id === action.payload.id ? { ...item, qty: item.qty + 1 } : item
          ),
        };
      }
      return {
        ...state,
        cartItems: [...state.cartItems, { ...action.payload, qty: 1 }],
      };

    case "INCREMENT":
      return {
        ...state,
        cartItems: state.cartItems.map((item, i) =>
          i === action.index ? { ...item, qty: item.qty + 1 } : item
        ),
      };

    case "DECREMENT":
      return {
        ...state,
        cartItems: state.cartItems.map((item, i) =>
          i === action.index && item.qty > 1 ? { ...item, qty: item.qty - 1 } : item
        ),
      };

    default:
      return state;
  }
}

export function CartProvider({ children }) {
  const [state, dispatch] = useReducer(cartReducer, initialState);

  const addToCart = (item) => dispatch({ type: "ADD", payload: item });
  const increment = (index) => dispatch({ type: "INCREMENT", index });
  const decrement = (index) => dispatch({ type: "DECREMENT", index });

  return (
    <CartContext.Provider value={{ cart: state.cartItems, addToCart, increment, decrement }}>
      {children}
    </CartContext.Provider>
  );
}

export default CartContext;
