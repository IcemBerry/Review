$(document).ready(function () {
    getData();
});

function getData() {
    $.ajax({
        url: "/stuDownload",
        type: 'POST',
        dataType: 'json',
        success: function (json) {
            var stuDownload = json.stuDownload;
            var item1 = document.getElementById("item1");
            var item2 = document.getElementById("item2");
            var item3 = document.getElementById("item3");

            var baseUrl = "/download?deliveryName=";

            var a1 = document.createElement("a");
            var node1 = document.createTextNode("下载");
            a1.appendChild(node1);

            var a2 = document.createElement("a");
            var node2 = document.createTextNode("下载");
            a2.appendChild(node2);

            var a3 = document.createElement("a");
            var node3 = document.createTextNode("下载");
            a3.appendChild(node3);

            if (stuDownload.title1 != null){
                document.getElementById("title1").innerHTML = stuDownload.title1;
                document.getElementById("date1").innerHTML = stuDownload.date1;
                var comUrl1 = baseUrl + stuDownload.path1;
                a1.setAttribute("href",comUrl1);
                document.getElementById("path1").appendChild(a1);
            }else{
                item1.parentNode.removeChild(item1);
            }
            if(stuDownload.title2 != null){
                document.getElementById("title2").innerHTML = stuDownload.title2;
                document.getElementById("date2").innerHTML = stuDownload.date2;
                var comUrl2 = baseUrl + stuDownload.path2;
                a2.setAttribute("href",comUrl2);
                document.getElementById("path2").appendChild(a2);
            }else{
                item2.parentNode.removeChild(item2);
            }
            if(stuDownload.title3 != null){
                document.getElementById("title3").innerHTML = stuDownload.title3;
                document.getElementById("date3").innerHTML = stuDownload.date3;
                var comUrl3 = baseUrl + stuDownload.path3;
                a3.setAttribute("href",comUrl3);
                document.getElementById("path3").appendChild(a3);
            }else{
                item3.parentNode.removeChild(item3);
            }
        }
    });
}