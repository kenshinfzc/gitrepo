<html>
<script type="text/javascript" src="jquery.js"></script>
<body>
<h2>CookieTest!</h2>
<input type="button" id="stepTwo" value="stepTwo" onclick="goStepTwo(this);"/>
</body>
<script type="text/javascript">
function goStepTwo(obj){
	$.ajax({
		url : "/cookieStepTwo",
		success : function(){
			
		}
	})	
}
</script>
</html>
