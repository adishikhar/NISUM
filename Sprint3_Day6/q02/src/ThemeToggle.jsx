import { useContext } from "react";
import { ThemeContext } from "./ThemeContext";

function ThemeToggle() {
  const { dark, toggleTheme } = useContext(ThemeContext);

  return (
    <div>
      <p>Theme: {dark ? "Dark" : "Light"}</p>
      <button onClick={toggleTheme}>Toggle</button>
    </div>
  );
}

export default ThemeToggle;
