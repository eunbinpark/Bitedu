function renderTable(lateBooks) {
  let tbodyData = [];
  for (const iterator of lateBooks) {
    tbodyData.push(`
                <tr>
                    <td>${iterator.bookId}</td>
                    <td>${iterator.isbn}</td>
                    <td> <img src = "${iterator.bookImg}" style="width: 8vw; min-width: 10px"> </td>
                    <td>${iterator.bookTitle}</td>
                    <td>${iterator.due}</td>
                    <td>${iterator.overdue}</td>
                    <td>${iterator.userNum}</td>
                </tr>
            `);
  }
  document.querySelector(".loans_list_table> tbody").innerHTML =
    tbodyData.join("");
}
