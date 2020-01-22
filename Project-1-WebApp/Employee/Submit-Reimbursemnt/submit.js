const form = document.getElementById('form');
const log = document.getElementById('log');

let employeeObject = JSON.parse(window.localStorage.getItem('user'));
let id = employeeObject.id;

let type = document.getElementById('type');
let amount = document.getElementById('amount');
let image = document.getElementById('image');

console.log(1)
form.addEventListener('submit', logSubmit);

function logSubmit(event) {
    console.log(2)
    console.log(id)

    t = type.value;
    a = amount.value;
    r = image.value;


    fetchEmpoyee(t, a, r);


    event.preventDefault();

}

function fetchEmpoyee() {

    fetch(`http://localhost:8089/WebApp-Project/employee/submit?type=${t}&amount=${a}&receipImage=${r}&id=${id}`)
        .then(getJson)
        .catch(console.error);

    console.log()

    log.innerHTML = "thanks for sending your new Reibesment request"

}

async function getJson(response) {
    if (response == null) {
        // log.textContent = `Form Submitted! Time stamp: ${event.timeStamp}`;
        log.textContent = "please enter a valid information";
    } else console.log(response);
    return response.json();
}
document.getElementById("back").addEventListener("click", function() {
    // window.localStorage.removeItem('user');
    location.replace("../EmployeePage.html");
});