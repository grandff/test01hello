function sayHello(){
	var helloText = document.getElementById("test1");
	helloText.innerHTML = "칵스중사";
}

window.onload = function(){
	sayHello();
}