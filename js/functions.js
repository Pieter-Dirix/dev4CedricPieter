// functions.js

const newList = allItems => {
    return itemsYouWant => {
        return allItems.filter(x => compare(x.name)(itemsYouWant))
    }
}

const compare = name => {
    return items => {
        return items.includes(name);
    }
}

//need object with setter to be able to set it's stock once so that it would update in all the references as well
const newItem = (name, price, stock) => {
    let item = {
        name: name,
        stock: stock,
        prevStock: stock,
        price: price,
        setStock: function (s) {
            this.prevStock = this.stock
            this.stock = s;
        }
    }
    return item
}




// stock -10 to simulate stock going down
const updateStock = object => {
    let {
        stock
    } = object;

    // Random needed to create chance if the stock went down or not
    const chance = Math.random();

    // Set new stock in main list so it would update in the other lists
    const s = (chance > 0.5) ? 10 : 0
    stock - 10 >= 0 ? object.setStock(stock -= s) : stock = s;

    return object
}



const warnStock = object => {
    return object.prevStock == object.stock && object.stock != 0 ? `${object.name}'s stock hasn't changed. There is still ${object.stock} left` :
        object.stock >= 100 ? `there is still plenty of stock from ${object.name}, ${object.stock}` :
        object.stock >= 20 ? `the stock of ${object.name} is running low, ${object.stock}` :
        object.stock >= 0 ? `there is no stock left of ${object.name}` : `Something went wrong, negative stock doesn't exist`

};

export {
    match,
    newList,
    updateStock,
    warnStock,
    compare,
    newItem
}