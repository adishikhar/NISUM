// src/App.js
import React from 'react';
import ProductEdit from './components/ProductEdit';
import withAdminAccess from './hoc/withAdminAccess';
import { useUser } from './context/UserContext';

const ProtectedProductEdit = withAdminAccess(ProductEdit);

const App = () => {
  const { loginAsAdmin, loginAsUser, user } = useUser();

  return (
    <div>
      <h1>Welcome, {user.name}</h1>
      <button onClick={loginAsUser}>Login as User</button>
      <button onClick={loginAsAdmin}>Login as Admin</button>

      <hr />
      <ProtectedProductEdit />
    </div>
  );
};

export default App;
