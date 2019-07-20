<%--
  Created by IntelliJ IDEA.
  User: heyc
  Date: 2019/2/23
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
    <title>惠民加油平台</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/userinfo/user_info.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_register.css" type="text/css">
</head>
<body>
<div id="parent">
    <div id="top"></div>
    <div id="center">
        <div id="title_content">注册用户信息</div>
        <form id="user_submit" method="post">
             <input type="hidden" name="openId" value="${openId}" />
            <div id="frm_control_group">
                <div>
                    <label for="name">姓　　名</label>:
                    <input class="easyui-textbox" type="text" name="name" data-options="" style="width:200px;height: 35px" />
                </div>
                <div>
                    <label for="mobileNumber">手　机号</label>:
                    <input class="easyui-textbox" type="text" name="mobileNumber" style="width:200px;height: 35px" />
                </div>
                <div>
                    <label for="password">密　　码</label>:
                    <input class="easyui-textbox" name="password" data-options="iconCls:'icon-man',type:'password'"  style="width:200px;height: 35px">
                </div>
                <div>
                    <label for="password">确认密码</label>:
                    <input class="easyui-textbox" data-options="iconCls:'icon-man',type:'password'"  style="width:200px;height: 35px">
                </div>
                <div id="button_div">
                    <a id="submit_btn" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>  
                    <a id="cancel_btn" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">取消</a>  
                </div>
            </div>
        </form>

    </div>
    <div id="down">down</div>
</div>

</body>
</html>
