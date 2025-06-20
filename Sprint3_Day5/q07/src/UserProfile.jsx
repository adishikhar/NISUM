import React from "react";
import "./UserCard.css";

function UserProfile({
  name = "User",
  email = "user@example.com",
  avatarUrl = "https://via.placeholder.com/100",
  bio = "No bio available"
}) {
  return (
    <div className="user-card">
      <img src={avatarUrl} alt="Avatar" className="avatar" />
      <div className="userinfo">
        <h2>{name}</h2>
        <p>{email}</p>
        <p>{bio}</p>
      </div>
    </div>
  );
}

export default UserProfile;
