import React from 'react';
import StatusBadge from './StatusBadge';

export default function App() {
  return (
    <div>
      <StatusBadge status="success" />
      <StatusBadge status="error" />
      <StatusBadge status="warning" />
    </div>
  );
}
