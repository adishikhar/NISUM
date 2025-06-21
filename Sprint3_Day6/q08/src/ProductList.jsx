
import React, { useEffect, useState, useRef, useCallback } from "react";
import ProductCard from "./ProductCard";

function ProductList({ selectedCategory }) {
  const [products, setProducts] = useState([]);
  const [skip, setSkip] = useState(0);
  const [loading, setLoading] = useState(false);

  const observer = useRef();

  // Reset when category changes
  useEffect(() => {
    setProducts([]);
    setSkip(0);
  }, [selectedCategory]);

  // Load data
  useEffect(() => {
    setLoading(true);
    let url = `https://dummyjson.com/products?limit=10&skip=${skip}`;
    if (selectedCategory !== "All") {
      url = `https://dummyjson.com/products/category/${selectedCategory}?limit=10&skip=${skip}`;
    }
    fetch(url)
      .then(res => res.json())
      .then(data => {
        setProducts(prev => [...prev, ...(data.products || data)]);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, [skip, selectedCategory]);

  // Infinite scroll
  const lastRef = useCallback(
    node => {
      if (loading) return;
      if (observer.current) observer.current.disconnect();
      observer.current = new IntersectionObserver(entries => {
        if (entries[0].isIntersecting) setSkip(prev => prev + 10);
      });
      if (node) observer.current.observe(node);
    },
    [loading]
  );

  return (
    <div className="product-list">
      {products.map((p, i) => (
        <div key={p.id} ref={i === products.length - 1 ? lastRef : null}>
          <ProductCard product={p} />
        </div>
      ))}
      {loading && <p>Loading more...</p>}
    </div>
  );
}

export default ProductList;
