const hemp = document.getElementById('emp');
hemp.innerHTML = "welcome to Employee page";

console.log(window.localStorage.getItem('user'));

let c = window.localStorage.getItem('user');

let employeeObject = JSON.parse(window.localStorage.getItem('user'));
let name = employeeObject.name;
let id = employeeObject.id;
let username = employeeObject.username;
hemp.innerHTML = `Welcome to the Employee home page: ${name}`;

document.getElementById("view").addEventListener("click", function() {
    document.getElementById("demo").innerHTML = `${c}`;
    location.replace("View-Information/view.html");
});
document.getElementById("log-out").addEventListener("click", function() {
    // window.localStorage.removeItem('user');
    location.replace("../index.html");
});
document.getElementById("pending").addEventListener("click", function() {

    location.replace("Pending-Reimbursment/pending.html");
});
document.getElementById("submit").addEventListener("click", function() {

    location.replace("Submit-Reimbursemnt/submit.html");
});
document.getElementById("update").addEventListener("click", function() {

    location.replace("Update-information/update.html");
});
document.getElementById("resolved").addEventListener("click", function() {

    location.replace("Resolved-Reimbursment/resolved.html");
});