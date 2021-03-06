<%--
  Created by IntelliJ IDEA.
  User: 单子健
  Date: 2020/12/16
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>消息处理</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <script>
        function show() {
            /*******-----*********/
            $.post({
                url:"${pageContext.request.contextPath}/nav",
                data:{},
                dataType:"json",
                success:function (json) {

                    $("#booknum").html(json[0]);
                    $("#usernum").html(json[1]);
                    $("#borrownum").html(json[2]);
                    $("#overnum").html(json[3]);

                }
            })
            /***********************/

            $.post({
                url:"${pageContext.request.contextPath}/allmessage",
                data:{},
                dataType:"json",
                success:function (json) {
                    var html = "";
                    for (var i=0;i<json.length;i++)
                    {

                        html+="<tr>"+
                            "<td>"+json[i].uname+"</td>"+
                            "<td>"+json[i].bookname+"</td>"+
                            "<td>"+json[i].num+"</td>"+
                            "<td>"+json[i].status+"</td>"+
                            "<td>"+json[i].starttime+"</td>"+
                            '<td class="text-center">' +
                                '<button onclick="ture()" class="btn btn-outline-info border rounded d-inline-flex" type="button" style="margin: 0px;margin-right: 2px;"><i class="fa fa-check"></i></button>' +
                                '<button class="btn btn-outline-danger text-center border rounded d-inline-flex" type="button" style="width: 40px;margin-right: 2px;"><i class="fa fa-times"></i></button>' +
                                '<button class="btn btn-outline-link border rounded d-inline-flex" type="button" style="height: 30px;width: 40px;padding-left: 12px;">...</button>' +
                            '</td>'+
                            "</tr>"
                    };


                    $("#allmessage").html(html);
                }
            })

        }



        /*******---确认按钮对应的方法（未写）--******/
        function ture() {
            $.post({
                url:"${pageContext.request.contextPath}/turemessage",
                data:{},
                dataType:"json",
                success:function (json) {
                    var html = "";
                    var j = 1;
                    for (var i=0;i<json.length;i++)
                    {

                        html+="<li class='list-group-item'><div class='row align-items-center no-gutters'>"+
                            "<div class='col mr-2'><h6 class='mb-0'><strong>"+json[i].bookname+"</strong></h6><span class='text-xs'>"+json[i].starttime+"</span></div>"+
                            "<div class='col-auto'><div class='custom-control custom-checkbox'>"+
                            "<input class='custom-control-input' type='checkbox' id='formCheck-"+j+"'><label class='custom-control-label' for='formCheck-"+j+"'></label></div>"+
                            "</div></div></li>"
                        j = j+1;


                    };

                    $("#card3").html(html);
                }
            })

        }
        /*****************************************/

    </script>
