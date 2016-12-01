$(document).ready(function(){

	var page = 0;
	var totalPages;
	$("#prev").click(function(
			if (page > 0)
				{
					page--;
				}
			));
	$("#prev").click(function(
			if (page < totalPages)
				{
					page++;
				}
			));
	
	$("#button").click(function ()
	{	
		var perPage = $("#perPage").val();
		if(perPage == 0 || perPage == "")
		{
			alert("Please input a per page Value");
			return;
		}
		
		var typeFilter;
		if($("#typeFilter").val() === 'undefined') typeFilter = "";
		else typeFilter = $("typeFilter").val();
		
		var brandFilter;
		if($("#brandFilter").val() === 'undefined') brandFilter = "";
		else brandFilter = $("brandFilter").val();
		
		var modelFilter;
		if($("#modelFilter").val() === 'undefined') modelFilter = "";
		else modelFilter = $("modelFilter").val();
		
		var yearFilter;
		if($("#yearFilter").val() === 'undefined') yearFilter = 0;
		else yearFilter = $("yearFilter").val();
		
		var priceMin;
		if($("#priceMin").val() === 'undefined') priceMin = -1;
		else priceMin = $("priceMin").val();
		
		var priceMax;
		if($("#priceMax").val() === 'undefined') priceMax = -1;
		else priceMax = $("priceMax").val();
		
		var itemsNum = 0;
		
		$.get({
			url: "http://localhost:8081/rst/api/instruments?page=" + page
			+ "&perPage=" + perPage
			+ "&typeFilter=" + typeFilter
			+ "&brandFilter=" + brandFilter
			+ "&modelFilter=" + modelFilter
			+ "&yearFilter=" + yearFilter
			+ "&priceMin=" + priceMin
			+ "priceMax=" + priceMax,
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append("<td> " + data[index].type + 
							  "</td>\n<td>" + data[index].brand + 
							  "</td>\n<td>" + data[index].model + 
							  "</td>\<td>" +  data[index].year +
							  "</td>\<td>" + data[index].price + "</td>");
					$("#instrumentsTable").append(tr);
					itemsNum++;
				});
				var pagination = $('<div id="pages">');
				for(var i = 0; i < Math.ceil(itemsNum / perPage); i++){
					pagination.append('<button id="'+i+'">' + i + '</button>');
				}
				pagination.append('</div>');
				$("#pageButtons").append(pagination);
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