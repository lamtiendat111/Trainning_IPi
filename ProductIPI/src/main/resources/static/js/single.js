$(document).ready((function() {
	$('input[name="color"]').first().attr("checked", !0);
	var mamau = $('input[name="color"]:checked').val(),
		masanpham = $('input[name="masanpham"]').val();
	$.ajax({ type: "get", url: "api/single", data: { mamau: mamau, masanpham: masanpham }, dataType: "json", contentType: "application/json", success: function(data) { $("#list-single").empty(), $("#list-single").append(data[1]), $(".slides li").each((function(i) { 0 == i ? ($(this).attr("data-thumb", data[2]), $(this).find("img").attr("src", data[2])) : 2 == i ? ($(this).attr("data-thumb", data[2]), $(this).find("img").attr("src", data[2])) : 1 == i ? ($(this).attr("data-thumb", data[3]), $(this).find("img").attr("src", data[3])) : 3 == i && ($(this).attr("data-thumb", data[3]), $(this).find("img").attr("src", data[3])) })), $(".flex-control-nav img").each((function(i) { 0 == i ? $(this).attr("src", data[2]) : 1 == i && $(this).attr("src", data[3]) })) } }), $("body").on("click", 'input[name="color"]', (function() { mamau = $('input[name="color"]:checked').val(), $.ajax({ type: "get", url: "api/single", data: { mamau: mamau, masanpham: masanpham }, dataType: "json", contentType: "application/json", success: function(data) { $("#list-single").empty(), $("#list-single").append(data[1]), $(".slides li").each((function(i) { 0 == i ? ($(this).attr("data-thumb", data[2]), $(this).find("img").attr("src", data[2])) : 2 == i ? ($(this).attr("data-thumb", data[2]), $(this).find("img").attr("src", data[2])) : 1 == i ? ($(this).attr("data-thumb", data[3]), $(this).find("img").attr("src", data[3])) : 3 == i && ($(this).attr("data-thumb", data[3]), $(this).find("img").attr("src", data[3])) })), $(".flex-control-nav img").each((function(i) { 0 == i ? $(this).attr("src", data[2]) : 1 == i && $(this).attr("src", data[3]) })) } }) }))
	$("body").on("click", ".add-card", function() {
		var thiss = $(this);
		mamau = $('input[name="color"]:checked').val();
		var machitiet = thiss.attr("data-machitiet"),
			tensp = thiss.attr("data-tensp"),
			giatien = thiss.attr("data-giatien"),
			tenmau = thiss.attr("data-tenmau"),
			tensize = thiss.attr("data-tensize"),
			soluong = thiss.attr("data-soluong");
		$.ajax({
			type: 'post',
			url: 'api/Giohang',
			data: {
				mamau: mamau,
				masanpham: masanpham,
				machitiet: machitiet,
				tensp: tensp,
				giatien: giatien,
				tenmau: tenmau,
				tensize: tensize,
				soluong: soluong
			},
			success: function(data) {
				if ($("#sl-giohang").length || $("#sl-giohang1").length ) {
					$("#sl-giohang").html(data["1"]);
					$("#sl-giohang1").html(data["1"]);
				}
				else {
					if (data["1"] == 1) {
						$(".c1").html('<span id="sl-giohang" class="badge-light" style="padding: .25em .4em;border-radius: 54%;">1</span>');
						$(".c2").html('<span id="sl-giohang1" class="badge-light" style="padding: .25em .4em;border-radius: 54%;">1</span>');
					}
					else {
						alert("het hang");
					}
				}

			}
		});

	})
}));