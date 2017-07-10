$(document).ready(function () {
    getData();
})

function getData() {
    $.ajax({
        url: "/getStuSubmit",
        type: 'POST',
        dataType: 'json',
        success: function (json) {
            var stuSubmit = json.stuSubmit;
            document.getElementById("suggest").innerHTML = stuSubmit.suggest;
            document.getElementById("stage").innerHTML = stuSubmit.stage;
            document.getElementById("message").innerHTML = stuSubmit.message;
        }
    });
}