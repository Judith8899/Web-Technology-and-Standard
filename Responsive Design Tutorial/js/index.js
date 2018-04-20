$(document).ready(function() {
	canvasInit();
	var navLabel = new Array('Responsive Design', 'HTML5 Overview', "Canvas", 'Timed Media Playback', 'Offline Storage Database', 'Browser History Management', 'Drag and Drop');
	$('#main').pageScroller({
		navigation: navLabel
	});

	$('.next').click(function(e) {

		e.preventDefault();

		pageScroller.next();

	});

	$('.prev').click(function(e) {

		e.preventDefault();

		pageScroller.prev();

	});

	$('.jumpTo').click(function(e) {

		e.preventDefault();

		pageScroller.goTo(4);

	});
	//canvas
	function canvasInit() {
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");
		ctx.fillStyle = "#FF0000";
		ctx.fillRect(0, 0, 150, 75);
	}

});
//drag
function allowDrop(ev) {
	ev.preventDefault();
}

function drag(ev) {
	ev.dataTransfer.setData("Text", ev.target.id);
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("Text");
	ev.target.appendChild(document.getElementById(data));
}
//video
var myVideo = document.getElementById("video1");

function playPause() {
	if(myVideo.paused)
		myVideo.play();
	else
		myVideo.pause();
}

function makeBig() {
	myVideo.width = 560;
}

function makeSmall() {
	myVideo.width = 320;
}

function makeNormal() {
	myVideo.width = 420;
}
