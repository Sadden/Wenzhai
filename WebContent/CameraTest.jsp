<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test camera </title>
</head>
<body>
<video id="video" autoplay=""style='width:640px;height:480px'></video>
<button id='picture'>PICTURE</button> 
<canvas id="canvas" width="640" height="480"></canvas>
<script type="text/javascript">
var video = document.getElementById("video");
var context = canvas.getContext("2d")
var errocb = function () {
                          console.log('sth wrong!');
                     }



</script>

</body>
</html>