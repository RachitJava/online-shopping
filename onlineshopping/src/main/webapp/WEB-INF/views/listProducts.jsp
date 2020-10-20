<div class="container">

<div class="row">

<!-- First would be to display sidebar -->

<div class="col-md-3">

<%@include file="./shared/sidebar.jsp" %>

</div>


<!-- Second one to display the actual product -->

<div class="col-md-9">


<!--9 and 3 total 12 hai-Iss tarah humara bootstrap 2 grid ma divide ho gya -->

<!--Hum bootstrap ka breadcrumb component use kar rahe hai Home/Category/Mobile -->

<!--Adding Breadcrumb compnent -->

<div class= "row">

<div class="col-lg-12">

<!--For All Products -->

<c:if test="${userClickAllProducts==true }">

<ol class="breadcrumb">

<li><a href ="${contextRoot}/home">Home</a></li>

<li class="active">All Products</li>

</ol>
</c:if>

<!--For Category -->

<c:if test="${userClickCategoryProducts==true }">

<ol class="breadcrumb">

<li><a href ="${contextRoot}/home">Home</a></li>

<li class="active">Category</li>

<li class="active">${category.name}</li>

</ol>
</c:if>



</div>



</div>





</div>


</div>



</div>