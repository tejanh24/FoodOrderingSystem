function validateForm()
{
	var docform  = document.food;
	var password = docform.password.value;
	var cnfpassword = docform.confpassword.value;

	if(password != cnfpassword)
		{
		alert("Please make sure Password and Confirm password are equal");
		
		document.getElementById('password').value= "";
		document.getElementById('confpassword').value= "";
		docform.password.focus();
		return false;
		
		}
}
