📌 Project Introduction: Task Manager
The Task Manager is a Spring Boot + Thymeleaf web application that allows multiple users to:

Sign up with username, email, and password
Log in securely
Create, view, update, and delete tasks
Categorize tasks (Work, Personal, Urgent)
Set priority and status
Manage everything from a simple dashboard
no admin for this project
This is basically a mini project covering the full MVC architecture (Model–View–Controller) with database integration using JPA + Hibernate.

🏗 Project Scheme / Architecture
1️⃣ Backend
Spring Boot Application (entry point with @SpringBootApplication)

Model Layer (Entities)

Users → stores user information (username, email, password)
Tasks → stores task details (title, description, category, priority, status, dates, linked to a user)
Repository Layer (DAO)

UserRepository → DB access for users
TaskRepository → DB access for tasks
Service Layer (Business Logic)

UserService → handles signup, login validation
TaskService → handles CRUD operations for tasks
Controller Layer (Web Layer)

UserController → signup, login, homepage navigation
TaskController → manage tasks (list, add, edit, delete)
2️⃣ Frontend
Thymeleaf Templates in src/main/resources/templates/

tasksmanager/signup.html → signup form
tasksmanager/login.html → login form
taskmanager/auth/homepage.html → dashboard after login
taskmanager/tasks/list.html → view all tasks
taskmanager/tasks/form.html → add/edit task form
Forms bind directly to model objects (Users, Tasks) using th:object and th:field.

3️⃣ Database (MySQL or H2)
Tables

users

id (PK)
username (unique)
email (unique)
password (encrypted later)
tasks

task_id (PK)
title
description
category (Work / Personal / Urgent)
priority (Low / Medium / High)
status (Pending / Completed)
due_date, creation_date, updation_date
user_id (FK → users.id)
Relationship:

One User → Many Tasks
Each task belongs to exactly one User.
4️⃣ Flow of Execution
User Signup → enters details → saved in users table.
User Login → validated against DB → if valid → redirected to homepage.html.
Homepage → shows navigation for task management.
Add Task → form submits new task → saved with logged-in user’s ID.
List Tasks → fetches tasks belonging only to that user.
Edit/Delete Tasks → updates or removes from DB.
⚡ In short, this is a complete CRUD + Authentication project using Spring Boot + JPA + Thymeleaf.

-- to run this in your system step 1 :- download zip file and extract the files step 2 :- install eclipse and import the project into the eclipse ide step 3 :- right click on the project and use maven build step 4 :- change the deatils in appliaction.properties in the project and make sure the mysql path with database name is changed step 4 :- finally run this project using springboot starter

NOTE :- USE CODE WITH CAUTION U MAY ENCOUNTER SOME EXECUTION PROBLEMS DURING COMPILATION IT MAY BE OF ENVIRONMENT SETUP PROBLEMS OR OTHER SO USE AI FOR TO ENCOUNTER THE PROBLEMS
