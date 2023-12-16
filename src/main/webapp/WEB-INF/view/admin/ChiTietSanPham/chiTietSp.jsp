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
        <form class="form-control" action="/chitietSp/add" method="post" modelAttribute="chiTietSanPhamAdd" style="margin-left: 100px;margin-top: 20px">
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="id" readonly value="${editctsp.id}"><span>${errors.id}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mã</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="namBh"  value="${editctsp.namBh}"><span>${errors.namBh}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mota</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="moTa" value="${editctsp.moTa}"><span>${errors.soLuongTon}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">SoLuongTon</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="soLuongTon"  value="${editctsp.soLuongTon}"><span>${errors.giaNhap}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Gia Nhap</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="giaNhap" value="${editctsp.giaNhap}"><span>${errors.giaBan}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Gia Ban</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="giaBan"  value="${editctsp.giaBan}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Sản Phẩm</label>
                <div class="col-sm-10">
                    <select name="sanPhams">
                        <c:forEach items="${cbbSp}" var="sp">
                            <option value="${sp.id}" ${sp.id == editctsp.sanPhams.id ? 'selected' : '' }>${sp.ten}</option>

                        </c:forEach>
                    </select>

                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Màu Săc</label>
                <div class="col-sm-10">
                    <select name="mauSacs">
                        <c:forEach items="${cbbMc}" var="mc">
                            <option value="${mc.id}" ${mc.id == editctsp.mauSacs.id ? 'selected' : '' }>${mc.ten}</option>

                        </c:forEach>
                    </select>

                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">DongSP</label>
                <div class="col-sm-10">
                    <select name="dongSPs">
                        <c:forEach items="${cbbDongSP}" var="dsp">
                            <option value="${dsp.id}" ${dsp.id == editctsp.dongSPs.id ? 'selected' : '' }>${dsp.ten}</option>

                        </c:forEach>
                    </select>

                </div>
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
        <th scope="col">IdSP</th>
<%--        <th scope="col">IdNsx</th>--%>
        <th scope="col">IdMauSac</th>
        <th scope="col">IdDongSp</th>
        <th scope="col">NamBh</th>
        <th scope="col">MoTa</th>
        <th scope="col">SoLuong</th>
        <th scope="col">GiaNhap</th>
        <th scope="col">GiaBan</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCtsp.content}" var="ctsp" varStatus="i">
        <tr>
            <th scope="row">${i.index+1}</th>
            <td>${ctsp.sanPhams.ten}</td>
            <td>${ctsp.mauSacs.ten}</td>
            <td>${ctsp.dongSPs.ten}</td>
            <td>${ctsp.namBh}</td>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.giaNhap}</td>
            <td>${ctsp.giaBan}</td>

            <td><button type="button" class="btn btn-danger"><a href="/chitietSp/delete/${ctsp.id}" style="text-decoration: none;color: black">Delete</a></button>
                <button type="button" class="btn btn-info"><a href="/chitietSp/detail/${ctsp.id}" style="text-decoration: none;color: black">Edit</a></button>
                <button type="button" class="btn btn-info"><a href="/chitietSp/detail/${ctsp.id}" style="text-decoration: none;color: black">Detail</a></button>

            </td>
        </tr>

    </c:forEach>
    </tbody>


</table>
<div class="clearfix" style="margin-left: 75%">
    <ul class="pagination">
        <li class="page-item"><a href="/chitietSp/getAll?p=1" class="page-link"> |< </a></li>
        <li class="page-item"><a href="/chitietSp/getAll?p=${listCtsp.number}" class="page-link"> < </a></li>
        <li class="page-item active"><a href="/chitietSp/getAll?p=${listDSP.number + 1}" class="page-link">${listCtsp.number + 1}</a></li>
        <li class="page-item "><a href="/chitietSp/getAll?p=${listCtsp.number+2}" class="page-link">${listCtsp.number+2}</a></li>
        <li class="page-item"><a href="/chitietSp/getAll?p=${listCtsp.number+3}" class="page-link">${listCtsp.number+3}</a></li>
        <li class="page-item"><a href="/chitietSp/getAll?p=${listCtsp.totalPages}" class="page-link"> >| </a></li>
    </ul>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>