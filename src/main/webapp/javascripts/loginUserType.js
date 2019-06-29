$(document).ready(function() {
			$("select").change(function() {
				$(this).find("option:selected").each(function() {
					if ($(this).attr("value") == "student") {
						$(".box").not(".pwd").hide();
						$(".pwd").show();
						$(".box").not(".pwd").val("");
						
						$(".box1").not(".uname_student").hide();
						$(".uname_student").show();
						$(".box1").not(".uname_student").val("");
					} 

					else if ($(this).attr("value") == "administrative_staff") {
						$(".box").not(".pwd").hide();
						$(".pwd").show();
						$(".box").not(".pwd").val("");
						
						$(".box1").not(".uname_administrative_staff").hide();
						$(".uname_administrative_staff").show();
						$(".box1").not(".uname_administrative_staff").val("");
					}
					
					else if ($(this).attr("value") == "academic_staff") {
						$(".box").not(".pwd").hide();
						$(".pwd").show();
						$(".box").not(".pwd").val("");
						
						$(".box1").not(".uname_academic_staff").hide();
						$(".uname_academic_staff").show();
						$(".box1").not(".uname_academic_staff").val("");
					}
					
					else if ($(this).attr("value") == "admin") {
						$(".box").not(".pwd").hide();
						$(".pwd").show();
						$(".box").not(".pwd").val("");
						
						$(".box1").not(".uname_admin").hide();
						$(".uname_admin").show();
						$(".box1").not(".uname_admin").val("");
					}
					else if ($(this).attr("value") == "parent") {
						$(".box").not(".pwd").hide();
						$(".pwd").show();
						$(".box").not(".pwd").val("");
						
						$(".box1").not(".uname_parent").hide();
						$(".uname_parent").show();
						$(".box1").not(".uname_parent").val("");
					}
					else if ($(this).attr("value") == "ob_member") {
						$(".box").not(".pwd").hide();
						$(".pwd").show();
						$(".box").not(".pwd").val("");
						
						$(".box1").not(".uname_ob_member").hide();
						$(".uname_ob_member").show();
						$(".box1").not(".uname_ob_member").val("");
					}
				
					else {
						$(".box").hide();
					}
				});
		}).change();
});