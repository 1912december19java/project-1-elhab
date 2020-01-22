const form = document.getElementById('form');
const log = document.getElementById('log');

let employeeObject = JSON.parse(window.localStorage.getItem('user'));
let id = employeeObject.id;

let contact = document.getElementById('contact');
let email = document.getElementById('email');
let position = document.getElementById('position');
let password = document.getElementById('password');
let username = document.getElementById('username');
let name = document.getElementById('name');

console.log(1)
form.addEventListener('submit', logSubmit);

function logSubmit(event) {
    console.log(2)
    use = username.value;
    pass = password.value;
    n = name.value;
    c = contact.value;
    e = email.value;
    p = position.value;


    console.log(use);

    fetchEmpoyee(use, pass);


    event.preventDefault();
}

async function fetchEmpoyee() {

    fetch(`http://localhost:8089/WebApp-Project/employee/update?username=${use}&password=${pass}&name=${n}&contact=${c}&email=${e}&position=${p}&id=${id}`)
        .then(getJson)
        .catch(console.error);

    log.innerHTML = "thanks for updationg your information"

}

async function getJson(response) {
    if (response == null) {
        // log.textContent = `Form Submitted! Time stamp: ${event.timeStamp}`;
        log.textContent = "please enter a valid informatio";
    }

    return response.json();
}





document.getElementById("go").addEventListener("click", function() {

    location.replace("../EmployeePage.html");
});