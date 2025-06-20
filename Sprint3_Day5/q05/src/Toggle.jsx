import React, { useState } from "react";

function Toggle() {
  const [isDark, setIsDark] = useState(false);

  const toggleTheme = () => {
    setIsDark(prev => !prev);
  };

  const themeStyle = {
    backgroundColor: isDark ? "#333" : "#fff",
    color: isDark ? "#fff" : "#333",
    height: "100vh",
    display: "flex",
    justifyContent: "center	",
    alignItems: "center",
    flexDirection: "column"
  };

  return (
    <div style={themeStyle}>
      <h2>{isDark ? "Dark Mode" : "Light Mode"}</h2>
      <button onClick={toggleTheme}>
        Toggle Theme
      </button>
    </div>
  );
}

export default Toggle;
