
import React from "react";
import { useWishlist } from "./useWishlist";

function WishlistPage() {
  const { wishlist } = useWishlist();

  return (
    <div>
      <h2>My Wishlist</h2>
      {wishlist.length === 0 && <p>No items yet.</p>}
      {wishlist.map((item) => (
        <div className="wishlist-item" key={item.id}>
  <h4>{item.name}</h4>
  <p>₹{item.price}</p>
</div>

      ))}
    </div>
  );
}

export default WishlistPage;
