<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Admin</title>
    <link rel="stylesheet" href="assets/css/gestion-activite.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <header>
          <section>
            <div class="section-div">
                <div><img src="assets/images/__MY HAPPY PLACE__.jpg" alt="" class="photo-profil"></div>
                <div class="nom"><span>Hamath Diallo</span></div>
                <ul class="sidebar-menu">
                <li class="menu-item">
                    <a href="/Gestion-enfant-app-web/ServletDashboardAdmin" class="menu-link">
                        <i class="fa-solid fa-house"></i> Dashboard
                    </a>
                </li>
                <li class="menu-item">
                    <a href="/Gestion-enfant-app-web/ServletExercice" class="menu-link">
                        <i class="fa-solid fa-thumbtack"></i> Gestion des Exercicces
                    </a>
                </li>
                <li class="menu-item">
                    <a href="#" class="menu-link">
                        <i class="fa-regular fa-square-check"></i> Gestion des Quiz
                    </a>
                </li>
                <li class="menu-item">
                    <a href="/Gestion-enfant-app-web/ServletQuiz" class="menu-link">
                        <i class="fa-solid fa-gamepad"></i> Gestion des Jeux
                    </a>
                </li>
                <li class="menu-item">
                    <a href="/Gestion-enfant-app-web/ServletListeUtilisateur" class="menu-link">
                        <i class="fa-solid fa-user-plus"></i> Gestion des Utilisateurs
                    </a>
                </li>
            </ul>
            <div class="logout-container">
                <a href="#" class="logout-btn">
                    <i class="fa-solid fa-power-off"></i> DECONNEXION
                </a>
            </div>
            </div>
        </section>
        <nav>
            <div><img src="assets/images/logo.png" class="logo" alt="Logo"></div>
            <div class="search">
                <input type="text" placeholder="Rechercher">
                <i class="fa-solid fa-magnifying-glass"></i>
            </div>
        </nav>
    </header>
    <main>
        <div class="b">
            <div class="ajouter"><a href="#">Ajouter</a></div>
            <div class="modifier"><a href="#"></a></div>
        </div>

        <div class="cards2">
            <div class="titre2"><p>Listes des Quiz</p></div>
            <div class="card4">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/75524373-9ba5-479c-aae5-0e8c69d91c21.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Quiz 1</span>
            </div>

            <div class="card4">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/kid_puzzle.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Quiz 2</span>
            </div>

            <div class="card4">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/kids_beach.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Quiz 3</span>
            </div>

            <div class="card4">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/kids_beach.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Quiz 4</span>
            </div>

            <div class="card4">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/kids_beach.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Quiz 5</span>
            </div>

            <div class="card4">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
               <div class="img-card"><img src="assets/images/kids_beach.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Quiz 6</span>
            </div>
        </div>
    </main>
</body>
</html>