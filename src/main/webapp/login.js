function unfunction(){
	var a=document.getElementById("username").value;
	if(a==""){
		console.log("没有输入用户名！");
	}else{
		console.log("你输入的用户名为：" + a);
	}
}

function pwfunction(){
	var b=document.getElementById("password").value;
	if(b==""){
		console.log("没有输入密码！");
	}else{
		console.log("你输入的密码为：" + b);
	}
}

function loginfunction(){
	var a=document.getElementById("username").value;
	var b=document.getElementById("password").value;
	var c=document.getElementsByClassName("remember-me_text").checked
	if (a==""&&a==""){
		alert("请输入用户名和密码！");
	}else if (a==""&&b!=""){
		alert("请输入用户名！");
		}else if(a!=""&&b==""){
			alert("请输入密码！");
		}else if(a=="lizheng"&&b=="123456"&&c){
			alert("恭喜你：lizheng，登录成功！");
		}else{
			alert("用户名错误或密码错误！");
		}
}