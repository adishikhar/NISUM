import { useContext } from "react";
import { ThemeProvider, ThemeContext } from "./ThemeContext";
import ThemeToggle from "./ThemeToggle";
import "./index.css";

function MainContent() {
  const { dark } = useContext(ThemeContext);

  return (
    <div className={dark ? "dark" : "light"}>
      <ThemeToggle />
    </div>
  );
}

function App() {
  return (
    <ThemeProvider>
      <MainContent />
    </ThemeProvider>
  );
}

export default App;
