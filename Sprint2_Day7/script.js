// Enums, Types, Interfaces
var Priority;
(function (Priority) {
    Priority[Priority["Low"] = 0] = "Low";
    Priority[Priority["Medium"] = 1] = "Medium";
    Priority[Priority["High"] = 2] = "High";
})(Priority || (Priority = {}));
// DOM Elements (with typecasting)
var input = document.getElementById("taskInput");
var prioritySelect = document.getElementById("prioritySelect");
var taskList = document.getElementById("taskList");
// Storage
var todos = [];
function addTask() {
    var title = input.value;
    var priority = Number(prioritySelect.value);
    if (title.trim() === "")
        return;
    var newTodo = {
        id: Date.now(),
        title: title,
        completed: false,
        priority: priority
    };
    todos.push(newTodo);
    input.value = "";
    renderTasks();
}
function renderTasks() {
    taskList.innerHTML = "";
    todos.forEach(function (todo) {
        var li = document.createElement("li");
        li.textContent = "".concat(todo.title, " - ").concat(Priority[todo.priority]);
        taskList.appendChild(li);
    });
}
