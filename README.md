# Multi-user-chat-server-using-TCP-protocol-

A chat application consists of a chat server and a chat client. The server accepts connections from  the client and delivers all messages from each client to other. This is a tool to communicate with  other people over internet in real time. The client is implemented using two threads - one thread  to interact with the server and the other with the standard input. Two threads are needed because  a client must communicate with the server and, simultaneously, it must be ready to read messages  from the standard input to be sent to the server.The server is implemented using threads also. It  uses a separate thread for each connection. It spawns a new client thread every time a new  connection from a client is accepted 


 Algorithm  
• Multichat server 
1. The server runs an infinite loop to keep accepting incoming requests. 
2. When a request comes, it assigns a new thread to handle the communication part 3. Communicate with clients 
• Multichat client 
1) Create client socket 
2) Create thread to accept input from keyboard 
3) Create thread to interact with server 
4) Repeat until “quit” encounters 
