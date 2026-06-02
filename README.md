# 🧠 Gestion Enfant – Projet Java Web (MVC)

## 📘 Description
Application web Java basée sur l’architecture **MVC (Model–View–Controller)**.  
Elle permet la gestion des enfants, des activités, des conseils et des rappels médicaux.  
Le projet utilise **Jakarta Servlet**, **JSP**, **Tomcat**, et **MySQL** pour la base de données.

---

## 🧩 Structure du projet
src/
└── main/
├── java/
│    └── com.denkolochi/
│         ├── configuration/      → Fichiers de configuration (connexion DB, constantes)
│         │     ├── ConnexionDB.java
│         │     └── DbConstConfig.java
│         ├── controller/         → Servlets (logique de contrôle)
│         ├── dao/                → Accès aux données (CRUD)
│         ├── enumeration/        → Énumérations (types, statuts, rôles)
│         ├── model/              → Classes métier (Enfant, Parent, Activité, etc.)
└── webapp/
├── META-INF/
├── WEB-INF/
│     ├── lib/               → Dépendances (JAR)
│     └── views/             → Fichiers JSP
└── web.xml                  → Descripteur de déploiement


---
## Place vous sur votre branch pour ne pas cree de probleme 

## ⚙️ Configuration initiale

### 1️⃣ Créez votre fichier `.gitignore` à la racine du projet :
```gitignore
# Eclipse
/.metadata/
/.settings/
/.project
/.classpath

# Build
/bin/
/target/
/build/

# Tomcat / Servers
/Servers/

# Logs
*.log

# OS files
.DS_Store
Thumbs.db

# Db configuration file
src/main/java/com/denkolochi/configuration/DbConstConfig.java

Créez votre classe DbConstConfig dans le package com.denkolochi.configuration :
package com.denkolochi.configuration;

public class DbConstConfig {
    public static final String url = "jdbc:mysql://localhost:3306/Suivi_enfant?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8&allowPublicKeyRetrieval=true";
    public static final String utilisateur = "";
    public static final String mot_de_passe = "";
}
 Remplissez vos identifiants MySQL personnels (utilisateur, mot_de_passe) avant d’exécuter le projet.

 
