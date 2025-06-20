import React from "react";
import UserProfile from "./UserProfile";
import Notifications from "./Notifications";

function App() {
  const notes = [
    { message: "Facebook", date: "2025/06/20", time: "10:30 AM", read: true },
    { message: "Youtube", date: "2025/06/20", time: "11:00 AM", read: false }
  ];

  return (
    <>
      <UserProfile />
      <Notifications notifications={notes} />
    </>
  );
}

export default App;
