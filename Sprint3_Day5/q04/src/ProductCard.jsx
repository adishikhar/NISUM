import React from "react";
import "./ProductCard.css"; 

function ProductCard({ title = "iPhone 15", price = 1099, description = "Latest model with improved battery life." }) {
  const cardStyle = {
    border: "1px solid black",
    padding: "16px",
    borderRadius: "8px",
    maxWidth: "300px",
    margin: "20px auto",
    boxShadow: "2px 2px 8px rgba(0,0,0,0.1)"
  };

  return (
    <div style={cardStyle} className="productcard">
      <h2>{title}</h2>
      <p className="price">Price: ${price}</p>
      <p>{description}</p>
    </div>
  );
}

export default ProductCard;
