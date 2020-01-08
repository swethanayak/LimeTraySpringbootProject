<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="css/styles.css">
  <link rel="stylesheet" type="text/images" href="images/express.jpg">

<script type="text/javascript">
function nameValidation()
{
var firstvalue=document.getElementById("namecheck").value;
var namePattern="^[a-zA-Z]+$";
if(!firstvalue.match(namePattern))
	document.getElementById("errorName1").innerHTML="Name should be in alphabets";
else
	document.getElementById("errorName1").innerHTML="";
}

function useridValidation()
{
var firstvalue=document.getElementById("idcheck").value;
var useridPattern=/^\w+$/;
if(!firstvalue.match(useridPattern))
document.getElementById("errorUserid").innerHTML="UserId must contain only letters, numbers and underscores!";
else
document.getElementById("errorUserid").innerHTML="";
}

function emailidValidation()
{
var firstvalue=document.getElementById("emailidcheck").value;
var emailidPattern="[A-Za-z0-9_.]+[@]{1}[a-zA-Z]+(.com|.co|.in)";
if(!firstvalue.match(emailidPattern))
document.getElementById("errorEmailid").innerHTML="Enter valid Email Id";
else
document.getElementById("errorEmailid").innerHTML="";
}

function phonenumValidation()
{
var firstvalue=document.getElementById("phonenumcheck").value;
var phonenumPattern="[6-9]{1}[0-9]{9}";
if(!firstvalue.match(phonenumPattern))
document.getElementById("errorPhonenum").innerHTML="Enter valid Phone Number";
else
document.getElementById("errorPhonenum").innerHTML="";
}

function passwordValidation2()
{
var firstvalue=document.getElementById("passcheck2").value;
var passPattern="^[a-zA-Z0-9*&^%$#@!._]{8,}$";
if(!firstvalue.match(passPattern))
document.getElementById("errorPass2").innerHTML="Password should be minimum of 8 characters";
else
document.getElementById("errorPass2").innerHTML="";
}

function confirmpassValidation()
{
var firstvalue=document.getElementById("passcheck2").value;
var secondvalue=document.getElementById("confirmpasscheck").value;
if(secondvalue == firstvalue)
document.getElementById("errorConfirm").innerHTML="";
else
document.getElementById("errorConfirm").innerHTML="Password does not match";
}

function submitForm2()
{
	var a=nameValidation();
	var b=useridValidation();
	var c=emailidValidation();
	var d=phonenumValidation();
	var e=passwordValidation2();
	var f=confirmpassValidation();
	if(a&&b&&c&&d&&e&&f)
		return (true);
	else
		return (false);
}
</script>
</head>
<body>

<div class="row-sm-12 row-lg-12" style="height:8%">
<nav>
  <ul>
   <li style="float:left;"></li>
   <li style="float:left;"><a href="Homepage.html">Lime Tray</a></li>
   <li><a href="Signin.jsp">SIGN IN</a></li> 
  </ul>
 </nav>
</div>
<div class="row-sm-12 row-lg-12" style="height:100%">
 <div id="reservation">
  <br><br><h1 style="margin-block-start:1.0em;margin-block-end: 0.0em;text-align:center;padding-bottom:10px;">REGISTRATION</h1>
  <h4 style="padding:0px;text-align:center;margin-block-start:0.0em;margin-block-end: 0.0em;text-align:center;">Waiting To Serve You</h4>
  <form method="post" action="/submitsignupform" name="form_2">
   <div align="center" style="margin-top: 5px;">
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Enter your Name        : </label> <input type="text" name="name" class="f-con" id="namecheck"onchange="nameValidation()" /><br><span id="errorName1" style="color:red;font-weight:bold;font-size:18px;font-family:sans-serif;"></span><br>
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Enter your User Id     : </label> <input type="text" name="userid" class="f-con" id="idcheck" onchange="useridValidation()" /><br><span id="errorUserid" style="color:red;font-weight:bold;font-size:18px;font-family:sans-serif;"></span><br>
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Enter   Password    : </label> <input type="password" name="password" class="f-con" id="passcheck2" onchange="passwordValidation2()" /><br><span id="errorPass2" style="color:red;font-weight:bold;font-size:18px;font-family:sans-serif;"></span><br>
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Confirm  Password  :   </label> <input type="password" name="confirmpassword" class="f-con" id="confirmpasscheck" onchange="confirmpassValidation()" /><br><span id="errorConfirm" style="color:red;font-weight:bold;font-size:18px;font-family:sans-serif;"></span><br>
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Enter your Email Id    : </label>   <input type="email" name="emailid" class="f-con" id="emailidcheck" onchange="emailidValidation()" /><br><span id="errorEmailid" style="color:red;font-weight:bold;font-size:18px;font-family:sans-serif;"></span><br>
   <label style="font-family:sans-serif;font-size:18px;letter-spacing:2px;">Enter PhoneNumber : </label> <input type="text" name="phonenumber" class="f-con" id="phonenumcheck" onchange="phonenumValidation()" /><br><span id="errorPhonenum" style="color:red;font-weight:bold;font-size:18px;font-family:sans-serif;"></span><br>
    <input type="submit" name="submit" class="f-sub" value="Register" onsubmit="return submitForm2()" />
    <footer><h6>&#169; copyrights</h6></footer>
   </div>
  </form>
 <p> ${result} </p>
 </div>
</div>
</body>
</html>