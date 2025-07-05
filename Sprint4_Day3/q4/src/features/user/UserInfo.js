import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { login, logout } from './userSlice';

const UserInfo = () => {
  const { user, isLoggedIn } = useSelector(state => state.user);
  const dispatch = useDispatch();

  const mockUser = { id: 1, name: 'John Doe' };

  return (
    <div>
      {isLoggedIn ? (
        <>
          <p>Welcome, {user.name}</p>
          <button onClick={() => dispatch(logout())}>Logout</button>
        </>
      ) : (
        <button onClick={() => dispatch(login(mockUser))}>Login</button>
      )}
    </div>
  );
};

export default UserInfo;
