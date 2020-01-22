let employeeObject = JSON.parse(window.localStorage.getItem('user'));

let id = employeeObject.id;
let name = employeeObject.name;
let d = document.getElementById('h');
h.innerHTML = `Name: ${name}`;
console.log(employeeObject);
console.log(id);
fetch(`http://localhost:8089/WebApp-Project/manager/resolved?id=${id}`)
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