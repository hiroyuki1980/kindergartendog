<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kinderログイン</title>
</head>
<body>


<h2>ショッピングサイト ログイン画面</h2>
<h5>会員IDとパスワードを入力してください。</h5>

<c:out value="${message}"/>

<div class="col-xs-12 col-md-6">
 <form action="LoginServlet" method="post">
   <div class="form-group">
    	<label for="InputName">会員ID</label>
    	<input type="text" class="form-control" name="userName" id="InputName" placeholder="会員IDを入力してください。">
   </div>
   <div class="form-group">
    	<label for="InputPassword">Password</label>
    	<input type="password" class="form-control" name="password" id="InputPassword" placeholder="パスワードを入力してください">
   </div>
  		<button class="btn btn-primary active btn-sm"  type="submit">ログイン</button>
  </form>
 </div>
</body>
</html>