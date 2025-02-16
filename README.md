# Concert Ticket Booking System

A web application for buying concert tickets online, built with Java JPA.

## 🎯 Project Status
- [x] Project structure setup
- [x] Database configuration
- [x] Entity creation
- [ ] DAO classes implementation
- [ ] Service layer implementation
- [ ] API endpoints
- [ ] User interface
- [ ] Payment integration
- [ ] Testing
- [ ] Documentation

## 🚀 Features

### User Features
- [ ] Concert Search and Browsing
    - [ ] Event details display
    - [ ] Price, date filters
- [ ] Ticket Purchase
    - [ ] Email ticket delivery


### Organizer Features
- [ ] Event Management
    - [ ] Create, modify, delete events
    - [ ] Manage event details
    - [ ] Ticket stock management


### Admin Features (Perspectives)
- [ ] Event Moderation
    - [ ] Event validation
    - [ ] Content moderation

## 🛠 Technical Requirements

### Prerequisites
- Java 17+
- Maven
- MySQL/HSQLDB
- Postman (for API testing)

### Tech Stack
- Frontend: HTML5, CSS3, JavaScript (React.js/Angular)
- Backend: Java (JPA)
- Database: MySQL/PostgreSQL

## 🚦 Getting Started

### Database Setup
1. Launch the database server:
```bash
./run-hsqldb-server.sh
```

2. Launch the database manager:
```bash
./show-hsqldb.sh
```

### Installation Steps
1. Clone the repository:
```bash
git clone https://github.com/yeoem-dev/JaxRSOpenAPI.git
```

2. Configure database connection in `persistence.xml`

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn jetty:run
```

### Access Points
- API: http://localhost:8111/api
- API Documentation: http://localhost:8111/api-docs (not available yet 😉)

## 📝 Next Steps
- [ ] Complete ticket management system
- [ ] Develop front-end interface
- [ ] Set up automated testing


## 🤝 Contributing
Powered by Emmanuel Yéo @yeoem-dev
Supervised by Adrien Le Roch @aleroch
