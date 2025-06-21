
import React, { useState } from "react";
import ProductList from "./ProductList";
import "./styles.css";

const categories = ["All", "smartphones", "laptops", "fragrances"];

export default function App() {
  const [category, setCategory] = useState("All");

  return (
    <div>
      <h1>Store</h1>
      <div className="tabs">
        {categories.map(cat => (
          <button
            key={cat}
            className={cat === category ? "active" : ""}
            onClick={() => setCategory(cat)}
          >
            {cat}
          </button>
        ))}
      </div>
      <ProductList selectedCategory={category} />
    </div>
  );
}
