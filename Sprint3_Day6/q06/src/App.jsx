import React, { useContext } from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import { CartProvider } from "./CartContext";
import CartContext from "./CartContext";
import CartPage from "./CartPage";

function Home() {
  const { addToCart } = useContext(CartContext);
  const product = { id: 1, name: "Phone", price: 1000 };

  return (
    <div>
      <h1>Home</h1>
      <button onClick={() => addToCart(product)}>Add to Cart</button>
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
