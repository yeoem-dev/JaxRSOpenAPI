# 🎶 Concert Tickets App - Backend (JAX-RS)

Ce projet constitue le backend de l'application **Concert Tickets App**, exposant une API RESTful pour gérer des concerts, des utilisateurs (acheteurs et organisateurs), des billets, et des catégories.

---

## 🛠️ Technologies

- Java 17+
- JAX-RS (Jakarta RESTful Web Services)
- Hibernate (JPA)
- H2 (ou autre SGBD relationnel)
- Maven (build & gestion de dépendances)

---

## 📂 Structure du projet

```
src/
├── concert/                  → Entités JPA : Concert, Billet, Acheteur, Organisateur, etc.
├── dao/generic/             → DAO génériques pour la persistance
├── dto/                     → DTOs pour sérialisation JSON
├── rest/                    → Contrôleurs REST exposant l'API
└── Main.java                → Point d'entrée (si lancement standalone)
```

---

## 🌐 Endpoints disponibles

| Ressource       | Méthode | URL                          | Description                                  |
|----------------|---------|------------------------------|----------------------------------------------|
| Acheteurs       | GET     | `/acheteurs`                 | Liste tous les acheteurs                     |
| Acheteurs       | POST    | `/acheteurs`                 | Crée un nouvel acheteur                     |
| Acheteurs       | GET     | `/acheteurs/{id}`            | Récupère les détails d’un acheteur + billets |
| Organisateurs   | GET     | `/organisateurs`             | Liste tous les organisateurs                |
| Organisateurs   | POST    | `/organisateurs`             | Crée un nouvel organisateur                 |
| Organisateurs   | GET     | `/organisateur/{id}/details` | Récupère les concerts de l’organisateur     |
| Concerts        | GET     | `/concerts`                  | Liste tous les concerts                     |
| Concerts        | POST    | `/concerts`                  | Crée un concert                             |
| Catégories      | GET     | `/categories`                | Liste toutes les catégories                 |
| Catégories      | POST    | `/categories`                | Crée une catégorie                          |
| Billets         | GET     | `/billets`                   | Liste tous les billets                      |
| Billets         | POST    | `/billets`                   | Crée un billet (via ID acheteur/concert/etc)|

---

## ▶️ Démarrage rapide

### 1. Prérequis

- Java 17+
- Maven

### 2. Cloner & compiler

```bash
git clone https://github.com/yeoem-dev/JaxRSOpenAPI
cd JaxRSOpenAPI
mvn clean install
```

### 3. Lancer l’application (ex. via Jetty, TomEE, ou application `main()`)

```bash
mvn jetty:run
```

L’API sera accessible via : `http://localhost:8080`

---

## 🦚 Tests

Les endpoints peuvent être testés avec **Postman** ou en utilisant le frontend disponible [ici](https://github.com/ton-compte/concert-tickets-frontend) (`npm run dev` sur port 5173).

---

## 🔍 Détails supplémentaires

- La stratégie d’héritage `@Inheritance(strategy = InheritanceType.JOINED)` est utilisée pour le polymorphisme Acheteur/Organisateur (entité `Utilisateur`).
- Les entités DTO sont utilisées pour découpler la persistance de l’exposition.
- Une validation simple est intégrée côté API (`null check` dans les `@POST`).

---

## 🧩 Frontend associé

Ce backend est connecté au frontend Vue.js dans le dossier [`concert-tickets-app`](https://github.com/yeoem-dev/concert-tickets-app).

---

## 📄 Licence

MIT © 2025 — [TonNom]

