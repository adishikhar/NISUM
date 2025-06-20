import  { useState, useEffect } from 'react';
import './Counter.css';

const Counter = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {},[count]);

  const Increment = () => setCount(count + 1);
  const Decrement = () => {
    if (count > 0) {
      setCount(count - 1);
    }
  };
  const Reset = () => setCount(0);

  return (
    <div>
      <h1>Count: {count}</h1>
      <button onClick={Increment}>Increment</button>
      <button onClick={Decrement} disabled={count === 0}>Decrement</button>
      <button onClick={Reset}>Reset</button>
    </div>
  );
};

export default Counter;
