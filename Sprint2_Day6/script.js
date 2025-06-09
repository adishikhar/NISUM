// Symbol
const _id = Symbol('id');

// Class 
class TodoList {
  constructor() {
    this.tasks = new Map(); // Map
    this.counter = 1;
  }

  addTask(description = "New Task") {
    const id = this.counter++;
    const task = {
      [_id]: id,
      description,
      completed: false
    };
    this.tasks.set(id, task);
    return Promise.resolve(task); // Promise
  }

  toggleTask(id) {
    const task = this.tasks.get(id);
    if (task) {
      task.completed = !task.completed;
    }
  }

  removeTask(id) {
    this.tasks.delete(id);
  }

  *getTasks() {
    for (let task of this.tasks.values()) {
      yield task;
    }
  }

  getAllTasks() {
    return Array.from(this.tasks.values()); // Array.from()
  }
}


const renderTask = (task, onToggle = () => {}, onRemove = () => {}) => {
  const { description, completed, [_id]: id } = task;

  const li = document.createElement('li');
  li.innerHTML = `
    ${completed ? '✅' : '⬜'} ${description}
    <button data-id="${id}" class="toggle">Toggle</button>
    <button data-id="${id}" class="remove">Remove</button>
  `;
  li.style.textDecoration = completed ? 'line-through' : 'none';

  li.querySelector('.toggle').onclick = () => onToggle(id);
  li.querySelector('.remove').onclick = () => onRemove(id);
  return li;
};


const isSameTask = (a, b) => Object.is(a[_id], b[_id]);


const input = document.getElementById('Input');
const addBtn = document.getElementById('addBtn');
const List = document.getElementById('List');

const todoApp = new TodoList();

addBtn.addEventListener('click', async () => {
  const desc = input.value.trim();
  if (!desc) return;

  await todoApp.addTask(desc); 
  input.value = '';
  showTasks();
});

// for...of loop with generator
function showTasks() {
  List.innerHTML = '';
  for (let task of todoApp.getTasks()) {
    const li = renderTask(task, handleToggle, handleRemove);
    List.appendChild(li);
  }
}

function handleToggle(id) {
  todoApp.toggleTask(id);
  showTasks();
}

function handleRemove(id) {
  todoApp.removeTask(id);
  showTasks();
}
