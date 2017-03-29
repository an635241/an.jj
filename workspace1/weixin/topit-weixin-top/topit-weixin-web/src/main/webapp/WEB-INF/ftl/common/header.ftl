<script type="text/javascript"  src="<@s.url "/resources/boot.js"/>" ></script>
<!--
<script type="text/javascript"  src="http://172.17.210.162:82/boot.js" ></script>
<script type="text/javascript" src="<@s.url "/resources/common/js/easyui-lang-zh_CN.js"/>" ></script>
上线之后用本地 boot.js      http://172.17.17.134:8080/ui/easyui-api/boot.js
<script type="text/javascript" src="http://10.0.30.51/ui/easyui-api/boot.js?version=1.0.0" ></script>
-->

<#--
<link rel="stylesheet" type="text/css" href="<@s.url "/resources/css/styles/easyui.css"/>" />
<link rel="stylesheet" type="text/css" href="<@s.url "/resources/css/styles/validator.css"/>"/>
<link rel="stylesheet" type="text/css" href="<@s.url "/resources/css/styles/icon.css" />"/>
<script type="text/javascript" src="<@s.url "/resources/common/js/jquery-1.6.4.min.js"/>"></script>
<script type="text/javascript" src="<@s.url "/resources/common/js/jquery.easyui.min.js"/>" ></script>
<script type="text/javascript" src="<@s.url "/resources/common/js/jquery.form.js"/>" ></script>
-->
<link rel="stylesheet" type="text/css" href="<@s.url "/resources/css/styles/sys-window.css"/>"/>
<!--界面上直接用   ${basePath}  -->

<script>
	   var BasePath = '${springMacroRequestContext.getContextPath()}';
	   var currentQuartzcenterNo='${(Session["session_user"].quartzcenterNo)!}';
	   var currentTransportPointNo='${(Session["session_user"].transportPointNo)!}';
	   var currentDriverName='${(Session["session_user"].driverName)!}';
	   var applicationPath='${(Session["applicationPath"])!}';	  
	   var domainStatic='${domainStatic}';
	   var resourceVersion='${resourceVersion}';
	   var ucSessionCheckedRedirectUrl='${ucSessionCheckedRedirectUrl}';
</script>