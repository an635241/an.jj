/*!
 * Project BI
 * Author he.ff (RTX 3113)
 * Email he.ff@wonhigh.cn
 * Date 2015/02/05
 * Description EasyUI for BI v1.0.0 (http://www.wonhigh.cn/)
 */
//扩展Date对象
Date.prototype.format = function (format)
{
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    };
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length == 1 ? o[k] :
                ("00" + o[k]).substr(("" + o[k]).length));
    return format;
};

//ie console.time()
if (window.console && typeof(window.console.time) == "undefined") {
    console.time = function(name, reset) {
        if (!name) {
            return;
        }
        var time = new Date().getTime();
        if (!console.timeCounters) {
            console.timeCounters = {}
        };
        var key = "KEY" + name.toString();
        if (!reset && console.timeCounters[key]) {
            return;
        }
        console.timeCounters[key] = time;
    };

    console.timeEnd = function(name) {
        var time = new Date().getTime();
        if (!console.timeCounters) {
            return;
        }
        var key = "KEY" + name.toString();
        var timeCounter = console.timeCounters[key];
        if (timeCounter) {
            var diff = time - timeCounter;
            var label = name + ": " + diff + "ms";
            console.info(label);
            delete console.timeCounters[key];
        }
        return diff;
    };
}

//DOM加载完成后开始触发
$(function(){
    //文本框操作
    $("input.ipt").mouseover(function() {
        $(this).addClass('ipt-focus');
    }).mouseout(function() {
        $(this).removeClass('ipt-focus');
    });

    //清空查询表单
    $('#clearBtn').live('click',function(){
        var myForm=$(this).closest('form');
        myForm.form('clear');
    });

    //自动执行页面中定义的parsePage方法
    if(typeof parsePage=="function"){
        parsePage();
    }

    //屏蔽backspace键退出页面
    $(document).hotKeys({type:'keydown',key:'backspace',fn:function(e){
        if($(e.target).is("input")) return;
        e.preventDefault();e.stopPropagation();
    }});

});

//公用方法
var onlyOpenTitle = "系统桌面";
function resetDetailViewHeight(_h) {
    if (parent.$('#ddv-' + parent.editRowIndex)[0]) {
        parent.$('#ddv-' + parent.editRowIndex).height(_h);
        parent.tbgrid.datagrid('fixDetailRowHeight', parent.editRowIndex);
    }
}

// 添加
function addDataGridCommon(dataGridId){
	 var $dg = $("#"+dataGridId+"");
	 $dg.datagrid('appendRow', {});
     var rows = $dg.datagrid('getRows');
     $dg.datagrid('beginEdit', rows.length - 1);
     $dg.datagrid('selectRow', rows.length - 1);
}

// 删除
function removeDataGridCommon(dataGridId){
    var $dg = $("#"+dataGridId+"");
    var row = $dg.datagrid('getSelected');
    if (row){
        var rowIndex = $dg.datagrid('getRowIndex', row);
        $dg.datagrid('deleteRow', rowIndex);
        if((rowIndex-1)>=0){
            $dg.datagrid('selectRow', rowIndex-1);
        }
    }
}

// 删除所有行
function deleteAllGridCommon(dataGridId){
    /*var $dg = $("#"+dataGridId+"");
    var rows = $dg.datagrid('getRows');
    if(rows){
      for ( var i = 0; i < rows.length; i++) {
        var rowIndex = $dg.datagrid('getRowIndex', rows[i]);
       $dg.datagrid('deleteRow', rowIndex);
      }
    }*/
    $('#'+datagridId).datagrid('loadData', { total: 0, rows: [] });
}

//获得当前行号   一般用 var rowIndex=getRowIndex(this);
function getRowIndex(target) {
    var tr = $(target).closest('tr.datagrid-row');
    return parseInt(tr.attr('datagrid-row-index'));
 }  

