<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>DenKɔlɔsi</title>

<!-- Google Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body>

	<!-- ================= NAVBAR ================= -->

	<nav
		class="navbar navbar-expand-lg navbar-light  bg-white py-3 shadow-sm">
		<div class="container">
			<div class="logo">
				<a class="navbar-brand custom-brand" href="#"> <img
					src="${pageContext.request.contextPath}/assets/brand/Group 39.svg" alt="image" width="60" height="50">
				</a> <a class="navbar-brand custom-brand" href="#"> <img
					src="${pageContext.request.contextPath}/assets/brand/logoName.svg"
					alt="" width="90" height="60">
				</a>
			</div>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav">

				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbarNav">

				<ul class="navbar-nav mx-auto">

					<li class="nav-item"><a class="nav-link active"
						href="/Gestion_enfant">Accueil</a></li>

					<li class="nav-item"><a class="nav-link" href="#">Activités</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#">Fonctionnalités</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#">À propos</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>

				</ul>

				<a href="#" class="btn btn-login me-2"> Connexion </a> <a href="#"
					class="btn btn-register"> Inscription </a>

			</div>
		</div>
	</nav>


	<!-- ================= HERO SECTION ================= -->
	<section class="hero-section">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6">
					<h1 class="hero-title">Suivi intelligent du développement de
						l’enfant</h1>

					<p class="hero-text">DenKɔlɔsi aide les parents et éducateurs à
						suivre le développement cognitif, intellectuel, émotionnel et
						corporel des enfants.</p>
					<div class="mt-4">

						<a href="#" class="btn btn-main me-3"> Commencer gratuitement
						</a> <a href="#" class="btn btn-outline-custom"> Découvrir les
							fonctionnalités </a>

					</div>
				</div>
				<div class="col-lg-6 text-center">

					<img
						src="${pageContext.request.contextPath}/assets/images/image02.png"
						class="img-fluid hero-image" alt="Hero Image">

				</div>
			</div>
		</div>
	</section>

	<!-- ================= STATS ================= -->
	<section class="stats-section">

		<div class="container">

			<div class="row">

				<!-- CARD 1 -->
				<div class="col-md-3">

					<div class="stat-card">

						<i class="bi bi-people"></i>

						<div class="stat-text">

							<h2>500+</h2>

							<p>Enfants suivis</p>

						</div>

					</div>

				</div>

				<!-- CARD 2 -->
				<div class="col-md-3">

					<div class="stat-card">

						<i class="bi bi-person-hearts"></i>

						<div class="stat-text">

							<h2>500+</h2>

							<p>Parents utilisateurs</p>

						</div>

					</div>

				</div>
				<!-- CARD 3 -->
				<div class="col-md-3">

					<div class="stat-card">

						<i class="bi bi-book"></i>

						<div class="stat-text">

							<h2>500+</h2>

							<p>Parents utilisateurs</p>

						</div>

					</div>

				</div>
				<!-- CARD 4 -->
				<div class="col-md-3">

					<div class="stat-card">

						<i class="bi bi-patch-check"></i>

						<div class="stat-text">

							<h2>500+</h2>

							<p>Parents utilisateurs</p>

						</div>

					</div>

				</div>

			</div>

		</div>

	</section>


	<!-- ================= Activity ================= -->

	<section class="features-section py-4">

		<div class="container">

			<h3 class="section-title text-center fw-bold mb-5">Toutes les
				activités adaptées à vos enfants</h3>

			<!-- CAROUSEL -->
			<div id="featureCarousel" class="carousel slide"
				data-bs-ride="carousel">

				<!-- CAROUSEL CONTENT -->
				<div class="carousel-inner">

					<!-- SLIDE 1 -->
					<div class="carousel-item active">

						<div class="row g-4 justify-content-center">

							<!-- CARD 1 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-cpu-fill"></i>

									<h4>Développement cognitif</h4>

									<p>Suivi de la mémoire, de l’attention, de la logique et de
										la résolution de problèmes.</p>

								</div>

							</div>

							<!-- CARD 2 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-mortarboard"></i>

									<h4>Développement intellectuel</h4>

									<p>Évaluation des capacités d’apprentissage, lecture,
										écriture et raisonnement.</p>

								</div>

							</div>

							<!-- CARD 3 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-heart-fill"></i>

									<h4>Développement émotionnel</h4>

									<p>Analyse des émotions, de la motivation et du
										comportement.</p>

								</div>

							</div>

							<!-- CARD 4 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-activity"></i>

									<h4>Développement corporel</h4>

									<p>Suivi de la croissance, des activités physiques et du
										bien-être général.</p>

								</div>

							</div>

						</div>

					</div>

					<!-- SLIDE 2 -->
					<div class="carousel-item">

						<div class="row g-4 justify-content-center">

							<!-- CARD 1 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-puzzle"></i>

									<h4>Quiz éducatifs</h4>

									<p>Exercices interactifs adaptés à l’âge et au niveau de
										chaque enfant.</p>

								</div>

							</div>

							<!-- CARD 2 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-bar-chart"></i>

									<h4>Suivi des progrès</h4>

									<p>Visualisez l’évolution et les performances de votre
										enfant.</p>

								</div>

							</div>

							<!-- CARD 3 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-lightbulb"></i>

									<h4>Recommandations</h4>

									<p>Suggestions personnalisées pour améliorer les capacités
										de l’enfant.</p>

								</div>

							</div>

							<!-- CARD 4 -->
							<div class="col-lg-3 col-md-6">

								<div class="feature-card">

									<i class="bi bi-bell"></i>

									<h4>Rappels intelligents</h4>

									<p>Notifications et rappels d’activités importantes pour
										les parents.</p>

								</div>

							</div>

						</div>

					</div>
				</div>
				<!-- INDICATORS -->
				<div class="carousel-indicators custom-indicators">

					<button type="button" data-bs-target="#featureCarousel"
						data-bs-slide-to="0" class="active"></button>

					<button type="button" data-bs-target="#featureCarousel"
						data-bs-slide-to="1"></button>

				</div>
			</div>

		</div>

	</section>

	<!-- ================= FEATURES ================= -->

	<section class=" py-4">

		<div class="container">

			<h2 class="section-title fw-bold text-center">Comment fonctionne
				DenKɔlɔsi ?</h2>

			<div class="row mt-5">

				<div class="col-lg-3 col-md-6">

					<div class="feature-cards">

						<!-- IMAGE -->
						<div class="img-card">

							<img
								src="${pageContext.request.contextPath}/assets/images/image03.png"
								alt="Créer un compte" class="img-fluid">

						</div>

						<!-- TITLE -->
						<h4>Créez un compte</h4>

						<!-- DESCRIPTION -->
						<p>Inscrivez-vous facilement et créez votre espace parental
							sécurisé.</p>

					</div>

				</div>

				<div class="col-lg-3 col-md-6">

					<div class="feature-cards">

						<!-- IMAGE -->
						<div class="img-card">

							<img
								src="${pageContext.request.contextPath}/assets/images/image04.png"
								alt="Créer un compte" class="img-fluid">

						</div>

						<!-- TITLE -->
						<h4>Ajoutez votre enfant</h4>

						<!-- DESCRIPTION -->
						<p>Renseignez les informations et personnalisez son profil de
							développement.</p>

					</div>

				</div>
				<div class="col-lg-3 col-md-6">

					<div class="feature-cards">

						<!-- IMAGE -->
						<div class="img-card">

							<img
								src="${pageContext.request.contextPath}/assets/images/image05.png"
								alt="Créer un compte" class="img-fluid">

						</div>

						<!-- TITLE -->
						<h4>Commencez les activités</h4>

						<!-- DESCRIPTION -->
						<p>Accédez à des activités adaptées à l’âge et aux besoins de
							votre enfant.</p>

					</div>

				</div>
				<div class="col-lg-3 col-md-6">

					<div class="feature-cards">

						<!-- IMAGE -->
						<div class="img-card">

							<img
								src="${pageContext.request.contextPath}/assets/images/image06.png"
								alt="Créer un compte" class="img-fluid">

						</div>

						<!-- TITLE -->
						<h4>Suivez les progrès</h4>

						<!-- DESCRIPTION -->
						<p>Analysez les résultats et recevez des recommandations
							personnalisées.</p>

					</div>

				</div>

			</div>

		</div>

		</div>

	</section>

	<!-- ================= Explication ================= -->
	<section class="explication-section">
		<div class="container">
			<div class="row align-items-center py-4">
				<div class="col-lg-6 mx-4">
					<img
						src="${pageContext.request.contextPath}/assets/images/image07.png"
						class="img-fluid hero-image"
						alt="Un tableau de bord intelligent pour les parents">
				</div>
				<div class="col-lg-5 ml-4">
					<h3>Un tableau de bord intelligent pour les parents</h3>
					<p>Visualisez les progrès de votre enfant à travers des
						graphiques clairs, des rapports détaillés et des recommandations
						personnalisées.</p>
					<ul class="list-expl list-unstyled">
						<li><i class="bi bi-check-lg"></i> Suivi en temps réel</li>
						<li><i class="bi bi-check-lg"></i> Rapports détaillés</li>
						<li><i class="bi bi-check-lg"></i> Recommandations adaptées</li>
						<li><i class="bi bi-check-lg"></i> Alertes et rappels
							intelligents</li>
					</ul>
					<a href="#" class="btn btn-main me-3"> Commencer gratuitement </a>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
	</section>
	<!-- ================= TESTIMONIAL SECTION ================= -->

	<section class="testimonial-section py-4">

		<div class="container">

			<!-- TITLE -->
			<h2 class="text-center fw-bold mb-5">Ce que disent les parents</h2>

			<!-- ROW -->
			<div class="row g-4">

				<!-- CARD 1 -->
				<div class="col-lg-4 col-md-6">

					<div class="testimonial-card h-100 border rounded-4 p-4 bg-white">

						<!-- STARS -->
						<div class="stars text-warning fs-3 mb-3">★ ★ ★ ★ ★</div>

						<!-- TEXT -->
						<p class="testimonial-text mb-4">DenKɔlɔsi m’aide à comprendre
							les besoins de mon enfant et à suivre ses progrès facilement.</p>

						<!-- USER -->
						<div class="d-flex align-items-center gap-3">

							<img
								src="${pageContext.request.contextPath}/assets/images/image10.png"
								alt="Parent" class="rounded-circle" width="70" height="70">

							<div>

								<h5 class="fw-bold mb-0">Aminata K.</h5>

								<span class="text-muted"> Maman de 2 enfants </span>

							</div>

						</div>

					</div>

				</div>

				<!-- CARD 2 -->
				<div class="col-lg-4 col-md-6">

					<div class="testimonial-card h-100 border rounded-4 p-4 bg-white">

						<div class="stars text-warning fs-3 mb-3">★ ★ ★ ★ ★</div>

						<p class="testimonial-text mb-4">Les activités sont adaptées
							et les conseils personnalisés sont très utiles au quotidien.</p>

						<div class="d-flex align-items-center gap-3">

							<img
								src="${pageContext.request.contextPath}/assets/images/image10.png"
								alt="Parent" class="rounded-circle" width="70" height="70">

							<div>

								<h5 class="fw-bold mb-0">Fatou N.</h5>

								<span class="text-muted"> Maman de 1 enfant </span>

							</div>

						</div>

					</div>

				</div>

				<!-- CARD 3 -->
				<div class="col-lg-4 col-md-6">

					<div class="testimonial-card h-100 border rounded-4 p-4 bg-white">

						<div class="stars text-warning fs-3 mb-3">★ ★ ★ ★ ★</div>

						<p class="testimonial-text mb-4">Une plateforme simple et
							efficace pour suivre l’évolution intellectuelle et émotionnelle.
						</p>

						<div class="d-flex align-items-center gap-3">

							<img
								src="${pageContext.request.contextPath}/assets/images/image10.png"
								alt="Parent" class="rounded-circle" width="70" height="70">

							<div>

								<h5 class="fw-bold mb-0">Mariam T.</h5>

								<span class="text-muted"> Maman de 3 enfants </span>

							</div>

						</div>

					</div>

				</div>

			</div>

		</div>

	</section>

	<!-- ================= RECOMMENDATION ================= -->

	<section class="recommendation-section py-4">

		<div class="container">

			<div class="recommendation-box rounded-4 px-4">

				<div class="row align-items-center g-4">

					<!-- LEFT -->
					<div class="col-lg-4">

						<div class="d-flex gap-3">

							<!-- ICON -->
							<div
								class="recommendation-icon d-flex align-items-center justify-content-center rounded-circle">

								<i class="bi bi-lightbulb-fill text-warning fs-2"></i>

							</div>

							<!-- TEXT -->
							<div>

								<h3 class="fw-bold mb-3">Des recommandations intelligentes
								</h3>

								<p class="text-muted mb-0">Notre système analyse les
									performances de votre enfant et propose des activités adaptées
									pour renforcer ses capacités et combler ses lacunes.</p>

							</div>

						</div>

					</div>

					<!-- IMAGE -->
					<div class="col-lg-3 text-center">

						<img
							src="${pageContext.request.contextPath}/assets/images/image08.png"
							alt="Recommendation" class="img-fluid" style="max-width: 220px;">

					</div>

					<!-- LIST -->
					<div class="col-lg-3">

						<ul class="list-unstyled m-0">

							<li class="mb-3 d-flex align-items-center gap-2"><i
								class="bi bi-check-square-fill text-success"></i> Suggestions
								personnalisées</li>

							<li class="mb-3 d-flex align-items-center gap-2"><i
								class="bi bi-check-square-fill text-success"></i> Activités
								adaptées à l’âge</li>

							<li class="d-flex align-items-center gap-2"><i
								class="bi bi-check-square-fill text-success"></i> Suivi continu
								des progrès</li>

						</ul>

					</div>

					<!-- BUTTON -->
					<div class="col-lg-2 text-lg-end text-center">

						<a href="#" class="btn btn-success px-4 py-3 rounded-3 fw-bold">

							En savoir plus </a>

					</div>

				</div>

			</div>

		</div>

	</section>
	<!-- ================= CTA ================= -->

	<section class="cta-section py-4">

		<div class="container">

			<div class="recommendationv-box rounded-4 px-4">

				<div class="row align-items-center g-4">

					<!-- Texte -->
					<div class="col-lg-4">

						<h3 class="text-white fw-bold mb-3">Prêt à accompagner votre
							enfant vers un meilleur avenir ?</h3>

						<p class="text-white mb-0">Rejoignez DenKɔlɔsi dès aujourd'hui
							et faites la différence chaque jour dans le développement de
							votre enfant.</p>

					</div>

					<!-- Illustration -->
					<div class="col-lg-3 text-center">

						<img
							src="${pageContext.request.contextPath}/assets/images/image09.png"
							class="img-fluid" alt="Famille">

					</div>

					<!-- Boutons -->
					<div class="col-lg-5">

						<div
							class="d-flex flex-column flex-md-row justify-content-lg-end gap-3">


							<a href="#" class="btn btn-cta me-3"> 
							Créer un compte gratuit 
							</a> <a href="#" class="btn btn-outline-cta"> Nous contacter </a>

						</div>

					</div>

				</div>
			</div>

		</div>

	</section>
	<!-- ================= FOOTER ================= -->

	<footer class="footer-section pt-5 pb-3">
	<hr class="my-4">

		<div class="container">

			<div class="row gy-4">

				<!-- Logo -->
				<div class="col-lg-4">

					<div class="logo">
						<a class="navbar-brand custom-brand" href="#"> <img
							src="${pageContext.request.contextPath}/assets/brand/Group 39.svg"
							alt="" width="60" height="50">
						</a> <a class="navbar-brand custom-brand" href="#"> <img
							src="${pageContext.request.contextPath}/assets/brand/logoName.svg"
							alt="" width="90" height="60">
						</a>
					</div>

					<p class="footer-desc">Suivi intelligent du développement de
						l'enfant</p>

					<div class="social-links d-flex gap-3 mt-4">

						<a href="#"> <i class="bi bi-facebook fs-3 text-primary"></i>
						</a> <a href="#"> <i class="bi bi-instagram fs-3 text-danger"></i>
						</a> <a href="#"> <i class="bi bi-linkedin fs-3 text-primary"></i>
						</a>

					</div>

				</div>

				<!-- Liens -->
				<div class="col-lg-2 col-md-6">

					<h5 class="fw-bold mb-3">Produit</h5>

					<ul class="list-unstyled">

						<li><a href="#">Fonctionnalités</a></li>
						<li><a href="#">Activités</a></li>
						<li><a href="#">Tableau de bord</a></li>
						<li><a href="#">Rapports</a></li>

					</ul>

				</div>

				<div class="col-lg-2 col-md-6">

					<h5 class="fw-bold mb-3">Entreprise</h5>

					<ul class="list-unstyled">

						<li><a href="#">À propos</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Partenaires</a></li>

					</ul>

				</div>

				<div class="col-lg-2 col-md-6">

					<h5 class="fw-bold mb-3">Support</h5>

					<ul class="list-unstyled">

						<li><a href="#">Centre d'aide</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Confidentialité</a></li>
						<li><a href="#">Conditions</a></li>

					</ul>

				</div>

				<div class="col-lg-2 col-md-6">

					<h5 class="fw-bold mb-3">Ressources</h5>

					<ul class="list-unstyled">

						<li><a href="#">Guides parents</a></li>
						<li><a href="#">Actualités</a></li>
						<li><a href="#">Conseils</a></li>
						<li><a href="#">Documentation</a></li>

					</ul>

				</div>

			</div>


			<div class="text-center">

				<p class="mb-0">© 2026 DenKɔlɔsi. Tous droits réservés.</p>

			</div>

		</div>

	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>