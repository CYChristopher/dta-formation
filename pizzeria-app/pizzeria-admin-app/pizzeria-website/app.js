var API_PIZZAS = "http://localhost:8080/pizzeria-admin-app/api/rest/pizzas/";

$(document).ready(function () {

    $.ajax({
        url: API_PIZZAS
    }).then(function (data) {

        var bodyLines = data.map(function (pizza) {
            var linePizza = "<tr>"
                + '<th scope="row">' + pizza.id + '</th>'
                + "<td>" + pizza.code + "</td>"
                + "<td>" + pizza.nom + "</td>"
                + "</tr>";
            return linePizza;
        });

        $('.pizzas tbody').html(bodyLines);
    });
    
});