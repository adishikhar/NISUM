const userList = document.getElementById("userList");
const citySelect = document.getElementById("citySelect");
let allUsers = [];

// Fetch user data
fetch("https://jsonplaceholder.typicode.com/users")
  .then(response => response.json())
  .then(users => {
    allUsers = users;
    populateCities(users);
    displayUsers(users);
  })


function populateCities(users) {
  const cities = [...new Set(users.map(user => user.address.city))];
  cities.forEach(city => {
    const option = document.createElement("option");
    option.value = city;
    option.textContent = city;
    citySelect.appendChild(option);
  });
}


function displayUsers(users) {
  userList.innerHTML = "";
  users.forEach(user => {
    const li = document.createElement("li");
    li.textContent = `${user.name} - ${user.email} (${user.address.city})`;
    userList.appendChild(li);
  });
}


citySelect.addEventListener("change", () => {
  const selectedCity = citySelect.value;
  if (selectedCity === "all") {
    displayUsers(allUsers);
  } else {
    const filtered = allUsers.filter(user => user.address.city === selectedCity);
    displayUsers(filtered);
  }
});
