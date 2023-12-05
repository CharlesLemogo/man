<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Page</title>
</head>
<body>
<h1>Expense Details <a href="/">Go back</a></h1>
<p>Expense Name: <c:out value="${travel.name}" /></p>
<p>Vendor: <c:out value="${travel.vendor}" /> </p>
<p>Description: <c:out value="${travel.description}" /> </p>  
<p>Amount: $<c:out value="${travel.amount}" /></p>
    
    
</body>
</html>
