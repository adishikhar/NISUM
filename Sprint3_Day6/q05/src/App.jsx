// src/App.jsx
import React, { useContext } from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import { CartProvider } from "./CartContext";
import CartContext from "./CartContext";
import CartPage from "./CartPage";

function Home() {
  const { addToCart } = useContext(CartContext);
  const sampleProduct = { name: "Bottle", price:  100 };

  return (
    <div>
      <h2>Home Page</h2>
      <button onClick={() => addToCart(sampleProduct)}>Add Product</button>
    </div>
  );
}

function App() {
  return (
    <CartProvider>
      <BrowserRouter>
        <nav>
          <Link to="/">Home</Link> | <Link to="/cart">Cart</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/cart" element={<CartPage />} />
        </Routes>
      </BrowserRouter>
    </CartProvider>
  );
}

export default App;
