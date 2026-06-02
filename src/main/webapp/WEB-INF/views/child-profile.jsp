<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html lang="fr">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Profil Enfant - DenKɔlɔsi</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/child-profile.css">

</head>

<body>

	<div class="container-fluid">

		<div class="row">

			<!-- SIDEBAR -->
			<aside class="col-lg-3 col-xl-2 sidebar p-0">

				<div class="p-4">

					<div class="logo text-center mb-5">

						<a class="navbar-brand custom-brand" href="#"> <img
							src="${pageContext.request.contextPath}/assets/brand/Group 39.svg"
							width="60">
						</a> <a class="navbar-brand custom-brand" href="#"> <img
							src="${pageContext.request.contextPath}/assets/brand/logoName.svg"
							width="120">
						</a>

					</div>

					<ul class="nav flex-column">

						<li class="nav-item mb-3"><a
							href="${pageContext.request.contextPath}/dashboard"
							class="nav-link"> <i class="bi bi-grid"></i> Dashboard
						</a></li>

						<li class="nav-item mb-3"><a href="#" class="nav-link active">
								<i class="bi bi-people"></i> Mes enfants
						</a></li>

						<li class="nav-item mb-3"><a href="#" class="nav-link"> <i
								class="bi bi-gear"></i> Paramètres
						</a></li>

						<li class="nav-item mt-5"><a href="#"
							class="nav-link text-danger"> <i
								class="bi bi-box-arrow-right"></i> Déconnexion
						</a></li>

					</ul>

				</div>

			</aside>

			<!-- MAIN CONTENT -->
			<main class="col-lg-9 col-xl-10 p-4">

				<!-- HEADER -->
				<div class="d-flex justify-content-between align-items-center mb-4">

					<div class="flex">
						<a href="${pageContext.request.contextPath}/liste-enfant"
							class="btn btn-success"> <i class="bi bi-arrow-left me-2"></i>
							Retour à la liste des enfants
						</a>

					</div>

					<div class="parent-box">

						<img
							src="${pageContext.request.contextPath}/assets/images/image10.png"
							alt="Parent"> <span>Parent A</span>

					</div>

				</div>

				<!-- ENFANT -->

				<div class="child-header">

					<div class="d-flex align-items-center gap-4">

						<img
							src="${pageContext.request.contextPath}/assets/images/image10.png"
							class="child-avatar">

						<div>

							<h3>Awa Traoré</h3>

							<p class="text-muted mb-1">5 ans • Maternelle</p>

							<span class="badge bg-success"> Suivi actif </span>

						</div>

					</div>

					<button class="btn btn-light">

						<i class="bi bi-three-dots-vertical"></i>

					</button>

				</div>

				<!-- MENU INTERNE -->

				<div class="profile-menu">

					<a href="#" class="active"> Vue d'ensemble </a> <a href="#">
						Activités </a> <a href="#"> Croissance </a> <a href="#"> Suivi &
						progrès </a> <a href="#"> Recommandations </a>

				</div>

				<!-- STATISTIQUES -->

				<div class="row g-4 mt-2">

					<div class="col-lg-3">

						<div class="score-card green">

							<h6>Cognitif</h6>

							<h2>85%</h2>

							<span>Excellent</span>

						</div>

					</div>

					<div class="col-lg-3">

						<div class="score-card orange">

							<h6>Intellectuel</h6>

							<h2>78%</h2>

							<span>Bon</span>

						</div>

					</div>

					<div class="col-lg-3">

						<div class="score-card blue">

							<h6>Corporel</h6>

							<h2>82%</h2>

							<span>Bon</span>

						</div>

					</div>

					<div class="col-lg-3">

						<div class="score-card red">

							<h6>Émotionnel</h6>

							<h2>90%</h2>

							<span>Excellent</span>

						</div>

					</div>

				</div>

				<!-- ACTIVITES -->

				<div class="card border-0 shadow-sm mt-4">

					<div class="card-body">

						<div class="d-flex justify-content-between mb-3">

							<h5>Activités récentes</h5>

							<a href="#"> Voir tout </a>

						</div>

						<table class="table">

							<thead>

								<tr>

									<th>Activité</th>
									<th>Date</th>
									<th>Score</th>

								</tr>

							</thead>

							<tbody>

								<tr>

									<td>Quiz mémoire</td>
									<td>20 Avril 2026</td>
									<td><span class="badge bg-success"> 85% </span></td>

								</tr>

								<tr>

									<td>Lecture guidée</td>
									<td>18 Avril 2026</td>
									<td><span class="badge bg-primary"> 90% </span></td>

								</tr>

								<tr>

									<td>Logique</td>
									<td>15 Avril 2026</td>
									<td><span class="badge bg-warning"> 75% </span></td>

								</tr>

							</tbody>

						</table>

					</div>

				</div>

				<!-- RECOMMANDATIONS -->

				<div class="card border-0 shadow-sm mt-4">

					<div class="card-body">

						<h5 class="mb-4">Recommandations</h5>

						<div class="alert alert-success">Encourager 15 minutes de
							lecture chaque jour.</div>

						<div class="alert alert-warning">Renforcer les exercices de
							logique.</div>

						<div class="alert alert-info">Maintenir les activités
							physiques.</div>

					</div>

				</div>

			</main>

		</div>

	</div>

</body>

</html>
