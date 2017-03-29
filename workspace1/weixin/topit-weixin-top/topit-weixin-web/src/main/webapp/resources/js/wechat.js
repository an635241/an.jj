/**
 * 微信公用js
 */



function wechatMessage(message){
	$.messager.show({
		title:'消息提醒',
		msg:message,
		timeout:3000,
		showType:'fade'
	});
}

;(function($, undefined) {
	"use strict";

	var pluginName = 'scojs_message';

	//modify zzd 2014-01-21 add function
	//目的是在提示信息隐藏之后，执行客户端的回调
	//modify zzd 2014-02-11 add delay
	//接受用户指定时间
	$[pluginName] = function(message, type,fn,delay) {
		clearTimeout($[pluginName].timeout);
		var $selector = $('#' + $[pluginName].options.id);
		if (!$selector.length) {
			$selector = $('<div/>', {id: $[pluginName].options.id}).appendTo($[pluginName].options.appendTo);
		}
		if ($[pluginName].options.animate) {
			$selector.addClass('page_mess_animate');
		} else {
			$selector.removeClass('page_mess_animate');
		}
		$selector.html(message);
		if (type === undefined || type == $[pluginName].TYPE_ERROR) {
			$selector.removeClass($[pluginName].options.okClass).addClass($[pluginName].options.errClass);
		} else if (type == $[pluginName].TYPE_OK) {
			$selector.removeClass($[pluginName].options.errClass).addClass($[pluginName].options.okClass);
		}
		$selector.slideDown('fast', function() {
			//判断有没有传进来时间
			var time = $[pluginName].options.delay;
			if(delay && /\d+/.test(delay)){
				time = delay;
			}
			$[pluginName].timeout = setTimeout(function() { $selector.slideUp('fast',
			function(){
				if (fn) {
					if(typeof (eval(fn)) === "function"){
						fn();
					}else {
						throw new Error(fn + "不是一个正确的Function!");
					}
				} 
			}); }, time);
		});
		
	};

	$.extend($[pluginName], {
		options: {
			 id: 'page_message'
			,okClass: 'page_mess_ok'
			,errClass: 'page_mess_error'
			,animate: true
			,delay: 5000
			,appendTo: 'body'	// where should the modal be appended to (default to document.body). Added for unit tests, not really needed in real life.
		},

		TYPE_ERROR: 1,
		TYPE_OK: 2
	});
})(jQuery);
