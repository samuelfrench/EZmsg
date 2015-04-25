/**
 * General Javascript for Loading and Posting to Rest Controller within index.html page
 * @Author Samuel A. French
 * 
 * @Todo Add ajax GET to pull and display existing posts (access PostController)
 * @Todo Add a basic HTML form allowing users to create a new post
 * @Todo Extract form fields (no data binding yet) and send to server (using uncreated request endpoint in PostController)
 */

var postModel = new Array();

$(document).ready(function(){
	$('#app').html('Loading...');
	loadApplication();
});

function loadApplication(){
	for(var x = 0; x < 10; x++){
		postModel[x] = "This is sample posting no. " + x; 
	}
	
	for(var y = 0; y < postModel.length; y++){
		$('#app').append('<span id="post_no_' + y + '" class="post">P: ' + postModel[y] + '</span>');
		
		//remove soon
		$('#app').append("<br />")
	}
}