// 结束编辑 
function endEditCommon(dataGridId){
    var $dg = $("#"+dataGridId+"");
    var rows = $dg.datagrid('getRows');
    for ( var i = 0; i < rows.length; i++) {
        $dg.datagrid('endEdit', i);
    }
}

// 获取该表格有变动的记录 inserted\deleted\updated
function getChangeTableDataCommon(dataGridId){
	 var $dg = $("#"+dataGridId+"");
	 endEditCommon(dataGridId);
	 var effectRow = new Object();
	 if($dg.datagrid('getChanges').length) {
		  var inserted = $dg.datagrid('getChanges', "inserted");
         var deleted = $dg.datagrid('getChanges', "deleted");
         var updated = $dg.datagrid('getChanges', "updated");
         
         
         if (inserted.length) {
             effectRow["inserted"] = JSON.stringify(inserted);
         }
         
         if (deleted.length) {
             effectRow["deleted"] = JSON.stringify(deleted);
         }
         
         if (updated.length) {
             effectRow["updated"] = JSON.stringify(updated);
         }
	 }
	
	 return effectRow;
}

// 全选或者全不选   checkstatus 1--全选   0--全不选
function selectCheckAllRowCommon(dataGridId,checkstatus){
     var rows = $('#'+dataGridId).datagrid('getRows');
     for ( var i = 0; i < rows.length; i++) {
         if(checkstatus==0){
            $('#'+dataGridId).datagrid('uncheckRow', i);
         }else{
            $('#'+dataGridId).datagrid('checkRow', i);
         } 
     }
}

// 返回前一个页面
function returnTab(tabID,title){
   $('#'+tabID).tabs('select',title);
}

//发达ajax请求
function ajaxRequest(url,reqParam,callback){
	$.ajax({
		  type: 'POST',
		  url: url,
		  data: reqParam,
		  cache: true,
		  success: callback
	});
}

//发达ajax请求
function ajaxRequestAsync(url,reqParam,callback){
	$.ajax({
		  type: 'POST',
		  url: url,
		  data: reqParam,
		  cache: true,
		  async: false,
		  success: callback
	});
}

//截取时间格式yyyy-MM-dd
function formatDateStr(value) {
    if (value == null || value == '') {
        return '';
    }
    if(value.length > 10){
        return value.substring(0,10);
    }
    return value;
}  

function checkPowerJS(powerValue,index){
    var flag=false;
    var  temp =parseInt(Math.pow(2,index));
      var result = powerValue&temp;
        if(result== temp){
             flag=true;
        }
    return flag;
}

