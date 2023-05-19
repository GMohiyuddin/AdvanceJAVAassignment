<%@page import="Dao.CustomerDao"%>
<%@page import="Model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Bootie Ecommerce</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Bootstrap Core CSS -->
<link href="Admin/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<!-- Custom CSS -->
<link href="Admin/css/style.css" rel='stylesheet' type='text/css' />
<link href="Admin/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="Admin/js/jquery.min.js"></script>
<!----webfonts--->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<script src="Admin/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Admin-Home.jsp">Bootie Ecommerce</a>
            </div>
           
            <!-- /.navbar-header -->
          
			<form class="navbar-form navbar-right">
              <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search...';}">
            </form>
            <% String Email = (String) request.getAttribute("Email"); %>
			<%-- <% out.print(Email); %> --%>
            
              <ul class="nav navbar-nav navbar-right">
			    <li class="dropdown">
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="https://i.pinimg.com/originals/5c/89/de/5c89de5b52165f998c117167eb380278.jpg"><span class="badge">9</span></a>
	      		</li>
			</ul>
			
			
			
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="Admin-Home.jsp"><i class="fa fa-home fa-fw nav_icon"></i>Dashboard</a>
                        </li>
                        <li>
                            <a href="Admin-Seller-List.jsp"><i class="fa fa-users nav_icon"></i>Sellers</a>
                        </li>
                        <li class="active">
                            <a href="Admin-Customer-List.jsp"><i class="fa fa-users nav_icon"></i>Customers</a>
                        </li>
                        <li>
                            <a href="Admin-Product-List.jsp"><i class="fa fa-shopping-cart nav_icon"></i>Products</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope nav_icon"></i>Mailbox</a>
                        </li>
                         <li>
                            <a href="Admin-Total-Payment-List.jsp"><i class="fa fa-inr nav_icon"></i>Payments</a>
                        </li>
                        <li>
                            <a href="Admin-Logout.jsp"><i class="fa fa-power-off nav_icon"></i>Logout</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

<% int ID = Integer.parseInt(request.getParameter("ID")); %>
<% Customer c = CustomerDao.getCustomerByID(ID); %>

<div id="page-wrapper">
        <div class="graphs">
	     <div class="xs">
  	       <h3 class="text-center"> <%=c.getName()%>'s Forms</h3><br>
  	         <div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
						
							<form action="CustomerController" method="post" class="form-horizontal">
								
								<div class="form-group">
									<label for="disabledinput" class="col-sm-2 control-label">ID</label>
									<div class="col-sm-8">
										<input disabled="" type="text" class="form-control1" id="disabledinput" name="ID" value="<%=c.getId()%>">
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Name</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" name="Name" value="<%=c.getName()%>">
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Contact</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" name="Contact" value="<%=c.getContact()%>">
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Address</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" name="Address" value="<%=c.getAddress()%>">
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">Email</label>
									<div class="col-sm-8">
										<input type="email" class="form-control1" id="focusedinput" name="Email" value="<%=c.getEmail()%>">
									</div>
								</div><br>
								
								<div class="form-group text-center">
									<label for="focusedinput" class="col-sm-4 control-label"></label>
									<div class="col-sm-3 ">
										<input type="submit" class="form-control1" id="focusedinput" value="Admin Update" name="action">
									</div>
								</div>
								
							</form>
						</div>
					</div>
					
  </div>
  <div class="copy_layout">
      <p>© 2023 Bootie Ecommerce | All Rights Reserved | Design by DK	 </p>
  </div>
  </div>
      </div>
      
      
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- Nav CSS -->
	<link href="Admin/css/custom.css" rel="stylesheet">
	<!-- Metis Menu Plugin JavaScript -->
	<script src="Admin/js/metisMenu.min.js"></script>
	<script src="Admin/js/custom.js"></script>
</body>
</html>