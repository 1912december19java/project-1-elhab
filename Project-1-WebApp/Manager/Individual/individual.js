//  window.localStorage.clear();


const form = document.getElementById('form');
const log = document.getElementById('log');

let ident = document.getElementById('ident');


console.log(1)
form.addEventListener('submit', logSubmit);

function logSubmit(event) {
    console.log(2)
    id = ident.value;



    console.log(id);

    fetchEmpoyee(id);


    event.preventDefault();
}

async function fetchEmpoyee() {

    fetch(`http://localhost:8089/WebApp-Project/manager/employee?id=${id}`)
        .then(getJson)
        .then(render)
        .catch(console.error);



}

async function getJson(response) {
    if (response == null) {
        // log.textContent = `Form Submitted! Time stamp: ${event.timeStamp}`;
        log.textContent = "please enter a valid username and password";
    }

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
        let type = document.createElement("td");
        let amount = document.createElement("td");
        let status = document.createElement("td");
        let image = document.createElement("img");


        table.appendChild(row);
        row.appendChild(type);
        row.appendChild(amount);
        row.appendChild(status);
        row.appendChild(image);


        type.innerText = convertedData.request_type;
        amount.innerText = convertedData.amount;
        status.innerText = convertedData.status;
        image.src = convertedData.receipt_image;

    }
    // }



}

document.getElementById("back").addEventListener("click", function() {
    // window.localStorage.removeItem('user');
    location.replace("../ManagerPage.html");
});