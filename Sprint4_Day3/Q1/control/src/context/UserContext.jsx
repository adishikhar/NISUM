import React, { createContext, useState } from "react";

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState({ isLoggedIn: false });

  const login = (userData) => setUser({ ...userData, isLoggedIn: true });
  const logout = () => setUser({ isLoggedIn: false });

  return (
    <UserContext.Provider value={{ user, login, logout }}>
      {children}
    </UserContext.Provider>
  );
};
