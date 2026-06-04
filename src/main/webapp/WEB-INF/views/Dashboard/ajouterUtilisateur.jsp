<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DenKolosi - Ajouter Utilisateur</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
<style>

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Montserrat', sans-serif;
}
html, body {
    height: 100%;
    background-color: #e2e8f0;
}

.app-container {
    display: flex;
    width: 100%;
    height: 100vh;
    background-color: #edf2f7;
    overflow: hidden;
}

       
.sidebar {
    width: 200px;
    height: 742px;
    background-color: #2E9E3E; /* Vert DenKolosi */
    color: #ffffff;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 40px 0 30px 0;
    height: 100%;
    flex-shrink: 0;
}
.profile-container {
    text-align: center;
    margin-bottom: 40px;
}

.profile-avatar-wrapper {
    width: 110px;
    height: 110px;
    background-color: #ffffff;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 auto 14px auto;
}

.profile-avatar {
    width: 96px;
    height: 96px;
    background-color: #60a5fa;
    border-radius: 50%;
    display: flex;
    align-items: flex-end;
    justify-content: center;
    overflow: hidden;
}

.profile-avatar i {
    font-size: 70px;
    color: #ffffff;
    margin-bottom: -5px;
}

div .photo-profil{
    width: 100px;
    height: 100px;
    margin: 10px 40px 0px 30px;
    border-radius: 50%;
    border: #fff 15px solid;
}
.profile-name {
    margin-right: 15px;
    font-size: 16px;
    font-weight: 500;
    letter-spacing: 0.3px;
}

.sidebar-menu {
    width: 100%;
    list-style: none;
}

.menu-item {
   width: 100%;  
   margin-bottom: 8px;
}

.menu-link {
    display: flex;
    align-items: center;
    gap: 14px;
    padding: 15px 5px;
    color: #ffffff;
    text-decoration: none;
    font-size: 14px;
    font-weight: 500;
    border-radius: 30px 0 0 30px;
    transition: background-color 0.2s ease, padding-left 0.2s ease, color 0.2s ease;
    }

.menu-link:not(.active):hover {
    background-color: rgba(255, 255, 255, 0.15);
    padding-left: 24px;
}

.menu-link i {
    font-size: 16px;
    width: 20px;
}

.logout-container {
    margin-top: auto;
    width: 100%;
    padding-left: 30px;
}

.logout-btn {
    display: flex;
    align-items: center;
    gap: 10px;
    color: #ffffff;
    text-decoration: none;
    font-size: 13px;
    font-weight: 600;
    letter-spacing: 0.8px;
    transition: opacity 0.2s ease;
}

.logout-btn:hover {
    opacity: 0.8;
}
        
.logout-btn i {
    transition: transform 0.2s ease;
}
        
.logout-btn:hover i {
    transform: scale(1.1);
}

.main-content {
    flex: 1;
    display: flex;
    flex-direction: column;
    padding: 30px 40px;
    overflow-y: auto;
    height: 100%;
}

.topbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #ffffff;
    padding: 16px 30px;
    border-radius: 16px;
    margin-bottom: 40px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.02);
}
.search-box {
    position: relative;
    width: 280px;
}

.search-box input {
    width: 100%;
    padding: 10px 20px;
    padding-right: 45px;
    background-color: #e2e8f0;
    border: none;
    border-radius: 24px;
    font-size: 14px;
    outline: none;
    color: #475569;
}

.search-box i {
    position: absolute;
    right: 18px;
    top: 50%;
    transform: translateY(-50%);
    color: #94a3b8;
    font-size: 14px;
}

.form-section {
    display: flex;
    flex-direction: column;
    flex: 1;
}

.logo{
    width: 90px;
    height: 90px;
    margin: 10px 15px 0px 30px;
}

.section-badge {
    align-self: flex-start;
    background-color: #1d80e2;
    color: #ffffff;
    padding: 10px 20px;
    border-radius: 8px;
    font-size: 14px;
    font-weight: 500;
    margin-bottom: 35px;
    box-shadow: 0 2px 4 rgba(29, 128, 226, 0.15);
}

.form-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    column-gap: 50px;
    row-gap: 28px;
    margin-bottom: 40px;
}

.form-group {
    display: flex;
    flex-direction: column;
    gap: 8px;
}

.form-group label {
    font-size: 13px;
    font-weight: 600;
    color: #334155;
    padding-left: 4px;
}

.form-group input {
    width: 100%;
    padding: 14px 22px;
    background-color: #ffffff;
    border: 1px solid #cbd5e1;
    border-radius: 30px; 
    font-size: 13px;
    color: #1e293b;
    outline: none;
    transition: border-color 0.2s ease, box-shadow 0.2s ease;
}

.form-group input:hover {
    border-color: #94a3b8;
}

.form-group input:focus {
    border-color: #1d80e2;
    box-shadow: 0 0 0 4px rgba(29, 128, 226, 0.15);
    background-color: #ffffff;
}

.form-group input::placeholder {
    color: #94a3b8;
}

.form-actions {
    margin-top: auto;
    display: flex;
    justify-content: flex-end;
    padding-top: 20px;
}

.btn-submit {
    background-color: #28a745;
    color: #ffffff;
    border: none;
    padding: 14px 55px;
    border-radius: 8px;
    font-size: 14px;
    font-weight: 600;
    cursor: pointer;
    box-shadow: 0 2px 4px rgba(40, 167, 69, 0.2);
    transition: background-color 0.2s ease, transform 0.1s ease, box-shadow 0.2s ease;
}

.btn-submit:hover {
    background-color: #218838;
    box-shadow: 0 4px 8px rgba(40, 167, 69, 0.3);
}

.btn-submit:active {
    transform: scale(0.98);
    box-shadow: 0 1px 2px rgba(40, 167, 69, 0.2);
}

</style>
</head>
<body>

    <div class="app-container">
        
        <aside class="sidebar">
            <div class="profile-container">
                <div><img src="assets/images/__MY HAPPY PLACE__.jpg" alt="photo-profil" class="photo-profil"></div>
                <h3 class="profile-name">Hamath Diallo</h3>
            </div>

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
        </aside>

        <main class="main-content">
            
            <div class="topbar">
                <div class="logo-area">
                    <img src="assets/images/logo.png" alt="" class="logo">
                </div>
                <div class="search-box">
                    <input type="text" placeholder="Rechercher">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </div>
            </div>

            <div class="form-section">
                <div class="section-badge">Gestion des Utilisateurs</div>
                
                <form class="form-grid" onsubmit="event.preventDefault();">
                    <div class="form-group">
                        <label>Nom</label>
                        <input type="text" placeholder="Veuillez saisir le nom de l'utilisateur">
                    </div>
                    
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" placeholder="Veuillez saisir le email de l'utilisateur">
                    </div>
                    
                    <div class="form-group">
                        <label>Prenom</label>
                        <input type="text" placeholder="Veuillez saisir le prenom de l'utilisateur">
                    </div>
                    
                    <div class="form-group">
                        <label>Telephone</label>
                        <input type="tel" placeholder="Veuillez saisir le numero de telephone de l'utilisateur">
                    </div>
                    
                    <div class="form-group">
                        <label>Mot de Passe</label>
                        <input type="password" placeholder="Veuillez saisir le mot de passe de l'utilisateur">
                    </div>
                    
                    <div class="form-group">
                        <label>Role</label>
                        <input type="text" placeholder="Veuillez saisir le role de l'utilisateur">
                    </div>
                </form>

                <div class="form-actions">
                    <button type="submit" class="btn-submit">Ajouter</button>
                </div>
            </div>

        </main>
    </div>

</body>
</html>