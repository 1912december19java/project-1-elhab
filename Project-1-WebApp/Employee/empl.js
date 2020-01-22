//  window.localStorage.clear();


const form = document.getElementById('form');
const log = document.getElementById('log');

let user = document.getElementById('username');
let pass = document.getElementById('password');

console.log(1)
form.addEventListener('submit', logSubmit);

function logSubmit(event) {
    console.log(2)
    use = user.value;
    pass = pass.value;


    console.log(use);

    fetchEmpoyee(use, pass);


    event.preventDefault();
}

async function fetchEmpoyee() {

    fetch(`http://localhost:8089/WebApp-Project/employee/login?username=${use}&password=${pass}`)
        .then(getJson)
        .then(setCookies)
        .catch(console.error);


    gotoPage();
}

async function getJson(response) {
    if (response == null) {
        // log.textContent = `Form Submitted! Time stamp: ${event.timeStamp}`;
        log.textContent = "please enter a valid username and password";
    }

    return response.json();
}


async function setCookies(employee) {
    console.log(employee)

    if (employee != null) {
        let id = employee.id;
        let name = employee.name;
        let username = employee.username;
        let email = employee.email;



        window.localStorage.setItem('user', JSON.stringify(employee));



        log.textContent = `Welcom ${employee.name}`;
    } else log.textContent = "Please enter a valid username and password ";

}

// async function gotoPage() {
//     //location.replace("EmployeePage.html");
// }
document.getElementById("go").addEventListener("click", function() {
    // window.localStorage.removeItem('user');
    location.replace("EmployeePage.html");
});