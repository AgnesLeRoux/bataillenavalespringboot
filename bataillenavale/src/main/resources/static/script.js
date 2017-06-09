function Message(value)
{
	this.value = value;
}

function handleSendButton()
{
	//var elt = document.getElementById("nicknameId");
    var nickname = document.getElementById("nicknameId").value;
    var msg = new Message(nickname);
 
    var xmlhttp = new XMLHttpRequest();
    var url= 'http://localhost:8080/welcome/login';
    
    xmlhttp.open('POST',url, true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    console.log(JSON.stringify(msg));
    xmlhttp.send(JSON.stringify(msg));
    
}