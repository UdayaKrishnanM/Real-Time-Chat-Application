🚀 Built Real-Time Chat with Spring Boot + WebSockets + Redis (Scalable like WhatsApp)
Today I took a deep dive into real-time systems and built a fully scalable chat application using:
 🔹 Spring Boot (WebSocket + STOMP)
 🔹 Redis Pub/Sub
 🔹 SockJS + STOMP JS on the frontend
 🔹 Docker-based Redis for local development
What I loved most about this project was understanding how large-scale messaging platforms really work behind the scenes.
🔥 Key Highlights
📡 Real-Time Messaging: Messages fly instantly between users via WebSockets.
 🔀 Redis Pub/Sub for horizontal scaling: Messages are published to Redis and broadcast across instances — the same pattern behind WhatsApp, Slack & Discord.
 👤 Private & Group Chat:
Group: /topic/public
Private DM: /user/{id}/queue/messages
 🐳 Redis in Docker: One command (docker compose up -d) brings up the pub/sub layer.
 ☁️ Production Architecture Experience: Came away with a solid grasp of how to build distributed WebSocket systems that scale.
💡 Key Learnings
How to set up WebSocket endpoints in Spring
STOMP routing semantics: /app, /topic, /user
DTO → JSON → Redis → WebSocket message flow
Redis Pub/Sub as a message backbone
Managing many WebSocket sessions & subscribers
Private vs broadcast communications in real-time apps
End-to-end debugging of a live chat system
🔧 Tech Stack
Java 21 | Spring Boot 3 | Redis | Docker | WebSocket | STOMP | HTML/JavaScript
🎯 Why I Built It
To upgrade my backend architecture know-how, explore real-time systems, and build something I can include as a standout project.
Check out the full source code here: https://lnkd.in/g6MP7bPc
If you’d like to dive deeper into the architecture, explore the code, or collaborate on similar projects — drop me a DM! Always open to connect and learn from others. 🤝
