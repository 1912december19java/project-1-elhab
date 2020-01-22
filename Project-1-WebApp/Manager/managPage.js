const hemp = document.getElementById('emp');
hemp.innerHTML = "welcome to Manager page";

console.log(window.localStorage.getItem('user'));

let c = window.localStorage.getItem('user');

let employeeObject = JSON.parse(window.localStorage.getItem('user'));
let name = employeeObject.name;
let id = employeeObject.id;
let username = employeeObject.username;
hemp.innerHTML = `Welcome to the Manager home page: ${name}`;

document.getElementById("view").addEventListener("click", function() {
    document.getElementById("demo").innerHTML = `${c}`;
    location.replace("View-Information/view.html");
});
document.getElementById("log-out").addEventListener("click", function() {
    // window.localStorage.removeItem('user');
    location.replace("../index.html");
});
document.getElementById("pending").addEventListener("click", function() {

    location.replace("Pending/pending.html");
});
document.getElementById("individual").addEventListener("click", function() {

    location.replace("Individual/individual.html");
});
document.getElementById("update").addEventListener("click", function() {

    location.replace("Update/update.html");
});
document.getElementById("resolved").addEventListener("click", function() {

    location.replace("Resolved/resolved.html");
});
document.getElementById("employees").addEventListener("click", function() {

    location.replace("Employees/employees.html");
});
document.getElementById("images").addEventListener("click", function() {

    location.replace("Images/images.html");
});