import React from "react";
import useAuth from "../hooks/useAuth";

const Dashboard = () => {
  const { user, logout } = useAuth();

  return (
    <div>
      <h2>Welcome, {user.name}</h2>
      <p>Role: {user.role}</p>

      {user.role === "admin" && <button>Add Product</button>}

      <button onClick={logout}>Logout</button>
    </div>
  );
};

export default Dashboard;
