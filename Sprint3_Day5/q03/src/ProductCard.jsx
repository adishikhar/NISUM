import React from "react";

function ProductCard({ title = "iPhone 15", price = 1099, description = "Latest model with improved battery life." }) {
  return (
    <div>
      <h2>{title}</h2>
      <p>Price: ${price}</p>
      <p>{description}</p>
    </div>
  );
}

export default ProductCard;
