var Util = {
		longToDateTime: function(data) {
			if (data != null ) {
                
                return  moment(data).format('YYYY-MM-DD HH:mm:ss');
            }else{
            	 return null;
            }
		},
		
		toYuan: function(num) {
			if ( typeof num !== "number" || isNaN( num ) ) return null;
		    return ( num / 100 ).toFixed( 2 );
		},
		toWanYuan: function(num) {
			if ( typeof num !== "number" || isNaN( num ) ) return null;
		    return ( num / 10000 ).toFixed( 2 );
		},
		
		getMiniPic: function(url) {
			if(url){
				return url.replace('_normal', '_mini');				
			}else{
				return url;
			}
			
		},
		
		isEmpty: function(str){
			return !str || str == '';
		},
		
		emptyDefault: function(str, defVal){
			return (!str || str == '') ? defVal : str;
		}
}