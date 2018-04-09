$(document).ready(function() {
	//Iinitialize the timer
	laydate.render({
		elem: '#datePiker',
		type: 'datetime',
                long: 'en',
		value: new Date()
                //format:'MM/dd/yyyy HH:mm:ss'
	});
	//add "click" event
	$("#Add").click(function() {
		var memorandumText = $("#memorandumText").val();
		var dateVal = $("#datePiker").val()
		if(memorandumText == '') {
			alert('Please add your memo')
			return;
		}
		//auto date
		var myDate = new Date();
		//year
		var year = myDate.getFullYear();
		//month
		var month = myDate.getMonth() + 1;
		//day
		var date = myDate.getDate();
		var h = myDate.getHours(); //hours
		var m = myDate.getMinutes(); //minutes
		var s = myDate.getSeconds();
		var now = recoupZero(month) + "/" + recoupZero(date) + "/" +year+" " + recoupZero(h) + ':' + recoupZero(m) + ":" + recoupZero(s);
		var tr = "<tr><td>" + memorandumText + "</td><td>" + dateVal + "</td><td>" + now + "</td><td><button class='btn btn-primary' onclick='deleteTr($(this))'>DELETE</button></td></tr>"
		$("#content").append(tr)
	})

})
///delete
function deleteTr(dom) {
	dom.parent().parent().remove();
}
///+0
function recoupZero(s) {
	return s < 10 ? '0' + s : s;
}