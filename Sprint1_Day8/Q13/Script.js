// your api is not working , so I used my fake API

async function fetchTodo() {
  const url = "https://jsonplaceholder.typicode.com/todos/1";

  try {
    const response = await fetch(url);

  

    const data = await response.json();
    console.log("Fetched Details:");
    console.log(`User ID: ${data.userId}`);
    console.log(`ID: ${data.id}`);
    console.log(`Title: ${data.title}`);
    console.log(`Completed: ${data.completed}`);
  } catch (error) {
    console.error("Failed:", error.message);
  }
}

fetchTodo();
