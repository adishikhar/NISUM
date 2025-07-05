// src/hoc/withAdminAccess.js
import React from 'react';
import { useUser } from '../context/UserContext';

const withAdminAccess = (WrappedComponent) => {
  return function AdminProtected(props) {
    const { user } = useUser();

    if (user.role !== 'admin') {
      return <h2>Access Denied: Admins Only</h2>;
    }

    return <WrappedComponent {...props} />;
  };
};

export default withAdminAccess;
