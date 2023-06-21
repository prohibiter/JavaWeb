<%--
  Created by IntelliJ IDEA.
  User: Xuuuuuuuu
  Date: 2022/2/5
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <%--web路径
    不以/开始的相对路径，找资源，以当前资源路径为基础
    以/开始的相对路径，找资源，以服务器的路径为基础
    --%>
    <script src="${APP_PATH}/static/js/jquery.js"></script>
    <script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css">

</head>
<body>
<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input"
                                   placeholder="empName">
                            <span id="helpBlock1" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email_add_input"
                                   placeholder="email">
                            <span id="helpBlock2" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <select name="dId" class="form-control" id="dept_add_select"></select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_add_btn">保存</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>SSM_CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary" id="emp_add_modal_btn">新增</button>
            <button type="button" class="btn btn-danger" id="emp_del_modal_btn">删除</button>
        </div>
    </div>
    <%--显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <%--显示分页信息--%>
    <div class="row">
        <div class="col-md-6" id="page_info"></div>
        <div class="col-md-6" id="page_nav"></div>
    </div>
</div>
<script type="text/javascript">

    var totalRecord;

    /*
    * 页面加载完成后直接发送一个ajax请求获取分页信息
    * */
    $(function () {
        to_page(1);
    });

    function to_page(pn) {
        $(function () {
            $.ajax({
                url: "${APP_PATH}/emps",
                data: "pn=" + pn,
                type: "get",
                success: function (result) {
                    //1、解析并显示员工数据
                    build_emps_table(result);
                    //2、解析并显示分页信息
                    build_page_info(result);
                    build_page_nav(result);
                }
            });
        });
    }

    //构建员工信息
    function build_emps_table(result) {
        $("#emps_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        $.each(emps, function (index, item) {
            var empIdTd = $("<td></td>").append(item.empId);
            var empNameTd = $("<td></td>").append(item.empName);
            var empGenderTd = $("<td></td>").append(item.gender == "M" ? "男" : "女");
            var empMailTd = $("<td></td>").append(item.email);
            var deptNameTd = $("<td></td>").append(item.department.deptName);
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑"));
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-trash").append("删除"));
            var editTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(empIdTd).append(empNameTd).append(empGenderTd).append(empMailTd).append(deptNameTd).append(editTd).appendTo("#emps_table tbody");
        });
    }

    //构建分页信息
    function build_page_info(result) {
        totalRecord = result.extend.pageInfo.total;
        $("#page_info").empty().append("总记录：" + result.extend.pageInfo.total + "，当前" + result.extend.pageInfo.pageNum + "页，共" + result.extend.pageInfo.pages + "页");
    }

    //构建分页导航
    function build_page_nav(result) {
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").click(function () {
            to_page(1);
        }));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#")).click(function () {
            to_page(result.extend.pageInfo.pageNum - 1);
        });
        if (result.extend.pageInfo.pageNum == 1) {
            firstPageLi.addClass("hidden");
            prePageLi.addClass("hidden");
        }
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").click(function () {
            to_page(result.extend.pageInfo.pageNum + 1);
        }));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").click(function () {
            to_page(result.extend.pageInfo.pages);
        }));
        if (result.extend.pageInfo.pageNum == result.extend.pageInfo.pages) {
            lastPageLi.addClass("hidden");
            nextPageLi.addClass("hidden");
        }
        var ul = $("<ul></ul>").addClass("pagination").append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        ul.append(nextPageLi).append(lastPageLi);
        $("#page_nav").empty().append(ul);
    }

    //点击新增按钮弹出模态框
    $("#emp_add_modal_btn").click(function () {
        //发送ajax请求查询部门信息
        getDepts();
        //弹出模态框
        $("#empAddModal").modal({
            backdrop: false
        });
    });

    function validate_add_form() {
        //1、拿到要校验的数据
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if (!regName.test(empName)) {
            $("#empName_add_input").parent("div").parent("div").addClass("has-error");
            $("#empName_add_input").next("span").text("用户名为2-5位中文或6-16位英文数字组合");
            return false;
        }else{
            $("#empName_add_input").parent("div").parent("div").removeClass("has-error").addClass("has-success");
            $("#empName_add_input").next("span").text("用户名正确！");
        }
        //校验邮箱
        var email = $("#email_add_input").val();
        var regEmail = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
        if (!regEmail.test(email)) {
            $("#email_add_input").parent("div").parent("div").addClass("has-error");
            $("#email_add_input").next("span").text("邮箱格式不正确");
            return false;
        }else{
            $("#email_add_input").parent("div").parent("div").removeClass("has-error").addClass("has-success");
            $("#email_add_input").next("span").text("邮箱格式正确！");
        }
        return false;
    }

    //员工姓名验证
    $("#empName_add_input").change(function(){
        var empName = this.value;
        //发送请求验证用户名是否可用
        $.ajax({
            url:"${APP_PATH}/checkuser",
            type:"get",
            data:"empname=" + empName,
            success:function(result){
                if(result.code == 100){
                    alert("用户名可用");
                }else{
                    alert("用户名不可用");
                }
            }
        });
    });

    //模态框保存按钮
    $("#emp_add_btn").click(function () {
        //校验用户信息
        if (!validate_add_form()) {
            return false;
        }
        //添加用户信息
        $.ajax({
            url: "${APP_PATH}/emp",
            type: "post",
            data: $("#empAddModal form").serialize(),
            success: function (result) {
                $('#empAddModal').modal('hide');
                to_page(Math.ceil(totalRecord / 5));
            }
        })
    })

    //获取部门信息
    function getDepts() {
        $.ajax({
            url: "${APP_PATH}/depts",
            type: "get",
            success: function (result) {
                $("#dept_add_select").empty();
                $.each(result.extend.depts, function (index, item) {
                    var option = $("<option></option>").append(item.deptName).attr("value", item.deptId);
                    $("#dept_add_select").append(option);
                });
            }
        });
    }
</script>
</body>
</html>