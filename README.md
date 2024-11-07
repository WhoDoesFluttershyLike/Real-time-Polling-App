# Real-time Polling App

## Description

The **Real-time Polling App** is a server-client application designed to demonstrate real-time interaction using WebSockets. This app enables two-way communication between a server and a client, allowing real-time updates for polling data. The server handles the polling logic and broadcasts updates to all connected clients, while the clients can connect, receive live updates, and display real-time poll results.

## Features

- **Real-time Polling**: Clients can see poll results updating live as votes are cast.
- **WebSocket-based Communication**: Bi-directional communication for efficient data exchange between clients and the server.
- **State Management**: The server manages the poll’s state and broadcasts updates to all clients.

## Skills and Technologies Used

- **WebSockets**: Enables continuous, bi-directional communication for real-time data updates.
- **State Management**: Maintains current poll data and results on the server.
- **CLI Frontend**: The client is implemented as a CLI tool for simplicity and ease of interaction.

## Project Flow

1. **Client Connection**: The client connects to the server using WebSocket.
2. **Polling Request**: The client sends a pre-defined request to participate in or view the poll.
3. **Real-time Updates**: The server receives the request, processes poll data, and sends real-time updates back to all connected clients.

While the concept may resemble HTTP-based communication, WebSocket-based implementations allow for instant updates without continuous requests, as the client is always listening for messages from the server.


## Setup and Installation

**1. Clone the Repository**

git clone https://github.com/WhoDoesFluttershyLike/URL-Shortening-Service.git

cd URL-Shortening-Service

**2. Install Dependencies**

mvn clean install

**3. Configure Database**

- Set up a database (MongoDB).

- Add your database configuration in the application.properties. In my case `mongodb://localhost:27017/mongodb`

**4. Run the Server**

mvn spring-boot:run

The application will start on http://localhost:8082

**5. Run the Client**

enter in the browser http://localhost:8082/client.html


