# AndroidApp4
SuperPodcast Android App
# SuperPodcast

SuperPodcast is an Android application developed as part of **AndroidApp4**.

The app allows users to search for podcasts, view podcast information, subscribe to podcasts, and play podcast episodes.

The application uses the **iTunes Search API** to retrieve podcast data.

## Features

* Search for podcasts using the iTunes Search API
* Display podcast search results
* View podcast information
* Subscribe to podcasts
* View subscribed podcasts
* Play podcast episodes
* Use advanced or unusual search criteria
* Filter podcast results
* Navigate between different screens
* Retrieve online data from an external API

## Advanced Search

SuperPodcast can include additional search and filtering options such as:

* Regular expression search
* Filtering podcasts by number of words in the title
* Sorting podcast results
* Searching podcasts using specific keywords
* Filtering results using custom criteria

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Android Navigation
* REST API
* iTunes Search API
* Git
* GitHub

## Project Structure

```text
AndroidApp4/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/superpodcast/
│           │       ├── data/
│           │       ├── model/
│           │       ├── network/
│           │       ├── screens/
│           │       ├── navigation/
│           │       └── viewmodel/
│           └── AndroidManifest.xml
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Main Components

### Data

Contains classes responsible for retrieving and managing podcast data.

### Model

Contains the data models used to represent podcasts and podcast episodes.

### Network

Contains the classes responsible for communicating with the iTunes Search API.

### Screens

Contains the user interface screens developed with Jetpack Compose.

Possible screens include:

* Search Screen
* Podcast Details Screen
* Subscriptions Screen
* Player Screen

### ViewModel

Manages application data and UI state.

### Navigation

Handles navigation between the different screens of the application.

## API

SuperPodcast uses the iTunes Search API to retrieve podcast information.

Example search:

```text
https://itunes.apple.com/search?term=technology&media=podcast
```

The API returns podcast information in JSON format.

## GitHub Repository

Repository name:

```text
AndroidApp4
```

The project uses GitHub as the remote origin repository.

## Project Objective

The objective of this project is to apply the concepts covered in the **PodPlay tutorial** while creating a customized podcast application.

The project focuses on implementing the core functionality rather than creating a fully polished application.

## Learning Objectives

Through this project, I will practice:

* Connecting an Android application to an online API
* Parsing JSON data
* Managing application state
* Creating multiple screens
* Implementing navigation
* Using ViewModel
* Working with asynchronous data
* Playing audio content
* Managing podcast subscriptions
* Using Git and GitHub for version control

## Development Status

This project is currently under development.

The main goal of this assignment is to implement the core functionality. Additional improvements and UI polishing will be completed in the next assignment.

## Author

**Marcel Azambou**

Android Development Student

****