(function($) {
    dgSelector = function(opts){
        var _url=opts.href || '';
        var _title=opts.title;
        var _save=opts.onSave || null;
        var _w=opts.width || null;
        var _h=opts.height || null;
        var iframe=opts.isFrame;
        if(typeof iframe=="undefined"){
            iframe=true;
        }
        top.dgSelectorOpts=opts;

        var _isHotkey = false;

        ygDialog({
            title:_title,
            href:_url,
            width:_w,
            height:_h,
            isFrame:iframe,
            modal:true,
            showMask: true,
            onSave: _save,
            onLoad:function(win, content){
                var tb=content.tbgrid;
                var _this=$(this);

                if(tb==null){
                    tb = opts.tbGrid || $('#dialog_SearchDataGrid');
                }

                if(opts.queryUrl!=null){
                    var searchBtn=$('#dgSelectorSearchBtn');
                    var clearBtn=$('#dgSelectorClearBtn');
                    var confirmBtn=$('#dgSelectorConfirmBtn');

                    searchBtn.click(function(){
                        var targetForm=$('#dialog_SarchForm');
                        tb.datagrid('options').queryParams = targetForm.form('getData');
                        tb.datagrid('options').url = opts.queryUrl;
                        tb.datagrid('load');
                    });

                    clearBtn.click(function(){
                        $('#dialog_SarchForm').form('clear');
                    });

                    if(confirmBtn){
                        confirmBtn.click(function(){
                            var rowsData=tb.datagrid('getSelections');
                            if(rowsData.length<=0){
                                showWarn('请选择后再操作！');
                                return false;
                            }
                            if(typeof top.dgSelectorOpts.fn=="function"){
                                top.dgSelectorOpts.fn(rowsData);
                            }
                            win.close();
                        });
                    }
                }

                if(opts.autoQuery){
                    setTimeout(function(){
                        searchBtn.trigger('click');
                    },100);
                }

                tb.datagrid({
                    onDblClickRow:function(rowIndex, rowData){
                        if(typeof top.dgSelectorOpts.fn=="function"){
                            top.dgSelectorOpts.fn(rowData,rowIndex);
                            try{
                                if($(top.iptSearchInputObj)[0]&&$(top.iptSearchInputObj).hasClass('easyui-validatebox')){
                                    $(top.iptSearchInputObj).validatebox('validate');
                                }
                            }catch(e){}
                        }
                        win.close();
                    },
                    onLoadSuccess:function(){
                        $('input[name=optsel]',_this.contents()).on('click',function(){
                            var _idx=$('input[name=optsel]',_this.contents()).index(this);
                            var row=tb.datagrid('getRows')[_idx];
                            if(typeof top.dgSelectorOpts.fn=="function"){
                                _fn = top.dgSelectorOpts.fn;
                                top.dgSelectorOpts.fn(row);
                                if($(top.iptSearchInputObj)[0] &&$(top.iptSearchInputObj).hasClass('easyui-validatebox')){
                                    $(top.iptSearchInputObj).validatebox('validate');
                                }
                            }
                            win.close();
                        });

                        /**
                         * 配合hotkeys插件使用，支持键盘操作
                         */
                        if(typeof opts.hkid == "string"){
                            yg_hotKeys.setOptions({
                                targetId: 'dialog_SearchDataGrid',
                                editable: false,
                                eventKey: false,
                                enterKey: true,
                                winTarget:win,
                                fn:       top.dgSelectorOpts.fn,
                                editIndex:0
                            });
                            _isHotkey = true;
                        }
                    }
                });
            },
            onClose: function(){
                if(_isHotkey){
                    var dg = $("#"+opts.hkid);
                    yg_hotKeys.setOptions({
                        targetId: opts.hkid,
                        editable: true,
                        eventKey: true,
                        enterKey: false,
                        fn:       null,
                        editIndex:dg.datagrid('getRowIndex',dg.datagrid('getSelected'))
                    });
                    _isHotkey = false;
                }
            }
        });
        return false;
    }
})(jQuery);

