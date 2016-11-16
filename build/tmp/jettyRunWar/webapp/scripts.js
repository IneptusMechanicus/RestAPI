$(document).ready(function() {
	$("#button").click(function (){
		$.get({
			url: "http://localhost:8081/rst/api/instruments",
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append("<td> " + data[index].instrument + " " + data[index].brand + " " + data[index].model + "</td>");
					$("#usersTable").append(tr);
				});
			}

		});
	});    
	$("#dataSubmit").on("submit", function(){
		var formdata = $(this).serializeObject;
		$.post({
			url: "http://localhost:8081/rst/api/instruments",
			dataType: "json",
			data : formdata,
            success :function (data) {
                alert("it worked");
            }
		});
	});
});