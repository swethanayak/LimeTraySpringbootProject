<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="css/styles.css">
 <link rel="stylesheet" type="text/css" href="css/sss.css">
<script>
function nameValidation()
{
var firstvalue=document.getElementById("idcheck").value;
var namePattern="^[a-z0-9A-Z]+$";
if(!firstvalue.match(namePattern))
document.getElementById("errorName").innerHTML="User Id should be in alphabets and numbers";
else
document.getElementById("errorName").innerHTML="";
}

function passwordValidation()
{
var firstvalue=document.getElementById("passcheck").value;
var passPattern="^[a-zA-Z0-9*&^%$#@!._]{7,}$";
if(!firstvalue.match(passPattern))
document.getElementById("errorPass").innerHTML="Password should be minimum of 8 characters";
else
document.getElementById("errorPass").innerHTML="";
}


function submitValidation()
{
	var a = nameValidation();
	var b = passwordValidation();
	if(a && b)
		return true;
	else
		return false;
	
}
</script>
</head>
<body>
<div class="row-sm-12 row-lg-12" style="height:8%">
<nav>
  <ul>
   <li style="float:left;"></li>
   <li style="float:left;"><a href="/homepage">Lime Tray</a></li>
   <li><a href="/signupform">SIGN UP</a></li>
  </ul>
 </nav>
</div>
<div class="row-sm-12 row-lg-12" style="height:100%">
 <div id="reservation">
  <br><br><h1 style="margin-block-start:0.0em;margin-block-end: 0.0em;text-align:center;padding:90px;padding-bottom:10px;">SIGN IN</h1><br>

<form  id="f" action="/signinformsubmit" method="post" name="form">
 <div align="center" style="margin-top: 10px;">
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Enter your User  ID : </label> <input type="text" name="userid" id="idcheck" class="f-con" onchange="nameValidation()"/><br><span id="errorName" style="color:red;font-weight:bolder;font-size:20px;font-family:sans-serif;align="right;"></span><br><br>
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Enter your Password : </label> <input type="password" name="password" id="passcheck" class="f-con" onchange="passwordValidation()"/><br><span id="errorPass" style="color:red;font-weight:bolder;font-size:20px;font-family:sans-serif;align="right;"></span><br>${test1}<br><br>  
   <input type="submit" class="f-sub" value="SIGN IN"  onsubmit="return submitValidation()" /><br><br><br><br>
   <footer><h6>&#169; copyrights</h6></footer>
   </div>
</form>
</div>
</div>

</body>
</html>