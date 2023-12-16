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
        <form class="form-control" action="/nhanvien/addNv" method="post" modelAttribute="nhanVienAdd" style="margin-left: 100px;margin-top: 20px">
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="Id" readonly value="${editNV.id}"><span>${errors.Id}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mã</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ma"  value="${editNV.ma}"><span>${errors.ma}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Tên</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ten" value="${editNV.ten}"><span>${errors.ten}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Tên Đệm</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="tenDem"  value="${editNV.tenDem}"><span>${errors.tenDem}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Họ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ho" value="${editNV.ho}"><span>${errors.ho}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Giới Tính</label>
                <div class="col-sm-10">
                    <input type="radio" name="gioiTinh" value="true" ${editNV.gioiTinh == true ? "checked" : ""} value="${editNV.gioiTinh}">Nam<br><span>${errors.gioiTinh}</span><br>
                    <input type="radio" name="gioiTinh" value="false" ${editNV.gioiTinh == false ? "checked" : ""} value="${editNV.gioiTinh}">Nữ <br><span>${errors.gioiTinh}</span><br>
<%--                    <input type="text" class="form-control" name="gioiTinh"  value="${editNV.gioiTinh}"><span>${errors.gioiTinh}</span><br>--%>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Ngày Sinh</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" name="ngaySinh" value="${editNV.ngaySinh}"><span style="color: red">${errors.ngaySinh}</span>
                </div>
            </div><br>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Địa Chỉ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="diaChi" value="${editNV.diaChi}"><span>${errors.diaChi}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Số Điện Thoại</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="sdt" value="${editNV.sdt}"><span>${errors.sdt}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mật Khẩu</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="matKhau" value="${editNV.matKhau}"><span>${errors.matKhau}</span><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Trạng Thái</label>
                <div class="col-sm-10">

                    <input type="radio" name="trangThai" value="0" ${editNV.trangThai == 0 ? "checked" : ""} value="${editNV.trangThai}">Hoat Động <br><span>${errors.trangThai}</span><br>
                    <input type="radio" name="trangThai" value="1" ${editNV.trangThai == 1 ? "checked" : ""} value="${editNV.trangThai}">Không Hoat Đông<br><span>${errors.trangThai}</span><br>               </div>
            </div>


            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Của Hàng</label>
                <div class="col-sm-10">
                    <select name="listCuaHang">
                        <c:forEach items="${nvcuaHang}" var="nvCH">
                            <option value="${nvCH.id}" ${nvCH.id == editNV.listCuaHang.id ? 'selected' : '' }>${nvCH.ma}</option>

                        </c:forEach>
                    </select>

                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Chức Vụ</label>
                <div class="col-sm-10">
                    <select name="chucVus">
                        <c:forEach items="${nvChucVu}" var="nvCV">
                            <option value="${nvCV.id}" ${nvCV.id == editNV.chucVus.id ? 'selected' : '' }>${nvCV.ma}</option>

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
        <th scope="col">Mã</th>
        <th scope="col">Ten</th>
        <th scope="col">TenDem</th>
        <th scope="col">Ho</th>
        <th scope="col">GioiTinh</th>
        <th scope="col">NgaySinh</th>
        <th scope="col">DiaChi</th>
        <th scope="col">Sdt</th>
        <th scope="col">MatKhau</th>
        <th scope="col">TrangThai</th>
        <th scope="col">CuaHang</th>
        <th scope="col">ChucVu</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lisNv.content}" var="nv" varStatus="i">
        <tr>
            <th scope="row">${i.index+1}</th>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh ? "nam":"nu"}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.trangThai}</td>
            <td>${nv.listCuaHang.ma}</td>
            <td>${nv.chucVus.ma}</td>
            <td><button type="button" class="btn btn-danger"><a href="/nhanvien/delete/${nv.id}" style="text-decoration: none;color: black">Delete</a></button>
                <button type="button" class="btn btn-info"><a href="/nhanvien/edit/${nv.id}" style="text-decoration: none;color: black">Edit</a></button>
                <button type="button" class="btn btn-info"><a href="/nhanvien/detail/${nv.id}" style="text-decoration: none;color: black">Detail</a></button>

            </td>
        </tr>

    </c:forEach>
    </tbody>


</table>
<div class="clearfix" style="margin-left: 75%">
    <ul class="pagination">
        <li class="page-item"><a href="/nhanvien/getAll?p=1" class="page-link"> |< </a></li>
        <li class="page-item"><a href="/nhanvien/getAll?p=${lisNv.number}" class="page-link"> < </a></li>
        <li class="page-item active"><a href="/nhanvien/getAll?p=${listDSP.number + 1}" class="page-link">${lisNv.number + 1}</a></li>
        <li class="page-item "><a href="/nhanvien/getAll?p=${lisNv.number+2}" class="page-link">${lisNv.number+2}</a></li>
        <li class="page-item"><a href="/nhanvien/getAll?p=${lisNv.number+3}" class="page-link">${lisNv.number+3}</a></li>
        <li class="page-item"><a href="/nhanvien/getAll?p=${lisNv.totalPages}" class="page-link"> >| </a></li>
    </ul>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>