const numbers = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];


const Evensquares = numbers
  .filter(num => num % 2 === 0)
  .map(num => num * num);

console.log(Evensquares); 
