const jugadores = ["JORDAN", "BRYANT", "JAMES", "CURRY", "DURANT", "SHAQ", "BIRD", "MAGIC", "OLAJUWON", "MALONE"];
let selectedJugador = "";
let attempts = [];
const maxAttempts = 6;

document.addEventListener("DOMContentLoaded", () => {
    initGame();
    document.getElementById("new-game-button").addEventListener("click", initGame);
    document.addEventListener("keydown", handleKeydown);
});

function initGame() {
    selectedJugador = jugadores[Math.floor(Math.random() * jugadores.length)];
    attempts = [];
    renderBoard();
    renderKeyboard();
}

function renderBoard() {
    const board = document.getElementById("game-board");
    board.innerHTML = "";
    for (let i = 0; i < maxAttempts; i++) {
        for (let j = 0; j < selectedJugador.length; j++) {
            const cell = document.createElement("div");
            cell.classList.add("cell");
            if (attempts[i] && attempts[i][j]) {
                cell.textContent = attempts[i][j].letter;
                cell.classList.add(attempts[i][j].status);
            }
            board.appendChild(cell);
        }
    }
}

function renderKeyboard() {
    const keyboardContainer = document.getElementById("keyboard-container");
    keyboardContainer.innerHTML = "";
    const keys = "QWERTYUIOPASDFGHJKLZXCVBNM".split("");
    keys.forEach(key => {
        const keyElement = document.createElement("div");
        keyElement.textContent = key;
        keyElement.classList.add("key");
        keyElement.addEventListener("click", () => handleKeyPress(key));
        keyboardContainer.appendChild(keyElement);
    });
}

function handleKeyPress(key) {
    if (attempts.length < maxAttempts && (attempts.length === 0 || attempts[attempts.length - 1].length === selectedJugador.length)) {
        attempts.push([]);
    }
    if (attempts[attempts.length - 1].length < selectedJugador.length) {
        attempts[attempts.length - 1].push({ letter: key, status: "absent" });
        updateAttemptStatus();
        renderBoard();
    }
}

function handleKeydown(event) {
    const key = event.key.toUpperCase();
    if (/^[A-Z]$/.test(key)) {
        handleKeyPress(key);
    }
}

function updateAttemptStatus() {
    const currentAttempt = attempts[attempts.length - 1];
    const letterCount = {};
    for (let i = 0; i < selectedJugador.length; i++) {
        letterCount[selectedJugador[i]] = (letterCount[selectedJugador[i]] || 0) + 1;
    }
    for (let i = 0; i < currentAttempt.length; i++) {
        if (selectedJugador[i] === currentAttempt[i].letter) {
            currentAttempt[i].status = "correct";
            letterCount[currentAttempt[i].letter]--;
        }
    }
    for (let i = 0; i < currentAttempt.length; i++) {
        if (currentAttempt[i].status !== "correct" && selectedJugador.includes(currentAttempt[i].letter) && letterCount[currentAttempt[i].letter] > 0) {
            currentAttempt[i].status = "present";
            letterCount[currentAttempt[i].letter]--;
        }
    }
}
