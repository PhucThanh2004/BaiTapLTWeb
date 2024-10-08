<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Category</title>
</head>
<body>
    <h1>Edit Category</h1>
    
    <!-- Form cập nhật danh mục -->
    <form action="${pageContext.request.contextPath}/admin/category/update" method="post" enctype="multipart/form-data">
        
        <!-- Hidden input để chứa ID của danh mục -->
        <input type="hidden" name="categoryid" value="${cate.categoryid}">
        
        <label for="categoryname">Category name:</label><br>
        <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
        
        <label for="images">Link images:</label><br>
        <!-- Kiểm tra xem hình ảnh là link ngoài hay file nội bộ -->
        <c:if test="${cate.images.substring(0,5) != 'https'}">
            <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
        </c:if>
        <c:if test="${cate.images.substring(0,5) == 'https'}">
            <c:url value="${cate.images}" var="imgUrl"></c:url>
        </c:if>
        <img height="150" width="200" src="${imgUrl}" /> 
        <input type="text" id="images" name="images" value="${cate.images}"><br>
        
        <label for="images">Upload file:</label><br>
        <input type="file" id="images1" name="images1"><br>
        
        <label for="status">Status:</label><br>
        <input type="radio" id="ston" name="status" value="1" <c:if test="${cate.status == 1}">checked</c:if>> 
        <label for="ston">Hoạt động</label><br>
        
        <input type="radio" id="stoff" name="status" value="0" <c:if test="${cate.status == 0}">checked</c:if>> 
        <label for="stoff">Khóa</label><br>
        
        <input type="submit" value="Update">
    </form>
    
</body>
</html>
	