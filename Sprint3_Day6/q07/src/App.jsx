

import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import ProductCard from "./ProductCard";
import WishlistPage from "./WishlistPage";
import "./styles.css";

const dummyProducts = [
  { id: 1, name: "Soap", price: 50, description: "Gentle soap" },
  { id: 2, name: "Shampoo", price: 120, description: "Hair shampoo" }
];

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">Home</Link> | <Link to="/wishlist">Wishlist</Link>
      </nav>
      <Routes>
        <Route path="/" element={
          <div>
            <h2>All Products</h2>
            {dummyProducts.map((prod) => (
              <ProductCard key={prod.id} product={prod} />
            ))}
          </div>
        } />
        <Route path="/wishlist" element={<WishlistPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
