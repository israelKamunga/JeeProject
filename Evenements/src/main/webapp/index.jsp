<%@ page import="com.evenements.evenements.Entities.User" %>
<%@ page import="com.evenements.evenements.Entities.DataBase.DataBaseDaoImpl" %>
<%@ page import="com.evenements.evenements.Entities.Evenment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Eventoz : Home</title>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/icon" href="assets/images/favicon.ico"/>
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Slick slider -->
    <link href="assets/css/slick.css" rel="stylesheet">
    <!-- Theme color -->
    <link id="switcher" href="assets/css/theme-color/default-theme.css" rel="stylesheet">

    <!-- Main Style -->
    <link href="assets/css/style.css" rel="stylesheet">

    <!-- Fonts -->

    <!-- Open Sans for body font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700,800" rel="stylesheet">
	<!-- Montserrat for title -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

	  <script src="static/script.js" defer></script>
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <style>
	  .addButton{
		  display: flex;
		  justify-content: center;
		  align-items: center;
		  position: fixed;
		  z-index: 10000;
		  background-color: #EE3268;
		  width: 60px;
		  height: 60px;
		  border-radius: 100%;
	  }
	  .addButton img{
		  width: 90px;
	  }
	  .description{
		  display: flex;
		  align-items: center;
	  }
	  .description img{
		  margin-right: 10px;
	  }
  </style>
  <body>
  	<!-- JAVA CODE -->
	<%
		String EmailAdress = request.getParameter("EmailAdress");
		String Password = request.getParameter("Password");
		String reponse = "";
		DataBaseDaoImpl database = new DataBaseDaoImpl();
		User user = database.getUserByUserAddressMail(EmailAdress);

		List<Evenment> evenments = database.getAllEvents();
	%>
	<div class="addButton" id="addButton">
		<img src="static/PlusIcon.svg" class="mx-auto w-25">
	</div>
  	<!-- Start Header -->
	<header id="mu-hero" class="" role="banner">
		<!-- Start menu  -->
		<nav class="navbar navbar-fixed-top navbar-default mu-navbar">
		  	<div class="container">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>

			      <!-- Logo -->
			      <a class="navbar-brand" href="index.jsp">Events</a>

			    </div>

			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      	<ul class="nav navbar-nav mu-menu navbar-right">
			      		<li><a href="#mu-hero">Accueil</a></li>
				        <li><a href="#mu-about">Evenments</a></li>
				        <li><a href="#mu-schedule">Calendrier</a></li>
			            <li><a href="#mu-speakers">Speakers</a></li>
			            <li><a href="#mu-register">Register</a></li>
			            <li><a href="#mu-contact">Contact</a></li>
			      	</ul>
			    </div><!-- /.navbar-collapse -->
		  	</div><!-- /.container-fluid -->
		</nav>
		<!-- End menu -->

		<div class="mu-hero-overlay">
			<div class="container">
				<div class="mu-hero-area">

					<!-- Start hero featured area -->
					<div class="mu-hero-featured-area">
						<!-- Start center Logo -->
						<div class="mu-logo-area">
							<!-- text based logo -->
							<a class="mu-logo" href="#">Events</a>
							<!-- image based logo -->
							<!-- <a class="mu-logo" href="#"><img src="assets/images/logo.jpg" alt="logo img"></a> -->
						</div>
						<!-- End center Logo -->

						<div class="mu-hero-featured-content">

							<h1>SALUT! BIENVENUE SUR "EVENTS"</h1>
							<h2>La platforme de publication de vos évènements</h2>

							<div class="mu-event-counter-area">
								<div id="mu-event-counter">
									
								</div>
							</div>

						</div>
					</div>
					<!-- End hero featured area -->

				</div>
			</div>
		</div>
	</header>
	<!-- End Header -->
	
	<!-- Start main content -->
	<main role="main">
		<!-- Start About -->
		<section id="mu-about">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="mu-about-area">
							<!-- Start Feature Content -->
							<%
								for(Evenment evenment:evenments){
							%>
							<div class="row" style="margin-bottom: 20px;">
								<div class="col-md-6">
									<div class="mu-about-left">
										<img class="" src="assets/images/about.jpg" alt="Men Speaker">
									</div>
								</div>
								<div class="col-md-6">
									<div class="mu-about-right">
										<h2><%=evenment.getTitre()%></h2>
										<p><%=evenment.getDescription()%></p>
										<div class="description date"><img src="static/EventIcon.svg"><p><%=evenment.getDate()%></p></div>
										<div class="description time"><img src="static/clockIcon.svg"><p><%=evenment.getTime()%></p></div>
										<div class="description location"><img src="static/location.svg"><p><%=evenment.getLieu()%></p></div>
										<div class="description capacity"><img src="static/person.svg"><p><%=evenment.getCapacite()%></p></div>
									</div>
								</div>
							</div>
							<%break;
								}%>
							<!-- End Feature Content -->

						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End About -->

		<!-- Start Video -->
		<!-- End Video -->

		<!-- Start Schedule  -->
		<section id="mu-schedule">
			<div class="container">
				<div class="row">
					<div class="colo-md-12">
						<div class="mu-schedule-area">

							<div class="mu-title-area">
								<h2 class="mu-title">Calendrier</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis unde, ut sapiente et voluptatum facilis consectetur incidunt provident asperiores at necessitatibus nulla sequi voluptas libero quasi explicabo veritatis minima porro.</p>
							</div>

							<div class="mu-schedule-content-area">
								<!-- Nav tabs -->
								<!--<ul class="nav nav-tabs mu-schedule-menu" role="tablist">
								    <li role="presentation" class="active"><a href="#first-day" aria-controls="first-day" role="tab" data-toggle="tab">1 Day / 19 Feb</a></li>
								    <li role="presentation"><a href="#second-day" aria-controls="second-day" role="tab" data-toggle="tab">2 Day / 20 Feb</a></li>
								    <li role="presentation"><a href="#third-day" aria-controls="third-day" role="tab" data-toggle="tab">3 Day / 21 Feb</a></li>
								    
								</ul>-->

								<!-- Tab panes -->
								<div class="tab-content mu-schedule-content">
								    <div role="tabpanel" class="tab-pane fade mu-event-timeline in active" id="first-day">
								    	<ul>
								    		<%
												for(Evenment evenment:evenments){
											%>
											<li>
												<div class="mu-single-event">
													<p class="mu-event-time"><%=evenment.getTime()%></p>
													<h3><%=evenment.getTitre()%></h3>
												</div>
											</li>
											<%}%>
								    	</ul>
								    </div>
								    <div role="tabpanel" class="tab-pane fade mu-event-timeline" id="second-day">
								    	<ul>
								    		<li>
								    			<div class="mu-single-event">
								    				<p class="mu-event-time">9.00 AM</p>
								    				<h3>Breakfast</h3>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<img src="assets/images/speaker-1.jpg" alt="event speaker">
								    				<p class="mu-event-time">10.00 AM</p>
								    				<h3>Advanced SVG Animations</h3>
								    				<span>By Karl Groves</span>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<img src="assets/images/speaker-2.jpg" alt="event speaker">
								    				<p class="mu-event-time">11.00 AM</p>
								    				<h3>Presenting Work with Confidence</h3>
								    				<span>By Sarah Dransner</span>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<img src="assets/images/speaker-3.jpg" alt="event speaker">
								    				<p class="mu-event-time">12.00 AM</p>
								    				<h3>Keynote on UX & UI Design</h3>
								    				<span>By Ned Stark</span>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<p class="mu-event-time">1.00 PM</p>
								    				<h3>The End</h3>
								    			</div>
								    		</li>
								    	</ul>
								    </div>
								    <div role="tabpanel" class="tab-pane fade mu-event-timeline" id="third-day">
								    	<ul>
								    		<li>
								    			<div class="mu-single-event">
								    				<p class="mu-event-time">9.00 AM</p>
								    				<h3>Breakfast</h3>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<img src="assets/images/speaker-1.jpg" alt="event speaker">
								    				<p class="mu-event-time">10.00 AM</p>
								    				<h3>Advanced SVG Animations</h3>
								    				<span>By Karl Groves</span>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<img src="assets/images/speaker-2.jpg" alt="event speaker">
								    				<p class="mu-event-time">11.00 AM</p>
								    				<h3>Presenting Work with Confidence</h3>
								    				<span>By Sarah Dransner</span>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<img src="assets/images/speaker-3.jpg" alt="event speaker">
								    				<p class="mu-event-time">12.00 AM</p>
								    				<h3>Keynote on UX & UI Design</h3>
								    				<span>By Ned Stark</span>
								    			</div>
								    		</li>
								    		<li>
								    			<div class="mu-single-event">
								    				<p class="mu-event-time">1.00 PM</p>
								    				<h3>The End</h3>
								    			</div>
								    		</li>
								    	</ul>
								    </div>
								    
								</div>

							</div>
							
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Schedule -->

		<!-- Start Speakers -->
		<section id="mu-speakers">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="mu-speakers-area">

							<div class="mu-title-area">
								<h2 class="mu-title">Speakers</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis unde, ut sapiente et voluptatum facilis consectetur incidunt provident asperiores at necessitatibus nulla sequi voluptas libero quasi explicabo veritatis minima porro.</p>
							</div>

							<!-- Start Speakers Content -->
							<div class="mu-speakers-content">

								<div class="mu-speakers-slider">

									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->

									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->


									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->


									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->

									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->

									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->


									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->


									<!-- Start single speaker -->
									<div class="mu-single-speakers">
										<img src="assets/images/speaker-1.jpg" alt="speaker img">
										<div class="mu-single-speakers-info">
											<h3>Israel Kamunga</h3>
											<p>Software Engineer</p>
											<ul class="mu-single-speakers-social">
												<li><a href="#"><i class="fa fa-facebook"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"></i></a></li>
												<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- End single speaker -->
								</div>
							</div>
							<!-- End Speakers Content -->

						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Speakers -->

		<!-- Start Pricing  -->

		<!-- Start Register  -->
		<section id="mu-register">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="mu-register-area">

							<div class="mu-title-area">
								<h2 class="mu-title">Ajouter un évènement</h2>
							</div>

							<div class="mu-register-content">
								<form class="mu-register-form" method="get" action="connexion.jsp">

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">                
												<input type="text" class="form-control" placeholder="Titre" id="name" name="titre" required="">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">                
												<input type="text" class="form-control" placeholder="Description" id="email" name="description" required="">
											</div>     
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<input type="date" class="form-control" placeholder="Your Phone Number" id="telephone" name="date" required="">
											</div>
										</div>
										<div class="col-md-6">
										<div class="form-group">
											<input type="datetime-local" class="form-control" placeholder="Your Phone Number" id="telephone" name="date" required="">
										</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Lieu" name="location" required="">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<input type="number" class="form-control" placeholder="Capacité" id="telephone" name="capacite" required="">
											</div>
										</div>
									</div>

									<button type="submit" class="mu-reg-submit-btn">SUBMIT</button>

					            </form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Register -->



		<!-- Start Contact -->
		<section id="mu-contact">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="mu-contact-area">

							<div class="mu-title-area">
								<h2 class="mu-heading-title">Contact Us</h2>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever</p>
							</div>

							<!-- Start Contact Content -->
							<div class="mu-contact-content">
								<div class="row">

								<div class="col-md-12">
									<div class="mu-contact-form-area">
										<div id="form-messages"></div>
											<form id="ajax-contact" method="post" action="mailer.php" class="mu-contact-form">
												<div class="form-group">                
													<input type="text" class="form-control" placeholder="Name" id="name" name="name" required>
												</div>
												<div class="form-group">                
													<input type="email" class="form-control" placeholder="Enter Email" id="email" name="email" required>
												</div>              
												<div class="form-group">
													<textarea class="form-control" placeholder="Message" id="message" name="message" required></textarea>
												</div>
												<button type="submit" class="mu-send-msg-btn"><span>SUBMIT</span></button>
								            </form>
										</div>
									</div>
								</div>
							</div>
							<!-- End Contact Content -->
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Contact -->

	</main>
	
	<!-- End main content -->	
			
			
	<!-- Start footer -->
	<footer id="mu-footer" role="contentinfo">
			<div class="container">
				<div class="mu-footer-area">
					<div class="mu-footer-top">
						<div class="mu-social-media">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-google-plus"></i></a>
							<a href="#"><i class="fa fa-linkedin"></i></a>
							<a href="#"><i class="fa fa-youtube"></i></a>
						</div>
					</div>
					<div class="mu-footer-bottom">
						<p class="mu-copy-right">&copy; Copyright <a rel="nofollow" href="http://markups.io">markups.io</a>. All right reserved.</p>
					</div>
				</div>
			</div>

	</footer>
	<!-- End footer -->

	
	
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- Bootstrap -->
    <script src="assets/js/bootstrap.min.js"></script>
	<!-- Slick slider -->
    <script type="text/javascript" src="assets/js/slick.min.js"></script>
    <!-- Event Counter -->
    <script type="text/javascript" src="assets/js/jquery.countdown.min.js"></script>
    <!-- Ajax contact form  -->
    <script type="text/javascript" src="assets/js/app.js"></script>
  
       
	
    <!-- Custom js -->
	<script type="text/javascript" src="assets/js/custom.js"></script>

  </body>
</html>