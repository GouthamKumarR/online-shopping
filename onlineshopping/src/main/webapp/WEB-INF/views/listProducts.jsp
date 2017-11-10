<div class="container">

	<div class="row">
	
	<!-- Would be used to display sidebar -->
		<div class="col-md-3">
		<%@include file="./shared/sidebar.jsp" %>
		
		
		</div>
		<div class="col-md-9">
		 <!-- Added breadcrumb component -->
		 <div class="row">
		  <div class="col-lg-12">
		  <c:if test="${userClickAllProducts == true}">
		  	<ol class="breadcrumb">
		  	
		  		<li><a href="${contextRoot}/home">Home</a></li>
		  		<li class="active">All Products</li>
		  		
		  		
		  	</ol>
		  </c:if>
		  
		   <c:if test="${userClickCategoryProducts == true}">
		  	<ol class="breadcrumb">
		  	
		  		<li><a href="${contextRoot}/home">Home</a></li>
		  		<li class="active">/ Category</li>
		  		<li class="active"> ${category.name}</li>
		  		
		  		
		  	</ol>
		  </c:if>
		  
		  
		  </div>
		 
		 
		 
		 </div>
	
	
	<div clss="row">
		
		<div class="col-xs-12">
		
		
			<table id="productListTable" class="table table-striped table-borderd">
			
		<!-- 	<table id="example" class="display" cellspacing="0" width="100%" style="overflow-x:auto"> -->
 
 
 
<thead>
 
 
 
<tr>
 
 
 
<th>Name</th>
 
 
 
 
 
 
<th>Desgination</th>
 
 
 

 
 
</tr>
 
 
 
</thead>
 
 

				
			
			
			</table>
			
		</div>
	</div>
		</div>
	</div>


</div>

