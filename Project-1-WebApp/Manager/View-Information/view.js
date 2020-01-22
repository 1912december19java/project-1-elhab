let employeeObject = JSON.parse(window.localStorage.getItem('user'));
let name = employeeObject.name;
let email = employeeObject.email_adress;
let department = employeeObject.department;
let salary = employeeObject.salary;

let contact = employeeObject.contact_number;
let username = employeeObject.username;

const c = document.getElementById('c');
const n = document.getElementById('n');
const e = document.getElementById('e');
const s = document.getElementById('s');
const r = document.getElementById('r');
const u = document.getElementById('u');
const h = document.getElementById('h');
const p = document.getElementById('p');
h.innerHTML = `Welcome ${name}`;
c.textContent = ` ${contact}`;
e.textContent = `${email}`;
p.textContent = `${department}`;
r.textContent = `${username}`;
s.textContent = `${salary}`;

document.getElementById("back").addEventListener("click", function() {
    // window.localStorage.removeItem('user');
    location.replace("../ManagerPage.html");
});

console.log(employeeObject)
console.log(name)