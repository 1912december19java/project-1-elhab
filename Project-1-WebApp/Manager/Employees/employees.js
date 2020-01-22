let employeeObject = JSON.parse(window.localStorage.getItem('user'));

let id = employeeObject.id;
let name = employeeObject.name;
let d = document.getElementById('h');
h.innerHTML = `Name: ${name}`;
console.log(employeeObject);
console.log(id);
fetch(`http://localhost:8089/WebApp-Project/manager/employees?id=${id}`)
    .then(getJson)
    .then(render)
    .catch(console.error);


function getJson(response) {

    return response.json();
}


function render(json) {
    // let g = JSON.parse(json);

    console.log(json);
    let y = json;
    let d = document.getElementById('pending');

    var table = document.getElementById("table");

    for (let i = 0; i < y.length; i++) {
        //For looping Through the Array
        let convertedData = json[i];
        let row = document.createElement("tr");
        let name = document.createElement("td");
        let position = document.createElement("td");
        let email = document.createElement("td");
        let contact = document.createElement("td");

        let salary = document.createElement("td");
        let rating = document.createElement("td");

        table.appendChild(row);
        row.appendChild(name);
        row.appendChild(position);
        row.appendChild(email);
        row.appendChild(contact);

        row.appendChild(salary);
        row.appendChild(rating);


        name.innerText = convertedData.name;
        position.innerText = convertedData.position;
        email.innerText = convertedData.email;
        contact.innerHTML = convertedData.contact;

        salary.innerText = convertedData.salary;
        rating.innerHTML = convertedData.rating;

    }
    // }



}

document.getElementById("back").addEventListener("click", function() {
    // window.localStorage.removeItem('user');
    location.replace("../ManagerPage.html");
});