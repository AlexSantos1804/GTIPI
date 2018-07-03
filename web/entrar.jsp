
<%@page import="java.util.ArrayList"%>
<%@page import="javax.ejb.Timer"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="persistencia.CidadeBD"%>
<%@page import="dominio.Cidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Adrians Tur</title>
<!-- Meta tag Keywords -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--// Meta tag Keywords -->

	<!-- Recent Trips section css files-->
	<link rel="stylesheet" href="css/owl.carousel.css" type="text/css" media="all">
	<link href="css/owl.theme.css" rel="stylesheet">
	<!-- //Recent Trips section css files -->

	<!-- Testimonials -->
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	<!-- //Testimonials -->

	<!-- css files -->
	<link rel="stylesheet" href="css/bootstrap.css"> <!-- Bootstrap-Core-CSS -->
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
	<link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->

	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=cyrillic,cyrillic-ext,latin-ext,vietnamese" rel="stylesheet">

	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
	<!-- //web-fonts -->
	
</head>

<body>
   
    <div class="header">
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<h1><a href="index.jsp">Adrians Tur</a></h1>
		</div>
		<div class="top-nav-text">
			
		</div>
	
	</nav>
</div>
    
    	<!-- js -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap --> 
	<!-- //js -->	

	<!--  Testimonials js-->
	<script defer src="js/jquery.flexslider.js"></script>
	<!--Start-slider-script-->
		<script type="text/javascript">
		
		$(window).load(function(){
		  $('.flexslider').flexslider({
			animation: "slide",
			start: function(slider){
			  $('body').removeClass('loading');
			}
		  });
		});
	  </script>
	<!--End-slider-script-->
	<!--  //Testimonials js-->

	<!-- Recent Trips js file-->
	<script src="js/owl.carousel.js"></script>
		<!-- Recent Trips Script-->
		<script>
		$(document).ready(function() { 
			$("#owl-demo").owlCarousel({
		 
				autoPlay: 3000, //Set AutoPlay to 3 seconds
				autoPlay:true,
				items : 3,
				itemsDesktop : [640,5],
				itemsDesktopSmall : [414,4]
		 
			});
			
		}); 
		</script>
		<!-- //Recent Trips section Script-->
	<!-- //Recent Trips js file-->

	<!-- start-smoth-scrolling -->
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
	</script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
	
	<script src="js/responsiveslides.min.js"></script>
	<script>
		$(function () {
			$("#slider").responsiveSlides({
				auto: true,
				pager:false,
				nav: true,
				speed: 1000,
				namespace: "callbacks",
				before: function () {
					$('.events').append("<li>before event fired.</li>");
				},
				after: function () {
					$('.events').append("<li>after event fired.</li>");
				}
			});
		});
	</script>
       <%
        String erro = request.getParameter("erro");
        if (erro !=null){
        if (erro.equals("USUARIO_NAO_EXISTE")){
        %>
        Esse usuario nao existe
        <%
            }
        }
        %>
        <form name="formLogin" method="post" action="logar.jsp">
            <label>Login<label/>
            <input type="text" name="login" placeholder="usuario" required="" />
            <label>Senha</label>
            <input type="password" name="senha" placeholder="senha" required=""/>
            
            <input type="submit" name="entrar" value="Entrar"/>
        </form>
    </body>
</body>
</html>