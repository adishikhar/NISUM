import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ProductDetail from "./ProductDetail";

function Home() {
  return <h1>Home Page</h1>;
}

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products/:id" element={<ProductDetail />} />
        <Route path="*" element={<h2>404 Not Found</h2>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
