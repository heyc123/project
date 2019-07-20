document.write('<script type="text/javascript" src="/gas/js/jquery-easyui/jquery.min.js"></script>');
document.write('<script type="text/javascript" src="/gas/js/jquery-easyui/jquery.easyui.min.js"></script>');
document.write('<script type="text/javascript" src="/gas/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>');
document.write('<link rel="stylesheet" href="/gas/js/jquery-easyui/themes/default/easyui.css" type="text/css"/>');
document.write('<link rel="stylesheet" href="/gas/js/jquery-easyui/themes/icon.css" type="text/css"/>');

var domain = window.location.host;
var curWwwPath = window.document.location.href;  
var pathName = window.document.location.pathname;  
var pos = curWwwPath.indexOf(pathName);  
//获取主机地址，如： http://localhost:8088  
var localhostPath = curWwwPath.substring(0, pos);  
//获取带"/"的项目名，如：/projectName  
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/')+1);

var path = domain+projectName;