$(document).ready(function() {
	$("#button-new").click(function() {
		$.ajax({
			type: 'get',
			url: 'api/helloWorld',
			success: function(data) {

				if (data["text"] != null) {
					$("#here").html(data["text"]);
				}
				else {
					alert("else")
				}

			}


		});
	});

	$("#button-new1").click(function() {
		var id = null;
		var hp = $("input[name='hp']").val();
		var stamina = $("input[name='stamina']").val();
		var atk = $("input[name='atk']").val();
		var def = $("input[name='def']").val();
		var agi = $("input[name='agi']").val();
		$.ajax({
			type: 'get',
			url: 'api/create',
			data: {
				id: id, hp: hp, stamina: stamina, atk: atk, def: def, agi: agi
			},
			success: function(data) {
				
				if (data["status"] == true) {
					$("#result").html("thanh cong");
					alert("thanh cong");
				}
				else {
					$("#result").html(data["status"]);
				}

			}


		});
	});
});