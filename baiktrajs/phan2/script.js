const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    }
];

document.addEventListener("DOMContentLoaded", function() {
    const btn = document.getElementById('btn');
    const quizItems = document.querySelectorAll('.quiz-item');

    btn.addEventListener('click', function() {
        quizItems.forEach(item => {
            const inputs = item.querySelectorAll('input[type="radio"]');
            const randomIndex = Math.floor(Math.random() * inputs.length);
            inputs[randomIndex].checked = true;
        });
    });
});
