/**
 * General Javascript for Loading and Posting to Rest Controller within index.html page
 * @Author Samuel A. French
 * 
 * @Todo Add ajax GET to pull and display existing posts (access PostController)
 * 				-ideas - probably need to design a better callback or look at how javascript is manipulating the strings that are being sent as path variables
 * @Todo Add a basic HTML form allowing users to create a new post
 * @Todo Extract form fields (no data binding yet) and send to server (using uncreated request endpoint in PostController)
 */

var NOT_FOUND_STRING = 'NOT FOUND ERROR!';
var msgTemplate = 	'<li> \
						<a href="widgets.html#"> \
							<img class="avatar" alt="avatar" src="question_mark.png"> \
						</a> \
						<div> \
							XXX_MESSAGE_XXX \
						</div> \
						<div class="date"> \
							XXX_DATE_XXX \
						</div></li>'
var postModel = new Array();

$(document).ready(function(){
	$('#app').html('Loading...');
	loadApplication();
});

function loadApplication(){
	getPost(0);
}

function getPost(postId){
	$.get("getPost/" + String(postId), function(data){
	//$.get("/getPost/" + postId, function(data){
		if(data!=NOT_FOUND_STRING){
			drawPost(data);	
			getPost(postId + 1); //make synchronous
		}
		postModel.push(data);
	});
}

function drawPost(drawString){
	$('.comments-list').append(msgTemplate.replace('XXX_MESSAGE_XXX',drawString));
	return msgTemplate.replace('XXX_MESSAGE_XXX',drawString);
}

function postPost(){
	//todo
}