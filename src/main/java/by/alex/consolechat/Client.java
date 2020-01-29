package by.alex.consolechat;

import sun.security.acl.AclEntryImpl;

import java.io.*;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

public class Client {

	public static void main(String[] args) {
		try (Socket client = new Socket("localhost", 8090)) {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
