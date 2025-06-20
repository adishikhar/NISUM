import React from "react";
import "./Notifications.css";

function Notifications({ notifications }) {
  return (
    <div className="notifications-container">
      {notifications.map((note, index) => (
        <div className={`notification ${note.read ? "read" : "unread"}`} key={index}>
          <p>{note.message}</p>
          <span>{note.date} - {note.time}</span>
          <strong>{note.read ? "Read" : "Unread"}</strong>
        </div>
      ))}
    </div>
  );
}

export default Notifications;
