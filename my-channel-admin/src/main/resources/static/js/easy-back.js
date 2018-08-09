/*-------------------------------------
easyback js
-------------------------------------*/

/*-----------------easyback--------------------*/
var easyback = {};

easyback.prefix = 'easyback_';

easyback.getCurrentPrefixPath = function(){
	return easyback.prefix + location.pathname;
};

easyback.getPrefixPath = function(path){
	return easyback.prefix + path;
};

easyback.store = function(){
	localStorage.setItem(easyback.getCurrentPrefixPath(), location.pathname + location.search);
};

easyback.remove = function() {
	localStorage.removeItem(easyback.getCurrentPrefixPath());
}

easyback.get = function() {
	return localStorage.getItem(easyback.getCurrentPrefixPath());
}

easyback.back = function(path) {
	location.href = localStorage.getItem(easyback.getPrefixPath(path));
}



window.easyback = easyback;

