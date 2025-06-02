// Array
var todo = [];

// Functions
function addTask() {
  var element = document.getElementById("task").value;

  if (element.trim() === "") {
    alert("Please enter a todo.");
    return;
  }

  // ✅ Object 
  var task = {
    text: element,
    completed: false
  };

  todo.push(task); 
  renderTasks();
  document.getElementById("task").value = ""; 
}

// Functions
function renderTasks() {
  var list = document.getElementById("List");
  list.innerHTML = ""; 

  // Control Flow Statements
  for (var i = 0; i < todo.length; i++) {
    var li = document.createElement("li");

    var Span = document.createElement("span");
    Span.className = "task-text";
    Span.textContent = todo[i].text;

    Span.onclick = (function(index) {
      return function() {
        todo[index].completed = !todo[index].completed;
        renderTasks();
      };
    })(i);

    if (todo[i].completed) {
      Span.style.textDecoration = "line-through";
    }

    var del = document.createElement("span");
    del.textContent = "❌";
    del.className = "delete-btn";

    del.onclick = (function(index) {
      return function(event) {
        event.stopPropagation();
        todo.splice(index, 1);
        renderTasks();
      };
    })(i);

    li.appendChild(Span);
    li.appendChild(del);
    list.appendChild(li);
  }
}
