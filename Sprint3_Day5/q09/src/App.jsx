import React, { useState } from "react";
import Home from "./Home";
import About from "./About";

function App() {
  const [showHome, setShowHome] = useState(true);

  return showHome ? <Home /> : <About />;
}


export default App;
