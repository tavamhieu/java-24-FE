function getCountElement(arr) {
    let countObj = {};
    
    
    arr.forEach(element => {
        if (countObj[element]) {
            countObj[element]++;
        } else {
            countObj[element] = 1;
        }
    });
    
    return countObj;
}


const result = getCountElement(["one", "two", "three", "one", "one", "three"]);
console.log(result);
