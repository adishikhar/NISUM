
class Car {
  constructor(brand, speed) {
    this.brand = brand;
    this.speed = speed;
  }

  accelerate() {
    this.speed += 10;
    console.log(this.brand + " accelerated by" + this.speed );
  }
}


const myCar = new Car("BMW", 50);


myCar.accelerate(); 
myCar.accelerate();
