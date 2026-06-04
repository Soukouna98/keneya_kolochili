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
	href="${pageContext.request.contextPath}/assets/css/liste-enfant.css">


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

					<div>
						<h2 class="fw-bold mb-1">Mes enfant</h2>

						<p class="text-muted mb-0">Gérez, suivez et compagnez tout vos
							enfants</p>
					</div>

					<div class="parent-box">

						<img
							src="${pageContext.request.contextPath}/assets/images/image10.png"
							alt="Parent"> <span>Parent A</span>

					</div>

				</div>

				<div class="row g-4">

					<div class="col-lg-3">

						<div class="kpi-card">

							<i class="bi bi-people-fill"></i>

							<h3>2</h3>

							<p>Enfants suivis</p>

						</div>

					</div>

					<div class="col-lg-3">

						<div class="kpi-card">

							<i class="bi bi-clipboard-check-fill"></i>

							<h3>24</h3>

							<p>Activités réalisées</p>

						</div>

					</div>

					<div class="col-lg-3">

						<div class="kpi-card">

							<i class="bi bi-bar-chart-fill"></i>

							<h3>85%</h3>

							<p>Moyenne globale</p>

						</div>

					</div>

					<div class="col-lg-3">

						<div class="kpi-card">

							<i class="bi bi-award-fill"></i>

							<h3>12</h3>

							<p>Objectifs atteints</p>

						</div>

					</div>

				</div>

				<!-- LISTE DES ENFANTS -->
				<div class="mt-5">

					<div class="d-flex justify-content-between align-items-center mb-4">

						<div>
							<h4 class="fw-bold mb-1">Mes enfants</h4>
							<p class="text-muted mb-0">Sélectionnez un enfant pour
								consulter son suivi.</p>
						</div>

						<a href="#" class="btn btn-success"> <i
							class="bi bi-plus-circle me-2"></i> Ajouter un enfant
						</a>

					</div>

					<div class="row g-4">

						<!-- ENFANT 1 -->
						<div class="col-lg-6">

							<div class="card shadow-sm border-0 child-card">

								<div class="card-body">

									<div class="d-flex align-items-center mb-3">

										<img
											src="${pageContext.request.contextPath}/assets/images/enfant1.png"
											class="rounded-circle me-3" width="70" height="70">

										<div>
											<h5 class="fw-bold mb-1">Awa Traoré</h5>
											<span class="text-muted"> 5 ans • 4ème • École Les
												Flamboyants </span>
										</div>

									</div>

									<div class="d-flex gap-2 flex-wrap">

										<a
											href="${pageContext.request.contextPath}/child-profile?childId=1"
											class="btn btn-success"> <i class="bi bi-eye"></i>
											Consulter
										</a>

										<button class="btn btn-warning text-white">
											<i class="bi bi-pencil-square"></i> Modifier
										</button>

										<button class="btn btn-danger">
											<i class="bi bi-trash"></i> Supprimer
										</button>

									</div>

								</div>

							</div>

						</div>

						<!-- ENFANT 2 -->
						<div class="col-lg-6">

							<div class="card shadow-sm border-0 child-card">

								<div class="card-body">

									<div class="d-flex align-items-center mb-3">

										<img
											src="${pageContext.request.contextPath}/assets/images/enfant2.png"
											class="rounded-circle me-3" width="70" height="70">

										<div>
											<h5 class="fw-bold mb-1">Amadou Traoré</h5>
											<span class="text-muted"> 7 ans • CE1 • École Les
												Flamboyants </span>
										</div>

									</div>

									<div class="d-flex gap-2 flex-wrap">

										<a
											href="${pageContext.request.contextPath}/child-profile?childId=2"
											class="btn btn-success"> <i class="bi bi-eye"></i>
											Consulter
										</a>

										<button class="btn btn-warning text-white">
											<i class="bi bi-pencil-square"></i> Modifier
										</button>

										<button class="btn btn-danger">
											<i class="bi bi-trash"></i> Supprimer
										</button>

									</div>

								</div>

							</div>

						</div>

					</div>

				</div>


			</main>

		</div>

	</div>

</body>

</html>
