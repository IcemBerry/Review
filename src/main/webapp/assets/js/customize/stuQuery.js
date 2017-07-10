$(document).ready(function () {
    getData();
})

function getData() {
    $.ajax({
        url: "/getStuQuery",
        type: 'POST',
        dataType: 'json',
        success: function (json) {
            var error = json.error;
            var score = json.score;
            var teacher = json.teacher;
            var opinionBuilder = document.getElementById("opinionBuilder");
            if (error){
                if (opinionBuilder != null)
                    opinionBuilder.parentNode.removeChild(opinionBuilder);
                document.getElementById("score").innerHTML = "暂无成绩";
            }else{
                document.getElementById("score").innerHTML = score.scoreFraction;
                document.getElementById("topic").innerHTML = score.scoreTopic;
                document.getElementById("opinion").innerHTML = score.scoreOpinion;
                document.getElementById("teacher").innerHTML = teacher.userName;
            }
        }
    });
}