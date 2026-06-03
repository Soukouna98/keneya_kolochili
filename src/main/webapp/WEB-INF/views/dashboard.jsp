<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html lang="fr">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>DenKɔlɔsi - Dashboard Parent</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/dashboard.css">

</head>

<body>

<div class="wrapper">

```
<!-- ================= SIDEBAR ================= -->

<aside class="sidebar">

    <div class="logo text-center mb-4">

       <div class="logo">
				<a class="navbar-brand custom-brand" href="#"> <img
					src="${pageContext.request.contextPath}/assets/brand/Group 39.svg"
					alt="" width="60" height="50">
				</a> <a class="navbar-brand custom-brand" href="#"> <img
					src="${pageContext.request.contextPath}/assets/brand/logoName.svg"
					alt="" width="90" height="60">
				</a>
			</div>

    </div>

    <ul class="nav flex-column sidebar-menu">

        <li class="nav-item">

            <a class="nav-link active" href="#">

                <i class="bi bi-grid-1x2-fill"></i>

                Dashboard

            </a>

        </li>

        <li class="nav-item">

            <a class="nav-link"
               href="${pageContext.request.contextPath}/liste-enfant">

                <i class="bi bi-people-fill"></i>

                Mes enfants

            </a>

        </li>

        <li class="nav-item">

            <a class="nav-link" href="#">

                <i class="bi bi-gear-fill"></i>

                Paramètres

            </a>

        </li>

    </ul>

    <div class="tip-card">

        <i class="bi bi-lightbulb-fill"></i>

        <h6>Conseil du jour</h6>

        <p>
            Encouragez votre enfant à pratiquer
            une activité éducative chaque jour.
        </p>

    </div>

    <div class="logout">

        <a href="#">

            <i class="bi bi-box-arrow-right"></i>

            Déconnexion

        </a>

    </div>

</aside>

<!-- ================= MAIN CONTENT ================= -->

<main class="main-content">

    <!-- HEADER -->

    <div class="topbar">

        <div>

            <h2>Bonjour Parent A </h2>

            <p>
                Bienvenue sur votre espace de suivi.
            </p>

        </div>

        <div class="user-box">

            <img
                src="${pageContext.request.contextPath}/assets/images/image10.png"
                alt="Parent">

            <span>Parent A</span>

        </div>

    </div>

    <!-- KPI -->

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

    <!-- MES ENFANTS -->

    <div class="section-card mt-4">

        <div class="section-header">

            <div>

                <h4>Mes enfants</h4>

                <p>
                    Sélectionnez un enfant pour accéder
                    à son profil détaillé.
                </p>

            </div>

            <button class="btn btn-success">
                Ajouter un enfant
            </button>

        </div>

        <div class="row g-4 mt-2">

            <div class="col-lg-6">

                <div class="child-card">

                    <div class="child-info">

                        <img
                            src="${pageContext.request.contextPath}/assets/images/girl.png"
                            alt="">

                        <div>

                            <h5>Awa Traoré</h5>

                            <p>9 ans • Primaire</p>

                        </div>

                    </div>

                    <div class="child-actions">

                        <a href="${pageContext.request.contextPath}/child-profile"
                           class="btn btn-success">

                            Voir le profil

                        </a>

                        <button class="btn btn-light">

                            <i class="bi bi-pencil"></i>

                        </button>

                        <button class="btn btn-light">

                            <i class="bi bi-three-dots-vertical"></i>

                        </button>

                    </div>

                </div>

            </div>

            <div class="col-lg-6">

                <div class="child-card">

                    <div class="child-info">

                        <img
                            src="${pageContext.request.contextPath}/assets/images/boy.png"
                            alt="">

                        <div>

                            <h5>Moussa Keita</h5>

                            <p>7 ans • Primaire</p>

                        </div>

                    </div>

                    <div class="child-actions">

                        <a href="${pageContext.request.contextPath}/child-profile"
                           class="btn btn-success">

                            Voir le profil

                        </a>

                        <button class="btn btn-light">

                            <i class="bi bi-pencil"></i>

                        </button>

                        <button class="btn btn-light">

                            <i class="bi bi-three-dots-vertical"></i>

                        </button>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <!-- RECOMMANDATIONS -->

    <div class="section-card mt-4">

        <h4 class="mb-4">
            Recommandations générales
        </h4>

        <div class="recommendation success">

            <i class="bi bi-check-circle-fill"></i>

            <div>

                <h6>Lecture quotidienne</h6>

                <p>
                    Encouragez 15 minutes de lecture
                    chaque jour.
                </p>

            </div>

        </div>

        <div class="recommendation warning">

            <i class="bi bi-lightbulb-fill"></i>

            <div>

                <h6>Développement cognitif</h6>

                <p>
                    Renforcez la logique avec des jeux
                    adaptés à l'âge.
                </p>

            </div>

        </div>

    </div>

</main>
```

</div>

<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>
