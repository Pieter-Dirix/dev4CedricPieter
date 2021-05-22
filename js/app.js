import {
    allProducts,
    firstList,
    secondList
} from "./data.js";
import {
    newList,
    updateStock,
    warnStock
} from "./functions.js";

const app = {
    allProducts: allProducts,
    allLists: []
}

// add new list to the app's list of lists, based on the item names specified in data.js
const list = newList(app.allProducts);
app.allLists.push(list(firstList));
app.allLists.push(list(secondList));



// simulate fetch every x seconds
setInterval(() => {
    //side effect to keep global access to the same list
    app.allProducts = app.allProducts.map(updateStock);

    const observerWarnings = app.allLists.map(x => x.map(warnStock));

    observerWarnings.map(warning => console.log(warning));
}, 5000);