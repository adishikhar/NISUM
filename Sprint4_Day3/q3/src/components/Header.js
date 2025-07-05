import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { login, logout } from '../redux/actions/userActions';

const Header = () => {
  const dispatch = useDispatch();
  const { isLoggedIn, user } = useSelector(state => state.user);

  const handleLogin = () => {
    dispatch(login({ name: 'John Doe', id: 1 }));
  };

  const handleLogout = () => {
    dispatch(logout());
  };

  return (
    <header>
      <h1>Store</h1>
      {isLoggedIn ? (
        <div>
          Hello, {user.name} <button onClick={handleLogout}>Logout</button>
        </div>
      ) : (
        <button onClick={handleLogin}>Login</button>
      )}
    </header>
  );
};

export default Header;
