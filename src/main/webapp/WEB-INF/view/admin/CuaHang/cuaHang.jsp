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
        <form class="form-control" action="/cuahang/addCh" method="post" modelAttribute="cuaHangAdd" style="margin-left: 100px;margin-top: 20px">
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="Id" readonly value="${editCH.id}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mã</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ma"  value="${editCH.ma}"><span>${errors.ma}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Tên</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ten" value="${editCH.ten}"><span>${errors.ten}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Đỉa Chỉ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="diaChi"  value="${editCH.diaChi}"><span>${errors.diaChi}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Thành Phố</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="thanhPho" value="${editCH.thanhPho}"><span>${errors.thanhPho}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Quốc Gia</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="quocGia"  value="${editCH.quocGia}"><span>${errors.quocGia}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <div class="col-sm-10"></div>
            </div>
            <button type="button" class="btn btn-secondary"><a href="/create" style="text-decoration: none;color: white">Create</a></button>
            <button type="submit" class="btn btn-success">Add phong ban</button>

        </form>
    </div>

</div>

<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Mã</th>
        <th scope="col">Ten</th>
        <th scope="col">DiaChi</th>
        <th scope="col">ThànhPhô</th>
        <th scope="col">QuốcGia</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCuaHang}" var="ch" varStatus="i">
        <tr>
            <th scope="row">${i.index+1}</th>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td><button type="button" class="btn btn-danger"><a href="/cuahang/delete/${ch.id}" style="text-decoration: none;color: black">Delete</a></button>
                <button type="button" class="btn btn-info"><a href="/cuahang/edit/${ch.id}" style="text-decoration: none;color: black">Edit</a></button>
                <button type="button" class="btn btn-info"><a href="/CuaHang/deltail/${ch.id}" style="text-decoration: none;color: black">Detail</a></button>

            </td>
        </tr>

    </c:forEach>
    </tbody>


</table>
<div class="clearfix" style="margin-left: 75%">
    <ul class="pagination">
        <li class="page-item"><a href="/getAll?p=${listDV.number - 1}" class="page-link">Previous</a></li>
        <li class="page-item"><a href="#" class="page-link">1</a></li>
        <li class="page-item"><a href="#" class="page-link">2</a></li>
        <li class="page-item active"><a href="#" class="page-link">3</a></li>
        <li class="page-item"><a href="#" class="page-link">4</a></li>
        <li class="page-item"><a href="#" class="page-link">5</a></li>
        <li class="page-item"><a href="/getAll?p=${listDV.number + 1}" class="page-link">Next</a></li>
    </ul>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>