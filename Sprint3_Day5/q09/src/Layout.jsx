import React from "react";
import "./Layout.css";

function Layout(props) {
  return (
    <div className="layout">
      <header>Header</header>
      <main>{props.children}</main>
      <footer>Footer</footer>
    </div>
  );
}

export default Layout;
