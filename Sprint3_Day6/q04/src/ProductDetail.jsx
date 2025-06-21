import React, { useEffect, useState } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";
import data from "./products.json";

function ProductDetail() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    const found = data.find(p => p.id === parseInt(id));
    setProduct(found);
  }, [id]);

  if (!product) return <p>Loading...</p>;

  return (
    <div>
      <nav>
        <Link to="/">Home</Link> / {product.name}
      </nav>
      <h2>{product.name}</h2>
      <img src={product.image} alt={product.name} style={{ width: "100px", height: "auto", objectFit: "cover" }} />
      <p>Price: ${product.price}</p>
      <p>{product.description}</p>
      <p>Stock: {product.stock}</p>
      <button onClick={() => navigate(-1)}>Go Back</button>
    </div>
  );
}

export default ProductDetail;
