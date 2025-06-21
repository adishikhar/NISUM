import React, { useState } from "react";
import ProductList from "./ProductList";
import "./styles.css";

export default function App() {
  const [category, setCategory] = useState("All");
  const cats = ["All", "electronics", "jewelery", "men's clothing", "women's clothing"];

  return (
    <div>
      <h1>Shop</h1>
      <div className="tabs">
        {cats.map(cat => (
          <button
            key={cat}
            className={cat === category ? "active" : ""}
            onClick={() => setCategory(cat)}
          >
            {cat}
          </button>
        ))}
      </div>
      <ProductList category={category} />
    </div>
  );
}
