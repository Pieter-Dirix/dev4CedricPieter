import {
    newItem
} from "./functions.js";

const allProducts = [
    newItem("Melk", 0.99, 100),
    newItem("Appels", 2.99, 20),
    newItem("Eieren", 1.99, 0),
    newItem("Bananen", 2.50, 150),
    newItem("Yoghurt", 0.50, 50),
    newItem("Peren", 0.99, 90),
    newItem("Druiven", 1.50, 30),
    newItem("Sinaasappels", 3.99, 170),
    newItem("Brood", 1.99, 120),
    newItem("Kaas", 0.40, 100),
];

const firstList = [
    "Sinaasappels", "Brood", "kaas", "Melk"
]
const secondList = [
    "Eieren", "Bananen", "Peren", "Yoghurt"
]


export {
    allProducts,
    firstList,
    secondList
};