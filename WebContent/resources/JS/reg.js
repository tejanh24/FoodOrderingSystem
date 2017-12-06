/**
 * 
 */

function checkPassword() {
	var password = document.getElementById("password").value;
	var confrmPass = document.getElementById("confrmPassword").value;
	
	if (password === confrmPass) {
		return true;
	}
	
	document.getElementById("error").innerHTML = "Password and Confirm Password do not match."
	return false;
}