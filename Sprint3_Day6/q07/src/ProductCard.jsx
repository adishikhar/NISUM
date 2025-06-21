
import React from "react";
import { useWishlist } from "./useWishlist";

function ProductCard({ product }) {
  const { wishlist, toggleWishlist } = useWishlist();
  const isWishlisted = wishlist.some((p) => p.id === product.id);

  return (
    <div className="product-card">
  <h3>{product.name}</h3>
  <p>₹{product.price}</p>
  <p>{product.description}</p>
  <button onClick={() => toggleWishlist(product)}>
    {isWishlisted ? "❤️ Remove" : "🤍 Add to Wishlist"}
  </button>
</div>

  );
}

export default ProductCard;
