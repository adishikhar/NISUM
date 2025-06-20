import React from "react";

function NavItem({ label, active, onClick }) {
  return (
    <button
      className={active ? "nav-button active" : "nav-button"}
      onClick={onClick}
    >
      {label}
    </button>
  );
}

export default NavItem;
