// functions.js
const match = (e1, e2) => e1.name == e2.name; //returns bool

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

//needed an object to be able to set it's stock once so that it would update in all the references as well
const newItem = (name, price, stock) => {
    let item = {
        name: name,
        stock: stock,
        price: price,
        setStock: function (s) {
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
    return () => {
        stock - 10 >= 0 ? stock -= 10 : stock = 0;
        object.setStock(stock);
        return object
    }
}


const warnStock = object => {
    return object.stock >= 100 ? `there is still plenty of stock from (${object.name}), ${object.stock}` :
        object.stock >= 20 ? `the stock of (${object.name}) is running low, ${object.stock}` :
        object.stock >= 0 ? `${object.stock}, there is no stock left of ${object.name})` : `does not exist`

};

export {
    match,
    newList,
    updateStock,
    warnStock,
    compare,
    newItem
}