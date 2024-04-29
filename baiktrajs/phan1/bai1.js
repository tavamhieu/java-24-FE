function getStringHasMaxLength(strings) {
   
    let maxLength = 0;
    for (let str of strings) {
        if (str.length > maxLength) {
            maxLength = str.length;
        }
    }
    
    
    let result = strings.filter(str => str.length === maxLength);
    
    return result;
}

// Ví dụ sử dụng:
console.log(getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd'])); // Output: ['aba', 'vcd']
