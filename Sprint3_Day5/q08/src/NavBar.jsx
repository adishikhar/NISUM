import React, { useState } from "react";
import NavItem from "./NavItem";
import "./NavBar.css";

function NavBar() {
  const [active, setActive] = useState("Home");

  const items = ["Home", "About", "Services", "Contact"];

  return (
    <div className="navbar">
      {items.map((item) => (
        <NavItem
          key={item}
          label={item}
          active={active === item}
          onClick={() => setActive(item)}
        />
      ))}
    </div>
  );
}

export default NavBar;