</head>
<body id="page-top" onpageshow="show()">
<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="${pageContext.request.contextPath}/tohome">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i></div>
                <div class="sidebar-brand-text mx-3"><span>HELLO,${uuid.getUname()}</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/tobookinf"><i class="fas fa-book-open"></i><span style="margin-left: 4px;">图书库</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/toborrow"><i class="fas fa-grip-lines"></i><span style="filter: blur(0px) brightness(100%);margin-left: 3px;">历史借阅</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/touser"><i class="fas fa-user-cog"></i><span>用户管理</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/tomessage"><i class="fas fa-clipboard-list"></i><span style="margin-left: 2px;">&nbsp;消息处理</span></a>
                    <a class="nav-link active" href="${pageContext.request.contextPath}/touserwant"><i class="fas fa-user-clock" style="width: 17px;"></i><span>增库申请</span></a>
                </li>
            </ul>
            <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                    <form class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                            <div class="input-group-append"><button class="btn btn-primary py-0" type="button" style="margin: 0px;margin-left: 3px;"><i class="fas fa-search"></i></button></div>
                        </div>
                    </form>
                    <ul class="nav navbar-nav flex-nowrap ml-auto">
                        <li class="nav-item dropdown d-sm-none no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-search"></i></a>
                            <div class="dropdown-menu dropdown-menu-right p-3 animated--grow-in" role="menu" aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto navbar-search w-100">
                                    <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                                        <div class="input-group-append"><button class="btn btn-primary py-0" type="button"><i class="fas fa-search"></i></button></div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                            <div class="nav-item dropdown no-arrow"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><span class="badge badge-danger badge-counter">3+</span><i class="fas fa-bell fa-fw"></i></button>
                                <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                     role="menu">
                                    <h6 class="dropdown-header">alerts center</h6>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-primary icon-circle"><i class="fas fa-file-alt text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 12, 2019</span>
                                            <p>A new monthly report is ready to download!</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-success icon-circle"><i class="fas fa-donate text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 7, 2019</span>
                                            <p>$290.29 has been deposited into your account!</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-warning icon-circle"><i class="fas fa-exclamation-triangle text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 2, 2019</span>
                                            <p>Spending Alert: We've noticed unusually high spending for your account.</p>
                                        </div>
                                    </a><a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                            <div class="nav-item dropdown no-arrow"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><i class="fas fa-envelope fa-fw"></i><span class="badge badge-danger badge-counter">7</span></button>
                                <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                     role="menu">
                                    <h6 class="dropdown-header">alerts center</h6>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar4.jpeg">
                                            <div class="bg-success status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Hi there! I am wondering if you can help me with a problem I've been having.</span></div>
                                            <p class="small text-gray-500 mb-0">Emily Fowler - 58m</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar2.jpeg">
                                            <div class="status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>I have the photos that you ordered last month!</span></div>
                                            <p class="small text-gray-500 mb-0">Jae Chun - 1d</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar3.jpeg">
                                            <div class="bg-warning status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Last month's report looks great, I am very happy with the progress so far, keep up the good work!</span></div>
                                            <p class="small text-gray-500 mb-0">Morgan Alvarez - 2d</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar5.jpeg">
                                            <div class="bg-success status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</span></div>
                                            <p class="small text-gray-500 mb-0">Chicken the Dog · 2w</p>
                                        </div>
                                    </a><a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                            </div>
                            <div class="shadow dropdown-list dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown"></div>
                        </li>
                        <div class="d-none d-sm-block topbar-divider"></div>
                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><span class="d-none d-lg-inline mr-2 text-gray-600 small">Valerie Luna</span><img class="border rounded-circle img-profile" src="assets/img/avatars/touxiang.png"></button>
                                <div
                                        class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu"><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Profile</a><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Settings</a>
                                    <a
                                            class="dropdown-item" role="presentation" href="#"><i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Activity log</a>
                                    <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Logout</a></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container-fluid" style="height: 240px;">
                <div class="row">
                    <div class="col">
                        <form class="d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="form-row" style="height: 96px;">
                                <div class="col d-xl-flex justify-content-xl-start align-items-xl-center"><span class="d-xl-flex justify-content-xl-center align-items-xl-center" style="width: 51px;">用户名</span><input type="text" class="form-control" style="width: 107px;" /></div>
                                <div class="col d-xl-flex justify-content-xl-start align-items-xl-center"><span class="d-xl-flex justify-content-xl-center align-items-xl-center" style="width: 51px;">书名</span><input type="text" class="form-control" /></div>
                                <div class="col d-xl-flex justify-content-xl-start align-items-xl-center"><span class="d-xl-flex justify-content-xl-center align-items-xl-center" style="width: 51px;">状态</span><input type="text" class="form-control" /></div>
                                <div class="col d-xl-flex justify-content-xl-start align-items-xl-center"><button class="btn btn-primary py-0" type="button" style="background-color: #656565; height: 32px"><i class="fas fa-search"></i></button></div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th style="width: 130px;">姓名</th>
                                    <th style="width: 230px;"><strong>&nbsp;书名</strong><br></th>
                                    <th style="width: 80px;">剩余</th>
                                    <th class="text-left" style="width: 96px;">状态</th>
                                    <th class="text-center" style="width: 230px;">申请时间</th>
                                    <th class="text-center" style="width: 230px;">操作</th>
                                </tr>
                                </thead>
                                <tbody id="allmessage">
                                <tr>
                                    <td>让让</td>
                                    <td><strong>霍乱时期的爱情</strong><br></td>
                                    <td>3<br></td>
                                    <td>待借出</td>
                                    <td>2020-12-13</td>
                                    <td>待处理<br></td>
                                    <td class="text-center"><button class="btn btn-outline-info border rounded d-inline-flex" type="button" style="margin: 0px;margin-right: 2px;"><i class="fa fa-check"></i></button><button class="btn btn-outline-danger text-center border rounded d-inline-flex" type="button" style="width: 40px;margin-right: 2px;"><i class="fa fa-times"></i></button><button class="btn btn-outline-link border rounded d-inline-flex" type="button" style="height: 30px;width: 40px;padding-left: 12px;">...</button></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <footer class="bg-white sticky-footer">
                    <div class="container my-auto">
                        <div class="text-center my-auto copyright"><span>Copyright © Gvssimux 2020</span></div>
                    </div>
                </footer>
            </div>
        </div>

    </div><a class="text-center border rounded d-inline d-xl-flex justify-content-xl-center align-items-xl-center scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
</body>
</html>
