import React, { useState, useEffect, useRef, useCallback } from "react";
import ProductCard from "./ProductCard";

function ProductList({ category }) {
  const [items, setItems] = useState([]);
  const [limit] = useState(5);
  const [page, setPage] = useState(1);
  const [loading, setLoading] = useState(false);
  const observer = useRef();

  useEffect(() => {
    setItems([]);
    setPage(1);
  }, [category]);

  useEffect(() => {
    setLoading(true);
    const url =
      category === "All"
        ? `https://fakestoreapi.com/products?limit=${limit}&sort=asc`
        : `https://fakestoreapi.com/products/category/${encodeURIComponent(
            category
          )}?limit=${limit}&sort=asc`;
    fetch(url + `&page=${page}`)
      .then(res => res.json())
      .then(data => {
        if (data.length) setItems(prev => [...prev, ...data]);
        setLoading(false);
      });
  }, [page, category, limit]);

  const lastRef = useCallback(
    node => {
      if (loading) return;
      if (observer.current) observer.current.disconnect();
      observer.current = new IntersectionObserver(([entry]) => {
        if (entry.isIntersecting) setPage(prev => prev + 1);
      });
      if (node) observer.current.observe(node);
    },
    [loading]
  );

  return (
    <div className="product-list">
      {items.map((p, i) => (
        <div key={p.id} ref={i === items.length - 1 ? lastRef : null}>
          <ProductCard product={p} />
        </div>
      ))}
      {loading && <p>Loading...</p>}
    </div>
  );
}

export default ProductList;
