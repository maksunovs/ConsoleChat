package by.alex.consolechat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server;
		Socket client;
		BufferedWriter out;
		BufferedReader in;

		try {
			try {
				server = new ServerSocket(4004);
				System.out.println("Server successfully started");
			} catch (IOException e) {
				System.out.println("Failed to start server: " + e);
				return;
			}
			client = server.accept();

			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			while (server.isBound()) {
				String message = in.readLine();
				System.out.println("Message from client: " + message);

				out.write("Hello client, you sent message: " + message + "\n");
				out.flush();
			}
			System.out.println("server closed");
			out.close();
			in.close();
			client.close();
			server.close();
		} catch (IOException e) {
			System.out.println("Something goes wrong..."+e);
		}

	}
}
