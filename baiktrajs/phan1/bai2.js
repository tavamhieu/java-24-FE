
function filterUsers(users) {
    return users.filter(user => user.age > 25 && user.isStatus);
}


function sortUsersByAge(users) {
    return users.slice().sort((a, b) => a.age - b.age);
}

const users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
];


console.log("Các user có age > 25 và isStatus = true:");
console.log(filterUsers(users));

console.log("\nCác user được sắp xếp theo age tăng dần:");
console.log(sortUsersByAge(users));
