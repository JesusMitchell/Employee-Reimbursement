


let bookUrl = "http://localhost:8080/HelloServlet/manager?";
let bibUrl = "http://localhost:8080/HelloServlet/status?";
let userurl = "http://localhost:8080/HelloServlet/login?";

async function fetchUser() {
    let res = await fetch(userurl);
    let data = await res.json();

    if (res.status == 200) {
        console.log(data);
        yourBalance(data);
    } else {
        console.log("something went wrong");
    }

}


async function fetchAllYourSubmissions() {
    let res = await fetch(bibUrl);
    let data = await res.json();

    if (res.status == 200) {
        console.log(data);
        populateYours(data);
    } else {
        console.log("something went wrong");
    }

}


async function fetchAllSubmissions() {
    let res = await fetch(bookUrl);
    let data = await res.json();

    if (res.status == 200) {
        console.log(data);
        populateBooks(data);
    } else {
        console.log("something went wrong");
    }

}


function populateBooks(data) {

    let bookDiv = document.getElementById('books');
    bookDiv.innerHTML = "";
    
    let bookTable = document.createElement('table');
    bookTable.setAttribute('class', 'table')

    let tHead = document.createElement('thead');

    let tableHeaderRow = document.createElement('tr');

    let tHeaders = ['ID', 'User Email', 'Course Type', 'Date of Event','Submission Time' ,'Cost','Description','Justification'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.setAttribute('scope', 'col');
        th.innerHTML = h;
        tableHeaderRow.append(th);
    }
    tHead.append(tableHeaderRow)
    bookTable.append(tHead);

    for (let book of data) { // for (String s : strArray)
        let tr = document.createElement('tr');
        tr.id = book.id;
        
        let tdID = document.createElement('td');
        tdID.innerHTML = book.id;
        tr.append(tdID);

        let tdTitle = document.createElement('td');
        tdTitle.innerHTML = book.email;
        tr.append(tdTitle);

        let tdEvento = document.createElement('td');
        tdEvento.innerHTML = book.event;
        tr.append(tdEvento);

        let tdDateofE = document.createElement('td');
        tdDateofE.innerHTML = book.dateofe;
        tr.append(tdDateofE);

        let tdNowtime = document.createElement('td');
        tdNowtime.innerHTML = book.nowtime;
        tr.append(tdNowtime);


        let tdCosto = document.createElement('td');
        tdCosto.innerHTML = book.cost;
        tr.append(tdCosto);

        let tdDescr = document.createElement('td');
        tdDescr.innerHTML = book.description;
        tr.append(tdDescr);

        let tdJust = document.createElement('td');
        tdJust.innerHTML = book.justification;
        tr.append(tdJust);

        let tdButton = document.createElement('td');
        tdButton.innerHTML = `<button type="button" onclick="approve(event);fetchAllSubmissions()">Approve</button>`;
        tr.append(tdButton);

        let tdButton2 = document.createElement('td');
        tdButton2.innerHTML = `<button type="button" onclick="deny(event);fetchAllSubmissions()">Deny</button>`;
        tr.append(tdButton2);

        bookTable.append(tr);
    }

    bookDiv.append(bookTable);
    
}

function approve(event) {
    console.log(event);
    let bookRow = event.path[2]; // this is the <tr> element

    let book ={
        id:Number(bookRow.cells[0].innerHTML),
        status: "Approved",
        email:String(bookRow.cells[1].innerHTML),
        cost:Number(bookRow.cells[5].innerHTML),
    } 
    console.log(book);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    }

    xhr.open('PUT', bookUrl, true);
    xhr.send(JSON.stringify(book));
}

function deny(event) {
    console.log(event);
    let bookRow = event.path[2]; // this is the <tr> element

    let book ={
        id:Number(bookRow.cells[0].innerHTML),
        status: "Denied"
    } 
    console.log(book);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    }

    xhr.open('PUT', bookUrl, true);
    xhr.send(JSON.stringify(book));

}


function populateYours(data) {

    let bookDiv = document.getElementById('books');
    bookDiv.innerHTML = "";
    
    let bookTable = document.createElement('table');
    bookTable.setAttribute('class', 'table')

    let tHead = document.createElement('thead');

    let tableHeaderRow = document.createElement('tr');

    let tHeaders = ['ID', 'User Email', 'Course Type', 'Date of Event','Submission Time' ,'Cost','Status', 'Description','Justification'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.setAttribute('scope', 'col');
        th.innerHTML = h;
        tableHeaderRow.append(th);
    }
    tHead.append(tableHeaderRow)
    bookTable.append(tHead);

    for (let book of data) { // for (String s : strArray)
        let tr = document.createElement('tr');
        tr.id = book.id;
        
        let tdID = document.createElement('td');
        tdID.innerHTML = book.id;
        tr.append(tdID);

        let tdTitle = document.createElement('td');
        tdTitle.innerHTML = book.email;
        tr.append(tdTitle);

        let tdEvento = document.createElement('td');
        tdEvento.innerHTML = book.event;
        tr.append(tdEvento);

        let tdDateofE = document.createElement('td');
        tdDateofE.innerHTML = book.dateofe;
        tr.append(tdDateofE);

        let tdNowtime = document.createElement('td');
        tdNowtime.innerHTML = book.nowtime;
        tr.append(tdNowtime);

        let tdCosto = document.createElement('td');
        tdCosto.innerHTML = book.cost;
        tr.append(tdCosto);

        let tdStat = document.createElement('td');
        tdStat.innerHTML = book.status;
        tr.append(tdStat);

        let tdDescr = document.createElement('td');
        tdDescr.innerHTML = book.description;
        tr.append(tdDescr);

        let tdJust = document.createElement('td');
        tdJust.innerHTML = book.justification;
        tr.append(tdJust);

        bookTable.append(tr);
    }

    bookDiv.append(bookTable);
    
}



function yourBalance(data) {

    let r = JSON.parse(data);

    let bookDiv = document.getElementById('balance');
    bookDiv.innerHTML = "";
    
    let bookTable = document.createElement('h3');
    bookTable.setAttribute(r.allowance)

    bookDiv.append(bookTable);
    
}
