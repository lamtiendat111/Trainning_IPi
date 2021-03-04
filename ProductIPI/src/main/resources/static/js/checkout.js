$(".value-plus").on("click", (function() {
	var machitiet = $(this).attr("data-machitiet"),
		tensp = $(this).attr("data-tensp"),
		giatien = $(this).attr("data-giatien"),
		tenmau = $(this).attr("data-tenmau"),
		tensize = $(this).attr("data-tensize"),
		soluong = $(this).attr("data-soluong");
	mamau = $(this).attr("data-mamau");
	masanpham = $(this).attr("data-masp");
	var divUpd = $(this).parent().find(".value"),
		newVal = parseInt(divUpd.text(), 10) + 1;
	divUpd.text(newVal);

	$.ajax({
		type: 'post',
		url: 'api/EditGiohang',
		data: {
			mamau: mamau,
			masanpham: masanpham,
			machitiet: machitiet,
			tensp: tensp,
			giatien: giatien,
			tenmau: tenmau,
			tensize: tensize,
			soluong: newVal
		},
		success: function(data) {

			if (data["1"] <= 0) {
				alert("hết hàng");
			} else {
				if (newVal != data["1"]) {
					divUpd.text(data["1"]);
					alert("Hiện tại còn" + data["1"] + " sản phẩm");
				}
				$("#total-card").html(data["2"]);
			}
		}
	});
})), $(".value-minus").on("click", (function() {
	var machitiet = $(this).attr("data-machitiet"),
		tensp = $(this).attr("data-tensp"),
		giatien = $(this).attr("data-giatien"),
		tenmau = $(this).attr("data-tenmau"),
		tensize = $(this).attr("data-tensize"),
		soluong = $(this).attr("data-soluong");
	mamau = $(this).attr("data-mamau");
	masanpham = $(this).attr("data-masp");
	var divUpd = $(this).parent().find(".value"),
		newVal = parseInt(divUpd.text(), 10) - 1;
	newVal >= 1 && divUpd.text(newVal);
	if (newVal > 0) {
		$.ajax({
			type: 'post',
			url: 'api/EditGiohang',
			data: {
				mamau: mamau,
				masanpham: masanpham,
				machitiet: machitiet,
				tensp: tensp,
				giatien: giatien,
				tenmau: tenmau,
				tensize: tensize,
				soluong: newVal
			},
			success: function(data) {

				if (data["1"] <= 0) {
					alert("hết hàng");
				} else {
					if (newVal != data["1"]) {
						divUpd.text(data["1"]);
						alert("Hiện tại còn" + data["1"] + " sản phẩm");
					}
					$("#total-card").html(data["2"]);
				}
			}
		});
	}

})), $(document).ready((function(c) {
	var length = $(".rem").length;
	for (let index = 1; index <= length; index++) $(".close" + index).on("click", (function(c) { $(".rem" + index).fadeOut("slow ", (function(c) { $(".rem" + index).remove() })) }))
	$(".button-delete").on("click", (function() {
		var machitiet = $(this).attr("data-machitiet");

		$.ajax({
			type: 'post',
			url: 'api/DeleteGiohang',
			data: {
				machitiet: machitiet
			},
			success: function(data) {
				var sl = parseInt($(".c1").text());
				if (data["1"] == true) {
					if (sl == 1) {
			
						$(".c1").html(" ");
						$(".c2").html(" ");
					} else {
						$("#sl-giohang").html(sl - 1);
						$("#sl-giohang1").html(sl - 1);
					}
					$("#total-card").html(data["2"]);
				}



			}
		});
	}))
}));