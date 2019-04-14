/**
 * 
 */
function logincheck() {
	var AjaxURL = "./LoginPage";
	$.ajax({
		type : "post",
		dataType : "json",
		url : AjaxURL,
		data : $("#loginForm").serialize(),
		success : function(result) {
			// alert(result["status"]);
			if (result["status"] == 200) {
				window.location.href=("./userinfo.html");
			} else {
				document.getElementById("info").innerText = result["message"];
			}
		},
		error : function(result) {
			alert("登录调用POST接口失败，请检查后重试！")
		}
	})
}

function loginout() {
	var AjaxURL = "./LoginOut";
	$.ajax({
		type : "post",
		dataType : "json",
		url : AjaxURL,
		success : function(result) {
			// alert(result["status"]);
			if (result["status"] == 200) {
				alert(result["message"]);
				window.location.href="index.html";
			} else {
				alert(result["message"]);
				window.location.href="index.html";
			}
		},
		error : function(result) {
			alert("注销调用POST接口失败，请检查后重试！")
		}
	})
}

function userinfo() {
	var AjaxURL = "./UserInfo";
	$.ajax({
		type : "get",
		dataType : "json",
		url : AjaxURL,
		success : function(result) {
		document.getElementById("id").innerHTML=result["uid"];
		document.getElementById("xb").innerHTML=result["sex"];
		document.getElementById("nl").innerHTML=result["age"];
		document.getElementById("cs").innerHTML=result["city"];
		document.getElementById("ah").innerHTML=result["hobby"];
		document.getElementById("xx").innerHTML=result["info"];
		},
		error : function(result) {
			alert("userinfo调用POST接口失败，请检查后重试！")
		}
	})
}