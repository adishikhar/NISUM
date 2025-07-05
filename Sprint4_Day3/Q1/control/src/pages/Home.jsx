import React from "react";
import useAuth from "../hooks/useAuth";
import { adminUser, normalUser } from "../data/mockUsers";

const Home = () => {
  const { login } = useAuth();

  return (
    <div>
      <h2>Login</h2>
      <button onClick={() => login(adminUser)}>Login as Admin</button>
      <button onClick={() => login(normalUser)}>Login as User</button>
    </div>
  );
};

export default Home;
