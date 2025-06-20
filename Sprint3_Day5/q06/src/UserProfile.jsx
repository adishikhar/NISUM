import React from "react";
import "./UserCard.css";
import myImage from "./my.png";

function UserProfile({
  name = "Aditya",
  email = "aditya@gmail.com",
  avatarUrl = myImage,
  bio = "CSE Student"
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
