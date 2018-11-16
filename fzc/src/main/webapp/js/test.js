//var date = Date.parse(new Date());
/*var date = new Date().getTime();
alert(date);*/
/*var flag = null;
alert(flag ? "1" : "0");
*/
//var str = "1001QPZmsj13630937bsTRCJ{'areaCode':'020','busiSerial':'12345','channelCode':'2001','clientIP':'','deviceModel':'','deviceSerial':'','osType':'','srcSystem':'CRM','staffCode':'110011','teminalType':'PC'}jfoiiuylkjljpohi1480650754817";
//
//var shaObj = new jsSHA("SHA-1", "TEXT");
//shaObj.update(str);
//var hash = shaObj.getHash("HEX");
//alert(hash);

var attrRuleValue = 'ab';
		  var regCanInput = new RegExp("^"+attrRuleValue);
		  var tt = 'absdad';
		  alert(regCanInput.test(tt));
		  var regCanInput1 = new RegExp("/^ab/");
		  var tt1 = 'absdad';
		  alert(regCanInput1.test(tt1));