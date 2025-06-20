import React from "react";
import "./Notifications.css";

function Notifications({ items }) {
  return (
    <div className="notification-list">
      {items.map((note) => (
        <div
          key={note.id}
          className={`notification-item ${note.read ? "read" : "unread"}`}
        >
          <p>{note.message}</p>
          <small>{note.date} – {note.time}</small>
          <span className="status">{note.read ? "Read" : "Unread"}</span>
        </div>
      ))}
    </div>
  );
}

export default Notifications;
