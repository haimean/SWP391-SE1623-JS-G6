

function sortTable(el) {
    let thead = document.getElementsByTagName("thead")[0];
    let th = [...thead.getElementsByTagName("th")];
    let index = th.indexOf(el);
    let rows, switching, i, x, y, shouldSwitch, sort, switchcount = 0;
    let table = document.querySelector(".table");
    switching = true;
    sort = "asc";
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("td")[index];
            y = rows[i + 1].getElementsByTagName("td")[index];
            if (sort == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (sort == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount++;
        } else {
            if (switchcount == 0 && sort == "asc") {
                sort = "desc";
                switching = true;
            }
        }
    }
}