//弹出窗口
(function($) {
    ygDialog = function(opts) {
        var win;
        opts = opts || {};
        var target;
        var winOpts = $.extend({},
        {
            isFrame: false,
            locate: 'document',
            data: undefined,
            width: 'auto',
            height: 'auto',
            cache: false,
            autoDestroy: true,
            minimizable: false,
            maximizable: false,
            collapsible: false,
            resizable: false,
            modal: true,
            enableSaveButton: true,
            enableCloseButton: true,
            saveButtonText: '保存',
            saveButtonIconCls: 'icon-save',
            closeButtonText: '取消',
            closeButtonIconCls: 'icon-cancel',
            closed: false,
            loadMsg: $.fn.datagrid.defaults.loadMsg,
            showMask: true,
            onSave: null
        },
        opts);

        function getTop(w, options) {
            var _doc;
            try {
                _doc = w['top'].document;
                _doc.getElementsByTagName;
            } catch(e) {
                return w;
            }

            if (options.locate == 'document' || _doc.getElementsByTagName('frameset').length > 0) {
                return w;
            }

            return w['top'];
        }

        function setWindowSize(w, options) {
            var _top = getTop(w, options);
            var wHeight = $(_top).height(),
            wWidth = $(_top).width();
            if (options.locate == 'top' || options.locate == 'document') {
                if (options.height == 'auto') {
                    options.height = wHeight * 0.8
                }

                if (options.width == 'auto') {
                    options.width = wWidth * 0.8
                }
            } else {
                var locate = /^#/.test(options.locate) ? options.locate: '#' + options.locate;
                if (options.height == 'auto') {
                    options.height = $(locate).height() * 0.8
                }

                if (options.width == 'auto') {
                    options.width = $(locate).width() * 0.8
                }
            }
        }

        var iframe = null;
        var buttons = [];
        if (winOpts.isFrame && !winOpts.target) {
            iframe = $('<iframe>').attr('height', '100%').attr('width', '100%').attr('marginheight', 0).attr('marginwidth', 0).attr('frameborder', 0);
            iframe.css({
                'visibility': 'hidden'
            });
            iframe.attr('src', winOpts.href);
            delete winOpts.content;
        }

        var selfRefrence = {
			openWin:function(){
				return iframe[0].contentWindow;
			},
            getData: function(name) {
                return winOpts.data ? winOpts.data[name] : null;
            },
            close: function() {
                target.panel('close');
            }
        };

        var _top = getTop(window, winOpts);

        var warpHandler = function(handler) {
            if (typeof handler == 'function') {
                return function() {
                    handler(selfRefrence);
                };
            }
            if (typeof handler == 'string' && winOpts.isFrame) {
                return function() {
                    iframe[0].contentWindow[handler](selfRefrence);
                }
            }

            if (typeof handler == 'string') {
                return function() {
                    eval(_top[handler])(selfRefrence);
                }
            }
        }

        setWindowSize(window, winOpts);

        //包装toolbar中各对象的handler
        if (winOpts.toolbar && $.isArray(winOpts.toolbar)) {
            $.each(winOpts.toolbar,
            function(i, button) {
                button.handler = warpHandler(button.handler);
            });
        }

        //包装buttons中各对象的handler
        if (winOpts.buttons && $.isArray(winOpts.buttons)) {
            $.each(winOpts.buttons,
            function(i, button) {
                button.handler = warpHandler(button.handler);
            });
        }

        var _onClose = winOpts.onClose;
        winOpts.onClose = function() {
			if (winOpts.target) {
                 $('.validatebox-invalid', winOpts.target).removeClass('validatebox-invalid');
             }
			
            if ($.isFunction(_onClose)) {
                _onClose.apply(this, arguments);
            }
            if (winOpts.autoDestroy&&!winOpts.target) {
                $(this).dialog("destroy");
            }
        };
		
		//兼容 检查是否有取消按钮
		var checkButtons=function(t){
			var r=false;
			if(winOpts.buttons){
				for(var i=0;i<winOpts.buttons.length;i++){
					if(winOpts.buttons[i].text==t){
						r=true;
						break;
					}
				}
			}
			return r;
		}
		

        if (winOpts.enableSaveButton == true && winOpts.onSave) {
            var btnSave = {
                text: winOpts.saveButtonText,
                iconCls: winOpts.saveButtonIconCls,
                handler: function(dia) {
                    return winOpts.onSave(selfRefrence);
                }
            };
            buttons.push(btnSave);
        }
		

        if (winOpts.enableCloseButton == true &&!checkButtons(winOpts.closeButtonText)) {
            var btnClose = {
                text: winOpts.closeButtonText,
                iconCls: winOpts.closeButtonIconCls,
                handler: function(dia) {
                    dia.dialog("close");
                }
            };
            buttons.push(btnClose);
        }

        if (!$.util.likeArray(winOpts.buttons) || $.util.isString(winOpts.buttons)) {
            winOpts.buttons = [];
        }
        $.array.merge(winOpts.buttons, buttons);

        $.each(winOpts.buttons,
        function() {
            var handler = this.handler;
            if ($.isFunction(handler)) {
                this.handler = function() {
                    handler.call(target, target);
                };
            }
        });
        if (!winOpts.buttons.length) {
            winOpts.buttons = null;
        }

        /*
		if ($.isArray(winOpts.buttons)&&winOpts.buttons.length>0) {
            $.each(winOpts.buttons,
            function(i, button) {
                button.handler = warpHandler(button.handler);
            });
        }
		*/

        var onLoadCallback = winOpts.onLoad;
        winOpts.onLoad = function() {
            onLoadCallback && onLoadCallback.call(this, selfRefrence, _top);

        }

        if (winOpts.locate == 'top' || winOpts.locate == 'document') {
            if (winOpts.isFrame && iframe && !winOpts.target) {
                winOpts.href = '';
                if (winOpts.showMask) {
                    winOpts.onBeforeOpen = function() {
                        var body = $(this);
                        $.mask({
                            target: body
                        });
                    }
                }
                target = _top.$('<div>').css({
                    'overflow': 'hidden'
                }).append(iframe).dialog(winOpts);
                function iframeLoaded() {
                    onLoadCallback && onLoadCallback.call(iframe, selfRefrence, iframe[0].contentWindow);
                    _top.$('.dialog-button').show();
                    target.panel('body').children("div.datagrid-mask-msg").remove();
                    target.panel('body').children("div.datagrid-mask").remove();
                    iframe.css({
                        'visibility': 'visible'
                    });
                }

                iframe.bind('load',
                function() {
                    iframeLoaded();
                });

            } else if (winOpts.target) {
                target = winOpts.target;
                target.dialog(winOpts);
                _top.$('.dialog-button').show();
                target.panel('body').children("div.datagrid-mask-msg").remove();
                target.panel('body').children("div.datagrid-mask").remove();
            } else {
                target = _top.$('<div>').dialog(winOpts);
                setTimeout(function() {
                    _top.$('.dialog-button').show();
                },
                2);
            }
        } else {
            var locate = /^#/.test(winOpts.locate) ? winOpts.locate: '#' + winOpts.locate;
            target = $('<div>').appendTo(locate).dialog($.extend({},
            winOpts, {
                inline: true
            }));

        }

        return target;

    }
})(jQuery);
//成功操作提示
function showSuc(msg) {
    top.$.messager.show({
        title: '提示',
        msg: msg,
        timeout: 1000,
        position:'bottomRight',
        showType: 'slide'
    });
}

