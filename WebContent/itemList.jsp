<?xml version="1.0" encoding="UTF-8" ?>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Kinderアイテム</title>
</head>
<body>

<div class="table-responsive">
 <h2>ショッピングサイト</h2>
 　<h5>商品ページへようこそ！</h5>
<div class="container-fluid">
<div class="row sampleRow">
<!--第一セクション--><div class="col-xs-12 col-md-10">

 <table class="table table-striped table-condensed table-hover">
       <tr>
           <th scope="row">商品名</th>
           <th scope="row">税込価格</th>
           <th scope="row">品質</th>
		<th scope="row">ランク</th>
		<th scope="row">写真</th>
		<th scope="row">購入ボタン</th>
       </tr>
       <c:forEach items="${items}" var="items" varStatus="status">
	<tr>
		 <td>${items.getItem_name()}</td>
	     <td>${items.getPrice()}</td>
	     <td>${items.getQuality()}</td>
	     <td>${items.getRank()}</td>
	     <td>photo</td>
		<form action="./confirm.jsp">
			<input type="hidden" name="itemId" value="${items.getItem_id() }">
	    	<td><button class="btn btn-info active" type="submit">購入</button></td>
		 </form>
	</tr>
	</c:forEach>
 </table>
</div><!--第一セクション-->

<!--第二セクション--><div class="col-xs-12 col-md-2">
***広告枠***
</div><!--第二セクション-->
</div>
</div>
</body>
</html>