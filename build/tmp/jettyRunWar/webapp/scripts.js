$(document).ready(function(){

	var page = 0;
	var totalPages;
	$("#prev").click(function(){
			if (page > 0) page--;
			else page = totalPages;
		});
	$("#next").click(function(){
			if (page < totalPages) page++;
			else page = 0;
		});
	
	$(".showData").click(function ()
	{	
		page = 0;
		$(".dataLine").remove();
		var perPage = $("#perPage").val();
		if(perPage == 0 || perPage == "")
		{
			alert("Please input a per page Value");
			return;
		}
		
		var typeFilter;
		if($("#typeFilter").val()) typeFilter = $("#typeFilter").val();
		else typeFilter = "";
		
		var brandFilter;
		if($("#brandFilter").val()) brandFilter = $("#brandFilter").val();
		else brandFilter = "";
		
		var modelFilter;
		if($("#modelFilter").val()) modelFilter = $("#modelFilter").val();
		else modelFilter = "";
		
		var yearFilter;
		if($("#yearFilter").val()) yearFilter = $("#yearFilter").val();
		else yearFilter = 0;
		
		var priceMin;
		if($("#priceMin").val()) priceMin = $("#priceMin").val();
		else priceMin = -1;
		
		var priceMax;
		if($("#priceMax").val()) priceMax = $("#priceMax").val();
		else priceMax = -1;
		
		var itemsNum = 0;
		
		$.get({
			url: "http://localhost:8081/rst/api/instruments?page=" + page
			+ "&perPage=" + perPage
			+ "&typeFilter=" + typeFilter
			+ "&brandFilter=" + brandFilter
			+ "&modelFilter=" + modelFilter
			+ "&yearFilter=" + yearFilter
			+ "&priceMin=" + priceMin
			+ "&priceMax=" + priceMax,
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data["data"], function(index){
					var tr = $('<tr class="dataLine">');
					tr.append("<td> " + data["data"][index].type + 
							  "</td>\n<td>" + data["data"][index].brand + 
							  "</td>\n<td>" + data["data"][index].model + 
							  "</td>\n<td>" + data["data"][index].year +
							  "</td>\n<td>" + data["data"][index].price + "</td>");
					$("#instrumentsTable").append(tr);
					itemsNum++;
				});
				totalPages = Math.ceil(itemsNum / perPage);
			},
			error: function(jqXHR, textStatus, errorThrown){
				window.alert(jqXHR.status + " " + textStatus);
			}

		});
	});   
	
	
	$("#send").click(function(){
		var newData = JSON.stringify({
			id: parseInt($('input[name=id]').val()),
			type: $('input[name=type]').val(),
			brand: $('input[name=brand]').val(),
			model: $('input[name=model]').val(),
			year: parseInt($('input[name=year]').val()),
			price: parseInt($('input[name=price]').val())
		});
		console.log(newData);
		$.post({
			type:"POST",
			url: "http://localhost:8081/rst/api/instruments",
			dataType: "json",
			contentType:'application/json',
			data : newData,
            success :function (data) {
            	console.log("worked");
            },
            error: function(jqXHR, textStatus, errorThrown){
				window.alert(jqXHR.status + " " + textStatus);
			}
		
		});
	});
});