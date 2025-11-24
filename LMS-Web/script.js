let books = {};
let students = {};

function addBook() {
    let id = document.getElementById("bookId").value;
    let title = document.getElementById("bookTitle").value;
    let author = document.getElementById("bookAuthor").value;
    let qty = parseInt(document.getElementById("bookQty").value);

    if (!id || !title || !author || qty < 0) return alert("Invalid input");

    if (books[id]) return alert("Book ID already exists");

    books[id] = { id, title, author, qty };
    renderData();
    alert("Book added!");
}

function addStudent() {
    let id = document.getElementById("studentId").value;
    let name = document.getElementById("studentName").value;

    if (!id || !name) return alert("Invalid input");

    if (students[id]) return alert("Student already registered");

    students[id] = { id, name, issued: [] };
    renderData();
    alert("Student registered!");
}

function issueBook() {
    let sid = document.getElementById("issueStudentId").value;
    let bid = document.getElementById("issueBookId").value;

    if (!students[sid]) return alert("Student not found");
    if (!books[bid]) return alert("Book not found");

    if (books[bid].qty <= 0) return alert("Book out of stock");

    if (students[sid].issued.includes(bid))
        return alert("Book already issued to this student");

    books[bid].qty--;
    students[sid].issued.push(bid);

    renderData();
    alert("Book issued!");
}

function returnBook() {
    let sid = document.getElementById("returnStudentId").value;
    let bid = document.getElementById("returnBookId").value;

    if (!students[sid]) return alert("Student not found");
    if (!books[bid]) return alert("Book not found");

    let idx = students[sid].issued.indexOf(bid);
    if (idx === -1) return alert("This book was not issued to this student");

    students[sid].issued.splice(idx, 1);
    books[bid].qty++;

    renderData();
    alert("Book returned!");
}

function renderData() {
    document.getElementById("booksList").textContent =
        JSON.stringify(books, null, 2);

    document.getElementById("studentsList").textContent =
        JSON.stringify(students, null, 2);
}
