<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>moving fragment welcome page</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script src="js/jrj6out.js"></script>
<script>try{Typekit.load({ async: false });}catch(e){}</script>

<style>
body {
	position: relative;
	margin: 0;
	overflow: hidden;
}

.intro-container {
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	color: white;
	text-align: center;
	margin: 0 auto;
	right: 0;
	left: 0;
}

h1 {
	font-family: 'brandon-grotesque', sans-serif;
	font-weight: bold;
	margin-top: 0px;
	margin-bottom: 0;
	font-size: 20px;
}

@media screen and (min-width: 860px) {
	h1 {
		font-size: 40px;
		line-height: 52px;
	}
}

.fancy-text {
	font-family: "adobe-garamond-pro", sans-serif;
	font-style: italic;
	letter-spacing: 1px;
	margin-bottom: 17px;
}

.button {
	position: relative;
	cursor: pointer;
	display: inline-block;
	font-family: 'brandon-grotesque', sans-serif;
	text-transform: uppercase;
	min-width: 200px;
	margin-top: 30px;
}

.button:hover .border {
	box-shadow: 0px 0px 10px 0px white;
}

.button:hover .border .left-plane, .button:hover .border .right-plane {
	transform: translateX(0%);
}

.button:hover .text {
	color: #121212;
}

.button .border {
	border: 1px solid white;
	transform: skewX(-20deg);
	height: 32px;
	border-radius: 3px;
	overflow: hidden;
	position: relative;
	transition: .10s ease-out;
}

.button .border .left-plane, .button .border .right-plane {
	position: absolute;
	background: white;
	height: 32px;
	width: 100px;
	transition: .15s ease-out;
}

.button .border .left-plane {
	left: 0;
	transform: translateX(-100%);
}

.button .border .right-plane {
	right: 0;
	transform: translateX(100%);
}

.button .text {
	position: absolute;
	left: 0;
	right: 0;
	top: 50%;
	transform: translateY(-50%);
	transition: .15s ease-out;
}

.x-mark {
	right: 10px;
	top: 10px;
	position: absolute;
	cursor: pointer;
	opacity: 0;
}

.x-mark:hover .right {
	transform: rotate(-45deg) scaleY(1.2);
}

.x-mark:hover .left {
	transform: rotate(45deg) scaleY(1.2);
}

.x-mark .container {
	position: relative;
	width: 20px;
	height: 20px;
}

.x-mark .left, .x-mark .right {
	width: 2px;
	height: 20px;
	background: white;
	position: absolute;
	border-radius: 3px;
	transition: .15s ease-out;
	margin: 0 auto;
	left: 0;
	right: 0;
}

.x-mark .right {
	transform: rotate(-45deg);
}

.x-mark .left {
	transform: rotate(45deg);
}

.sky-container {
	position: absolute;
	color: white;
	margin: 0 auto;
	right: 50%;
	bottom: 50%;
	text-align: center;
	opacity: 0;
	width:80%;
	height:80%;
	-webkit-transform:translate(50%,50%);
	-ms-transform:translate(50%,50%);
	-o-transform:translate(50%,50%);
	-moz-transform:translate(50%,50%);
	transform:translate(50%,50%);

}



.sky-container__left, .sky-container__right {
	display: inline-block;
	vertical-align: top;
	font-weight: bold;
}

.sky-container__left h2, .sky-container__right h2 {
	font-family: 'brandon-grotesque', sans-serif;
	font-size: 26px;
	line-height: 26px;
	margin: 0;
}

@media screen and (min-width: 860px) {
	.sky-container__left h2, .sky-container__right h2 {
		font-size: 72px;
		line-height: 68px;
	}
}

.sky-container__left {
	margin-right: 5px;
}

.sky-container .thirty-one {
	letter-spacing: 4px;
}

.text-right {
	text-align: right;
}

.text-left {
	text-align: left;
}

.twitter:hover a {
	transform: rotate(-45deg) scale(1.05);
}

.twitter:hover i {
	color: #21c2ff;
}

.twitter a {
	bottom: -40px;
	right: -75px;
	transform: rotate(-45deg);
}

.twitter i {
	bottom: 7px;
	right: 7px;
	color: #00ACED;
}

.social-icon a {
	position: absolute;
	background: white;
	color: white;
	box-shadow: -1px -1px 20px 0px rgba(0, 0, 0, 0.3);
	display: inline-block;
	width: 150px;
	height: 80px;
	transform-origin: 50% 50%;
	transition: .15s ease-out;
}

.social-icon i {
	position: absolute;
	pointer-events: none;
	z-index: 1000;
	transition: .15s ease-out;
}

.youtube:hover a {
	transform: rotate(45deg) scale(1.05);
}

.youtube:hover i {
	color: #ec4c44;
}

.youtube a {
	bottom: -40px;
	left: -75px;
	transform: rotate(45deg);
}

.youtube i {
	bottom: 7px;
	left: 7px;
	color: #E62117;
}
<!-for login view->

.login-contianer {
	width: 100%;
	height: 100%;
	margin-top: 150px;
	position: relative;
}
.login-container .login-box {
    width: 326px;
    margin: 0 auto;
    margin-bottom: 100px;
}
.login-container .login-box .logo-img {
    width: 250px;
    height: 250px;
    margin:40px;
    border-radius: 25%;
    overflow: hidden
}
.logo-img>img{
	width:250px;
	height:250px;
}
.login-container .login-box .am-form {
    margin-top: 68px;
}
.login-container .login-box .am-form .am-btn-secondary {
    width: 164px;
    height: 50px;
    background: transparent;
    border-color: #68c6de;
    border-radius: 0;
    display: block;
    margin: 50px auto 0;
}
.login-container .login-box .am-form .am-btn-secondary:hover{

    background: rgba(255,255,255,1);
    color: black;
}



</style>

<script src="js/prefixfree.min.js"></script>

</head>

<body>

<%    
String Sol_ID = (String)session.getAttribute("sol_id"); 
String HeadURL = (String)session.getAttribute("headimgurl");

if(Sol_ID==null || HeadURL==null)
{
	System.out.println("empty session");
	Sol_ID ="Sadden";
	HeadURL = "asset/w5.jpg";
}
%> 



	<div class="x-mark">
		<div class="container">
			<div class="left"></div>
			<div class="right"></div>
		</div>
	</div>
	

	<div class="sky-container">
		<div class="login-container">
			<div class="login-box">
				<div class="logo-img">
					<img src=<%=HeadURL %> alt>
				</div>
				<h1><%=Sol_ID %></h1>
				<form action="LoginAction.action" method="post" class="am-form">
					<input type="submit" class="am-btn-secondary" value="Login" />
				</form>
			</div>
		</div>
	</div>
	<div class="intro-container">
		<h1>Welcome to So-link Abstract system</h1>
		<div class="button shift-camera-button">
			<div class="border">
				<div class="left-plane"></div>
				<div class="right-plane"></div>
			</div>
			<div class="text">Let's start</div>
		</div>
	</div>

	<script src='js/jquery.min.js'></script>
	<script src='js/TweenMax.min.js'></script>
	<script src='js/three.min.js'></script>
	<script src="js/index.js"></script>




</body>
</html>
