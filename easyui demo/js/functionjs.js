
/**
 * Created by King on 2017/2/13.
 */
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}

function addDate(dd, dadd) {
    var a = new Date(dd)
    a = a.valueOf()
    a = a + dadd * 24 * 60 * 60 * 1000
    a = new Date(a)
    return a;
}

function TestDate() {
    // return addDate(new Date(), -1);
    return new Date();
}

function TestDateRepeat(obj) {
    // return addDate(new Date(), -1);
    return obj.replace('d','');
}

function rebateWarning(rebate) {
    var varRet = "fontnormal";
    if (rebate < 0.85) {
        varRet = "fontred";
    }

    return varRet;
}

function c(obj) {
    console.log(obj);
}

function showmenu1(){
	
}

//function showcircle(obj){
//	if(obj!='-1'){
//		var path='iframecircle'+obj+'.html';
//		$("#circleframe",parent.document.body).show();
//		$("#circleframe",parent.document.body).attr("src",path);
//	}
//	else{
//		$("#circleframe",parent.document.body).hide();
//	}
//}

//$(function () {
//  showcircle('-1');
//});

$.fn.serializeJson = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

document.write('<link href="../../css/mop-lqs.css" rel="stylesheet"/>');
document.write('<div id="loading" class="mui-backdrop" style="opacity:1;display: none;"><div class="wave"><div class = "rect1" ></div><div class = "rect2" ></div><div class = "rect3" ></div><div class = "rect4" ></div></div></div>');

function isBlank(obj){
	if(obj==null||obj==undefined){
		return '';
	}
}


//document.write('<link href="../../css/mop-lqs.css" rel="stylesheet"/>');
//document.write('<div id="loading" class="mui-backdrop" style="opacity:1;display: none;"><div class="wave"><div class = "rect1" ></div><div class = "rect2" ></div><div class = "rect3" ></div><div class = "rect4" ></div></div></div>');
//document.write('<input id="loadingcount" type="hidden" value="0"></input>');
