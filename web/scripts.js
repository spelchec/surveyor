(function () {
	function wrap(elt) {
		var $div = document.createElement("DIV");
		$div.setAttribute("style", "position: relative;")
		elt.after($div)
		$div.appendChild(elt);
	}
	function textareaMonitor(e) {
//		console.log(this.value + " > " + this.getAttribute("limit"))
		var limit = this.getAttribute("limit") - this.value.length;
		if (limit < 0) {
			this.setAttribute("style", "color: red;")
		} else {
			this.setAttribute("style", "")
		}
		var $txt = document.createTextNode(limit + " characters remaining.");
		var $textLimit = document.getElementsByClassName("text-limit");
		for (i = 0; i < $textLimit.length; i++) {
			console.log("i="+i);
			$textLimit[i].removeChild($textLimit[i].childNodes[0]);
			$textLimit[i].appendChild($txt);
		}
	}
	var textareas = document.getElementsByTagName("textarea");
	for (var k = 0; k < textareas.length; k++) {
		console.log("found");
		if (!textareas[k].getAttribute("limit")) {
			textareas[k].setAttribute("limit", "100");
		}
		var limit = textareas[k].getAttribute("limit");
		console.log("limit: "+limit);
		var $charCount = document.createElement("span");
		$charCount.setAttribute("class", "text-limit")
		var $txt = document.createTextNode(limit + " characters remaining.");
		$charCount.appendChild($txt);
		$area = textareas[k];
		wrap($area);
		textareas[k].after($charCount);
		textareas[k].addEventListener("keypress", textareaMonitor);
		textareas[k].addEventListener("mouseover", textareaMonitor);
		textareas[k].addEventListener("keyup", textareaMonitor);
	}
})();

(function addNextButtons() {
	function createButton(label, cls, type) {
		var input = document.createElement("input");
		if (!!cls) {
			input.setAttribute("class", cls);
		}
		if (!!type) {
			input.setAttribute("type", type);
		} else {
			input.setAttribute("type", "button");
		}
		input.setAttribute("value", label);
		return input;
	}
	var questions = document.getElementsByTagName("section");	
	for (k = 0; k < questions.length; k++) {
		var input = createButton("Next >>", "next");
		if (k == questions.length - 1) {
			input = createButton("Submit", "next", "submit");
		}
		input.addEventListener("click", function (e) {
			this.parentNode.setAttribute("class", "hide");
			this.parentNode.nextSibling.nextSibling.setAttribute("class", "");
		})
		questions[k].appendChild(input);
	}
})();

(function orderQuestions() {
	var questions = document.getElementsByTagName("section");
	for (k = 1; k < questions.length; k++) {
		questions[k].setAttribute("class", "hide");
	}
	//alert(''+questions.length)
}())