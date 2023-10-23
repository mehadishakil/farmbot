# Farmbot
An Android Application for IoT-Based Wireless Agricultural Robot


## Introduction

Farmbot is an innovative Android application designed to enhance traditional farming techniques and improve crop production through IoT-based wireless agricultural robots. This project aims to aid farmers by providing real-time data on moisture levels, soil pH, temperature, humidity, and the presence of flammable gases across different areas of the farm. The application connects to a radio frequency remote-controlled robot equipped with Arduino microcontrollers and ultrasonic sensors.

The key features of Farmbot include:
- Real-time data collection and display on a mobile app.
- User authentication for secure access.
- Connectivity to IoT devices (NodeMCU) for data transmission.
- HTTP requests using Retrofit for communication with NodeMCU's API.
- Data parsing and display.
- Recommendations based on sensor data for informed farming decisions.

## Features

- **User Authentication (Login/Sign up):** Ensure secure access by requiring users to log in or sign up with valid credentials before accessing the app's features.

- **Establishing Connection:** The app scans and connects to the NodeMCU's WiFi network (FARMBOT) for accurate data transmission.

- **HTTP Request Using Retrofit:** Retrofit is used to handle HTTP requests and communicate with NodeMCU's API, making it easy to fetch sensor data.

- **Sending and Receiving Data:** NodeMCU processes the API request, packages the data in JSON format, and responds with the sensor data.

- **Displaying Data and Recommendations:** The app parses JSON data using Retrofit, displays real-time sensor data, and provides recommendations for actions like irrigation and insecticide application based on the collected data.

## Screenshots

![Group 19](https://github.com/mehadishakil/farmbot/assets/112794443/4f6fbc56-5ee6-4de0-8123-96e07eb272c6)

![robot](https://github.com/mehadishakil/farmbot/assets/112794443/bd72e538-7e90-4323-8d63-37ee082fed7e)


## Usage

To use Farmbot, follow these steps:
1. Clone the repository to your local machine.
2. Open the Android project in Android Studio.
3. Build and run the app on an Android device.
4. Log in with valid credentials.
5. Connect to the NodeMCU's WiFi network (FARMBOT).
6. Access real-time sensor data and receive recommendations for farming decisions.

## Contribution

Feel free to contribute to this project.
