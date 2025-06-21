import React, { useEffect, useState, useRef } from "react";
import data from "./products.json";
import ProductCard from "./ProductCard";
import "./style.css";

function ProductList() {
  const [products, setProducts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [search, setSearch] = useState("");
  const [category, setCategory] = useState("All");
  const [min, setMin] = useState("");
  const [max, setMax] = useState("");
  const timeoutRef = useRef(null);

  useEffect(() => {
    setProducts(data);
    setFiltered(data);
  }, []);

  useEffect(() => {
    if (timeoutRef.current) clearTimeout(timeoutRef.current);
    timeoutRef.current = setTimeout(() => {
      let result = [...products];

      if (search.trim()) {
        result = result.filter((p) =>
          p.name.toLowerCase().includes(search.toLowerCase())
        );
      }

      if (category !== "All") {
        result = result.filter((p) => p.category === category);
      }

      if (min) result = result.filter((p) => p.price >= parseInt(min));
      if (max) result = result.filter((p) => p.price <= parseInt(max));

      setFiltered(result);
    }, 300); // debounce
  }, [search, category, min, max, products]);

  return (
    <div className="filter-box">
      <input
        type="text"
        placeholder="Search product..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <select onChange={(e) => setCategory(e.target.value)}>
        <option>All</option>
        <option>Body-Essential</option>
        <option>Grocery</option>
        <option>Footwear</option>
      </select>

      <input
        type="number"
        placeholder="Min Price"
        value={min}
        onChange={(e) => setMin(e.target.value)}
      />

      <input
        type="number"
        placeholder="Max Price"
        value={max}
        onChange={(e) => setMax(e.target.value)}
      />

      <div className="product-grid">
        {filtered.map((item) => (
          <ProductCard key={item.id} product={item} />
        ))}
      </div>
    </div>
  );
}

export default ProductList;
