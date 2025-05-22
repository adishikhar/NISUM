const weatherData = {
  India: {
    city: "India",
    date: "Monday, 20 May 2025",
    temp: "32°C",
    condition: "Sunny",
    icon: "sunny.png",
    humidity: "45%",
    wind: "12 km/h",
    pressure: "1012 hPa"
  },
  Russia: {
    city: "Russia",
    date: "Monday, 20 May 2025",
    temp: "35°C",
    condition: "Hot",
    icon: "hto.jpg",
    humidity: "30%",
    wind: "15 km/h",
    pressure: "1008 hPa"
  },
  "USA": {
    city: "USA",
    date: "Monday, 20 May 2025",
    temp: "28°C",
    condition: "Rainy",
    icon: "rainy.jpg",
    humidity: "70%",
    wind: "10 km/h",
    pressure: "1015 hPa"
  },
  Dubai: {
    city: "Dubai",
    date: "Monday, 20 May 2025",
    temp: "33°C",
    condition: "Cloudy",
    icon: "thunder.jpg",
    humidity: "60%",
    wind: "18 km/h",
    pressure: "1010 hPa"
  }
};

document.querySelector("input").addEventListener("keydown", function (e) {
  if (e.key === "Enter") {
    const value = e.target.value.trim().toLowerCase();
    let data = null;
    for (let city in weatherData) {
      if (city.toLowerCase() === value) {
        data = weatherData[city];
        break;
      }
    }

    if (data) {
      document.querySelector(".city-info h2").textContent = data.city;
      document.querySelector(".city-info p").textContent = data.date;
      document.querySelector(".weather-info h1").textContent = data.temp;
      document.querySelector(".weather-info p").textContent = data.condition;
      document.querySelector(".weather-info img").src = data.icon;
      document.querySelector(".detail-box:nth-child(1) strong").textContent = data.humidity;
      document.querySelector(".detail-box:nth-child(2) strong").textContent = data.wind;
      document.querySelector(".detail-box:nth-child(3) strong").textContent = data.pressure;
    } else {
      alert("City not found. Please type India, Russia, USA, Dubai");
    }
  }
});
