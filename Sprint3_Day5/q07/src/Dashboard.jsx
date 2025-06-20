import React from "react";
import UserProfile from "./UserProfile";
import Notifications from "./Notifications";

function Dashboard() {
  const userInfo = {
    name: "Aditya",
    email: "aditya@gmail.com",
    avatarUrl: "./my.png",
    bio: "CSE Student"
  };

  const msg = [
    {
      id: 1,
      message: "Facebook",
      date: "2025-06-20",
      time: "10:30 AM",
      read: true
    },
    {
      id: 2,
      message: "Youtube",
      date: "2025-06-19",
      time: "11:00 AM",
      read: false
    }
  ];

  return (
    <div>
      <UserProfile {...userInfo} />
      <Notifications items={msg} />
    </div>
  );
}

export default Dashboard;
