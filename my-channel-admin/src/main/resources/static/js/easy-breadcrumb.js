/*-------------------------------------
easybreadcrumb js
-------------------------------------*/

/*-----------------easybreadcrumb--------------------*/
var easybreadcrumb = {};

easybreadcrumb.tag = 'easybreadcrumb';



easybreadcrumb.push = function(obj){
	easybreadcrumb.save(easybreadcrumb.getStack().push(obj));
};

easybreadcrumb.pop = function() {
	var stack = easybreadcrumb.getStack();
	if(stack.length <= 0){
		return;
	}
	stack = stack.splice(0,stack.length - 1);
	easybreadcrumb.save(stack);
}

easybreadcrumb.getStack = function() {
	return JSON.parse(localStorage.getItem(easybreadcrumb.tag));;
}

easybreadcrumb.clear = function(path) {
	easybreadcrumb.init();
}

easybreadcrumb.save = function(obj){
	localStorage.setItem(easybreadcrumb.tag, JSON.stringify(obj || []));
}

easybreadcrumb.init = function(){
	easybreadcrumb.save([]);
}

easybreadcrumb.init();

window.easybreadcrumb = easybreadcrumb;

