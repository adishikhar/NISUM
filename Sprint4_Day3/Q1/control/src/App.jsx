import React from "react";
import useAuth from "./hooks/useAuth";
import Home from "./pages/Home";
import Dashboard from "./components/Dashboard";

const App = () => {
  const { user } = useAuth();

  return <div>{user.isLoggedIn ? <Dashboard /> : <Home />}</div>;
};

export default App;
