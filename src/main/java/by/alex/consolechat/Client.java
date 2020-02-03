package by.alex.consolechat;

import sun.security.acl.AclEntryImpl;

import java.io.*;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

public class Client {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("address: ");
		String address = reader.readLine();
		System.out.print("port: ");
		String port = reader.readLine();
		try (Socket client = new Socket(address, Integer.parseInt(port))) {
			System.out.println("Connected to server (" + address + ":" + port + ")");
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			while (true) {
				String message = reader.readLine();
				if("stop".equals(message)) {
					break;
				}
				out.write(message + "\n");
				out.flush();

				String response = in.readLine();
				System.out.println("server: " + response);
			}
			out.close();
			in.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
