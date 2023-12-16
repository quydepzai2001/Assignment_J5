<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
    </style>
</head>
<body>
<div class="row">
    <div class="col-sm-8">
        <form class="form-control" action="/khachhang/updateKH" method="post" modelAttribute="khachHangUpdate" style="margin-left: 100px;margin-top: 20px">
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="id" readonly value="${editKH.id}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mã</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ma"  value="${editKH.ma}"> <span style="color: red">${errors.ma}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Tên</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ten" value="${editKH.ten}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Tên Đệm</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="tenDem" value="${editKH.ten}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Họ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ho" value="${editKH.ho}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Ngày Sinh</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ngaySinh" value="${editKH.ngaySinh}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Số điện thoại</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="sdt" value="${editKH.sdt}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Địa Chỉ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="diaChi" value="${editKH.diaChi}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Thành phố</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="thanhPho" value="${editKH.thanhPho}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Quốc gia</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="quocGia" value="${editKH.quocGia}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mật khẩu</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="matKhau" value="${editKH.matKhau}">  <span style="color: red">${errors.ten}</span>
                </div>
            </div>
            <button type="button" class="btn btn-secondary"><a href="/khachhang/create" style="text-decoration: none;color: white">Create</a></button>
            <button type="submit" class="btn btn-success">Add khách hàng</button>

        </form>
    </div>
</div>
</body>
</html>