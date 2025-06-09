// Enum, Type, Interface
enum Priority {
  Low,
  Medium,
  High
}

interface Todo {
  id: number;
  title: string;
  completed: boolean;
  priority: Priority;
}

// DOM Element
const input = document.getElementById("taskInput") as HTMLInputElement;
const prioritySelect = document.getElementById("prioritySelect") as HTMLSelectElement;
const taskList = document.getElementById("taskList") as HTMLUListElement;


let todos: Todo[] = [];

function addTask(): void {
  const title: string = input.value;
  const priority: Priority = Number(prioritySelect.value);

  if (title.trim() === "") return;

  const newTodo: Todo = {
    id: Date.now(),
    title,
    completed: false,
    priority
  };

  todos.push(newTodo);
  input.value = "";
  renderTasks();
}

function renderTasks(): void {
  taskList.innerHTML = "";

  todos.forEach(todo => {
    const li = document.createElement("li");
    li.textContent = `${todo.title} - ${Priority[todo.priority]}`;
    taskList.appendChild(li);
  });
}
