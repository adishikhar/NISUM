import React, { useReducer, useState } from "react";

const initialState = [];

function reducer(state, action) {
  switch (action.type) {
    case "ADD":
      return [...state, { id: Date.now(), text: action.text, completed: false }];
    case "DELETE":
      return state.filter(todo => todo.id !== action.id);
    case "TOGGLE":
      return state.map(todo =>
        todo.id === action.id ? { ...todo, completed: !todo.completed } : todo
      );
    default:
      return state;
  }
}

function App() {
  const [todos, dispatch] = useReducer(reducer, initialState);
  const [text, setText] = useState("");

  const handleAdd = () => {
    if (text.trim() !== "") {
      dispatch({ type: "ADD", text });
      setText("");
    }
  };

  const completedCount = todos.filter(todo => todo.completed).length;
  const pendingCount = todos.length - completedCount;

  return (
    <div>
      <h2>Todo List</h2>
      <input
        value={text}
        onChange={e => setText(e.target.value)}
        placeholder="Enter todo"
      />
      <button onClick={handleAdd}>Add</button>

      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            <span
              style={{ textDecoration: todo.completed ? "line-through" : "none", cursor: "pointer" }}
              onClick={() => dispatch({ type: "TOGGLE", id: todo.id })}
            >
              {todo.text}
            </span>
            <button onClick={() => dispatch({ type: "DELETE", id: todo.id })}>
              Delete
            </button>
          </li>
        ))}
      </ul>

      <p>Completed: {completedCount}</p>
      <p>Pending: {pendingCount}</p>
    </div>
  );
}

export default App;
