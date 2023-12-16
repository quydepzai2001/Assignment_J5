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
        <form class="form-control" action="/nhanvien/updateNv" method="post" modelAttribute="nhanVienUpdate" style="margin-left: 100px;margin-top: 20px">
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
                    <input type="text" class="form-control" name="ngaySinh" value="${editNV.ngaySinh}"><span style="color: red">${errors.ngaySinh}</span>
                </div>
            </div>
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
                <class ="col-sm-10">

                <input type="radio" name="trangThai" value="0" ${editNV.trangThai == 0 ? "checked" : ""} value="${editNV.trangThai}">Hoat Động <br><span>${errors.trangThai}</span><br>
                <input type="radio" name="trangThai" value="1" ${editNV.trangThai == 1 ? "checked" : ""} value="${editNV.trangThai}">Không Hoat Đông<br><span>${errors.trangThai}</span><br>                </div>
              </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Của Hàng</label>
                <div class="col-sm-10">
                    <select name="listCuaHang">
                        <c:forEach items="${nvcuaHang}" var="nvCH">
                            <option value="${nvCH.id}" ${nvCH.id == editNV.listCuaHang.id ? 'selected' : '' }>${nvCH.ten}</option>

                        </c:forEach>
                    </select>

                </div>
            </div>
            <button type="button" class="btn btn-secondary"><a href="/create" style="text-decoration: none;color: white">Create</a></button>
            <button type="submit" class="btn btn-success">Add phong ban</button>

        </form>
    </div>

</div>
</body>
</html>
