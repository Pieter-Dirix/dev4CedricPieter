//index.js
const items = [
    { name: "Melk", description: "Melk van een koe",  price: 0.99, stock: 100 },
    { name: "Appel", description: "Jonagolden, deze keer wel bijgevuld",  price: 2.99, stock: 20},
    { name: "Ei", description: "De beste van Chiquita", price: 1.99, stock: 0 }
];


const warnStock = function(object){
    if(object.stock >= 100){
      alert(`${object.stock}, the stock of (${object.name}) is full`) ;  
    } else if(object.stock >= 10){
      return `${object.stock}, the stock of (${object.name}) is low`;  
    } else if(object.stock >= 0){
      return `${object.stock}, the stock of (${object.name}) is empty`; 
    }
};
  

const stockControl = items.map(warnStock);


const totalPrice = items.map(obj => obj.price).reduce((acc, next) => acc + next);
console.log(stockControl);
console.log(Math.round(totalPrice*100)/100);