//提示信息
function showInfo(msg) {
    top.$.messager.alert('提示', msg, 'info');
}

//警告操作提示
function showWarn(msg) {
    top.$.messager.alert('提示', msg, 'warning');
}

//错误操作提示
function showError(msg) {
    top.$.messager.alert('提示', msg, 'error');
}

//显示进度条
function showProcess(show,msg){
    if(!show){
        top.$.messager.progress('close');
        return;
    }
    top.$.messager.progress({
        msg:msg,
        text:''
    });
}

//确认选择框
function showConfirm(msg,fn){
    top.$.messager.confirm(msg,function(r){
        if(r){
            if(typeof fn=="function"){
                fn();
            }
        }
    });
}

// 公用弹出框
function alert(msg,type){
    //info-0,warning-1,error-2,question-3 ,success-4
    var typeStr="info";
    if(type==1){
        typeStr='warning';
    }else if(type==2){
        typeStr='error';
    }else if(type==3){
        typeStr='question';
    }else if(type==4){
        typeStr='success';
    }else{
        typeStr='info';
    }
    $.messager.alert('提示',msg,typeStr);
}

//显示高级搜索
function popSearch(obj,target) {
    if ($(obj).hasClass("search-down-arr")) {
        $(target).layout('show', 'north');
        $(obj).attr("class", "search-up-arr");
    } else {
        $(target).layout('hidden', 'north');
        $(obj).attr("class", "search-down-arr");
    }
}

