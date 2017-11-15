<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     
     
     <spring:url var="css" value="/resources/css"></spring:url>
     <spring:url var="js" value="/resources/js"></spring:url>
     <spring:url var="images" value="/resources/images"></spring:url>
     
<!--      
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4-4.0.0-beta/jqc-1.12.3/dt-1.10.16/datatables.min.css"/>
    
   
 
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.0.0-beta/jqc-1.12.3/dt-1.10.16/datatables.min.js"></script>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/esm/popper.js"></script> -->

    
    <c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title} </title>
    
  
  
    
    <script>
    
    window.menu = '${title}';
    window.contextRoot = '${contextRoot}';
    
    </script>
   
 <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">


    
    <!-- Custom styles theme -->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">


	<!-- Bootstrap DataTables -->
 <link href="${css}/dataTable.bootstrap.css" rel="stylesheet">

       <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">


  </head>

  <body>
  <div class="wrapper">

    <!-- Navigation -->
   <%@include file="./shared/navigation.jsp" %>
   
   
   
   
   <!-- Page Content -->
   
   <div class="content">
   <!-- Load Home  Content -->
	<c:if test="${userClickHome == true }">
  		 <%@include file="home.jsp" %>
   </c:if>
   
   <!-- Load About us  Content -->
   <c:if test="${userClickAbout == true }">
  		 <%@include file="about.jsp" %>
   </c:if>
   
   
   <!-- Load Contact us  Content -->
   <c:if test="${userClickContact == true }">
  		 <%@include file="contact.jsp" %>
   </c:if>
   
   <!-- Load on user click product -->
    <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
  		 <%@include file="listProducts.jsp" %>
   </c:if>
   
   
   <!-- Load only when user clicks show product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>	
   
   </div>


    <!-- Footer -->
   <%@include file="./shared/footer.jsp" %>
   
   <script src="${js}/bootstrap.min.js"></script>
    
   
  <!-- Bootstrap core JavaScript -->
  <script src="${js}/jquery.min.js"></script>
     
    
    <!-- My own Script -->
    
 	
    <script src="${js}/data.js"></script>
    <script src="${js}/dataTable.js"></script>
    
    <script src="${js}/dataTable.bootstrap.js"></script>
    
    <script src="${js}/myapp.js"></script>
    
 
 
 

 

</div>
  </body>

</html>