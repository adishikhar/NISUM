import React from 'react';
import './StatusBadge.css';

export default function StatusBadge({ status }) {
  let className = 'badge';

  if (status === 'success') className += ' success';
  else if (status === 'error') className += ' error';
  else if (status === 'warning') className += ' warning';

  return <span className={className}>{status}</span>;
}