//显示在工具条上的搜索框
function toolSearch(opts){
    var _box=$('<div>').attr('id',"searchDiv").addClass('simple-search-box');
    var _a=$('<a>').attr({'id':"searchArr",'href':'javascript:;'}).addClass('search-up-arr');
    var _tbM=$('<div>').addClass('toolbar_menu');
    var opts=opts || {collapsible:true,items:[]};
    var target=opts.target || $('#subLayout');
    var appendTo=opts.appendTo || $('#toolbar');
    var items=opts.items;
    var _width=opts.width || 250;
    var _pos=opts.pos || 'right';
    appendTo.css({'position':'relative'});
    if(items&&items.length>0){
        for(var i=0;i<items.length;i++){
            var _d=$('<div>');
            _d.attr('name',items[i].name).html(items[i].text);
            _tbM.append(_d);
        }
        _box.append('<input class="tbSearch"/>');
    }

    if(opts.collapsible!=false){
        _a.click(function(){
            popSearch(this,target);
        });
        _box.append(_a);
    }else{
        _box.css({right:5});
        if(_pos=="left"){
            _box.css({left:5});
        }
    }

    _box.append(_tbM);
    if(appendTo){
        $(appendTo).append(_box);
    }

    if(items&&items.length>0){
        $('.tbSearch',appendTo).searchbox({
            width:_width,
            searcher:function(value,name){
                if(typeof opts.callback=="function"){
                    opts.callback(value,name);
                }
            },
            menu:$('.toolbar_menu',appendTo),
            prompt:'请输入关键字'
        });
    }
    if($('.search-div').closest('.layout-panel-north').css('display')=="none"){
        setTimeout(function() {
            $('#searchArr',appendTo).addClass('search-down-arr').removeClass('search-up-arr');
        },200);
    }
}

//新增TAB
function addTab(opts){
    addNewTab(opts,false);
}

function addBlankTab(opts){
    addNewTab(opts,true);
}

function addNewTab(opts,blank) {
    var title = opts.title;
    var href = opts.href;
    var icon = opts.icon;
    var iframed = opts.iframed || true;
    var refreshed = opts.refreshed || false;
    var closabled = opts.closabled;
    if (typeof(iframed) == "undefined") {
        iframed = true;
    }
    var tt = $('#mainTabs');
    if(tt.tabs('exists',title)){
        tt.tabs('select',title);
        if(refreshed)
            tt.tabs('refreshTab', title);
    } else{
        tt.tabs('add',{
            title: title,
            href: href,
            iniframe: iframed,
            showMask:true,
            closable: true
        });
    }
}

//创建多个tab
(function($){
    $.fn.createTabs=function(options){
        var options=$.extend({
            selected:0
        }, options || {});
        var that=this;
        var items=options.tabs;
        this.addClass('easyui-tabs').attr('data-options','plain:true,fit:true');
        for(var i=0;i<items.length;i++){
            var title=items[i].title;
            var href=items[i].href;
            var lazyload=false;
            if(items[i].lazyload){
                lazyload=items[i].lazyload;
            }
            var div=$('<div data-options="title:\''+title+'\',refreshButton:true,lazyload:'+lazyload+'" style="overflow:hidden;"></div>');
            if(lazyload){
                div.html('<iframe scrolling="auto" frameborder="0"  class="tabs-iframe" lazysrc="'+href+'"></iframe>');
            }else{
                div.html('<iframe scrolling="auto" frameborder="0"  class="tabs-iframe" src="'+href+'"></iframe>');
            }
            div.appendTo(that);
        }

        var index=0;
        $(that).tabs({
            onSelect:function(title,idx){
                var pp=$(that).tabs('getSelected');
                var opts=pp.panel('options');
                if(opts.lazyload){
                    var iframe=pp.find('iframe');
                    if(!iframe[0]){
                        return;
                    }
                    if(iframe.attr('lazysrc')!="" && (index!=0||options.selected==0)){
                        iframe.attr('src',iframe.attr('lazysrc')).removeAttr('lazysrc');
                    }
                }
                index=idx;
            }
        });

        $(that).tabs('select',options.selected);

        return that;
    }
})(jQuery);
