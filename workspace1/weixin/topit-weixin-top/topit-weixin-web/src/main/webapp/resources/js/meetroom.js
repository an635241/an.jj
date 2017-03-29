// 对Date的扩展，将 Date 转化为指定格式的String 
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
// 例子： 
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) 
{ //author: meizz 
  var o = { 
    "M+" : this.getMonth()+1,                 //月份 
    "d+" : this.getDate(),                    //日 
    "h+" : this.getHours(),                   //小时 
    "m+" : this.getMinutes(),                 //分 
    "s+" : this.getSeconds(),                 //秒 
    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
    "S"  : this.getMilliseconds()             //毫秒 
  }; 
  if(/(y+)/.test(fmt)) 
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  for(var k in o) 
    if(new RegExp("("+ k +")").test(fmt)) 
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
  return fmt; 
}

/**       
 * 对Date的扩展，将 Date 转化为指定格式的String       
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符       
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)       
 * eg:       
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423       
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04       
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04       
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04       
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18       
 */          
Date.prototype.pattern=function(fmt) {           
    var o = {           
    "M+" : this.getMonth()+1, //月份           
    "d+" : this.getDate(), //日           
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
    "H+" : this.getHours(), //小时           
    "m+" : this.getMinutes(), //分           
    "s+" : this.getSeconds(), //秒           
    "q+" : Math.floor((this.getMonth()+3)/3), //季度           
    "S" : this.getMilliseconds() //毫秒           
    };           
    var week = {           
    "0" : "日",           
    "1" : "一",           
    "2" : "二",           
    "3" : "三",           
    "4" : "四",           
    "5" : "五",           
    "6" : "六"          
    };           
    if(/(y+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
    }           
    if(/(E+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "星期" : "周") : "")+week[this.getDay()+""]);           
    }           
    for(var k in o){           
        if(new RegExp("("+ k +")").test(fmt)){           
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
        }           
    }           
    return fmt;           
}       

//运用modal替代alert();
//可以自定义cancel按钮的文本 在第二个参数设置此文本
//可以自定义任意个按钮 在参数后面追加按钮id和按钮显示的文本
//例子:modalAlert(string) modalAlert(string,cancel) modalAlert(string,id,text) modalAlert(string,cancel,id,text)
function modalAlert(){
//	console.log(arguments);
//	console.log(arguments.length);
	if(arguments.length % 2 === 1){//奇数个参数  不设置cancel文本
		var string = arguments[0] ? arguments[0] : "";
		var cancelBtn =  "返回";
		$("#alertModal .modal-body").html(string);
		$("#alertModal .modal-footer").html("");
		for(var i = 1; i<=arguments.length - 1; i+=2){
			if(arguments.length === 1) {break;}
			if(arguments[i+1] != ""){$("#alertModal .modal-footer").append("<button type='button' class='btn btn-primary' id='" + arguments[i] +"' >" + arguments[i+1] + "</button>" );}
		}
		$("#alertModal .modal-footer").append("<button type='button' class='btn btn-default' data-dismiss='modal'>" + cancelBtn + "</button>");
	}else if(arguments.length % 2 === 0){//偶数个参数  设置cancel文本
		var string = arguments[0] ? arguments[0] : "";
		var cancelBtn = arguments[1] ? arguments[1] : "返回";
		$("#alertModal .modal-body").html(string);
		$("#alertModal .modal-footer").html("");
		for(var i = 2; i<=arguments.length - 1; i+=2){
			if(arguments.length === 2) {break;}
			if(arguments[i+1] != ""){$("#alertModal .modal-footer").append("<button type='button' class='btn btn-primary' id='" + arguments[i] +"' >" + arguments[i+1] + "</button>" );}
		}
		$("#alertModal .modal-footer").append("<button type='button' class='btn btn-default' data-dismiss='modal'>" + cancelBtn + "</button>");
	}
	
	$("#alertModal").modal({keyboard: false});
}

