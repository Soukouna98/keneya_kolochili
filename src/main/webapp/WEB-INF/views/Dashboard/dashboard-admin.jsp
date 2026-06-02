<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Admin</title>
    <link rel="stylesheet" href="dashboard-admin.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://kit.fontawesome.com/YOUR_KIT_CODE.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
          <section>
            <div class="section-div">
                <div><img src="assets/images/__MY HAPPY PLACE__.jpg" alt="" class="photo-profil"></div>
                <div class="nom"><span>Hamath Diallo</span></div>
                <ul class="sidebar-menu">
                <li class="menu-item">
                    <a href="#" class="menu-link">
                        <i class="fa-solid fa-house"></i> Dashboard
                    </a>
                </li>
                <li class="menu-item">
                    <a href="/Gestion-enfant-app-web/ServletExercice" class="menu-link">
                        <i class="fa-solid fa-thumbtack"></i> Gestion des Exercicces
                    </a>
                </li>
                <li class="menu-item">
                    <a href="/Gestion-enfant-app-web/ServletQuiz" class="menu-link">
                        <i class="fa-regular fa-square-check"></i> Gestion des Quiz
                    </a>
                </li>
                <li class="menu-item">
                    <a href="/Gestion-enfant-app-web/ServletJeu" class="menu-link">
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
        <div class="cards">
            <div class="card1">
                <i class="fa-sharp fa-regular fa-user icone"></i>
                <h2>Utilisateurs</h2>
                <h1>300</h1>
            </div>

            <div class="card2">
                <i class="fa-solid fa-clipboard-list icone"></i>
                <h2>Quiz</h2>
                <h1>35</h1>
            </div>

            <div class="card3">
                <i class="fa-solid fa-gamepad icone"></i>
                <h2>Jeux publiés</h2>
                <h1>15</h1>
            </div>

            <div class="card4">
                <i class="fa-solid fa-pen-to-square icone"></i>
                <h2>Exercices</h2>
                <h1>55</h1>
            </div>

        </div>

        <div class="cards2">
            <p>Listes des activités</p>
            <h3>Voir plus</h3>
            <div class="card5">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/kid_puzzle.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Exercice 1</span>
            </div>
            <div class="card5">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/kid_puzzle.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Quiz 1</span>
            </div>
            <div class="card5">
                <span class="type">Cognitif</span>
                <span class="age">5- 7ans</span>
                <div class="img-card"><img src="assets/images/kid_puzzle.jpg" alt="" class="image-card"></div>
                <span class="nom-type">Jeu 1</span>
            </div>
        </div>
    </main>
</body>
</html>