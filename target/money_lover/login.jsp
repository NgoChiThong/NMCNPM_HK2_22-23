<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Table - Money Lover</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link href="
https://cdn.jsdelivr.net/npm/sweetalert2@11.7.3/dist/sweetalert2.min.css
" rel="stylesheet">

</head>
<%
    String error = (request.getAttribute("error") == null) ? " " : request.getAttribute("error").toString();

%>
<body class="bg-gradient-primary">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-9 col-lg-12 col-xl-10">
            <div class="card shadow-lg o-hidden border-0 my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-flex">
                            <img src="assets/img/dogs/img.png">
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h4 class="text-dark mb-4">Xin chào!</h4>
                                </div>
                                <%= error%>
                                <form class="user" action="${pageContext.request.contextPath}/login" method="post">
                                    <div class="mb-3"><input class="form-control form-control-user" type="text"
                                                             id="InputEmail" aria-describedby="emailHelp"
                                                             placeholder="Enter Email Address..." name="email"></div>
                                    <div class="mb-3"><input class="form-control form-control-user" type="password"
                                                             id="InputPassword" placeholder="Password" name="password">
                                    </div>
                                    <button class="btn btn-primary d-block btn-user w-100" type="submit">Đăng nhập
                                    </button>
                                </form>
                                <div class="text-center"><a class="small" href="/register.jsp">Tạo tài khoản!</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../..Timestamp/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../../..Timestamp/assets/js/bs-init.js"></script>
<script src="../../..Timestamp/assets/js/theme.js"></script>
</body>

</html>