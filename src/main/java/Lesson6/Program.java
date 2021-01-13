package Lesson6;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Program {
    public static void main(final String[] args) throws IOException {
        socketConnect();
    }

    private static void socketConnect() throws IOException {
        try (final Socket socket = new Socket("localhost", 8080)) {
            final String request = "GET /hello HTTP/1.1\r\nConnection: close\r\nHost:localhost\r\n\r\n";
            final OutputStream outputStream = socket.getOutputStream();
            outputStream.write(request.getBytes(StandardCharsets.US_ASCII));
            final InputStream inputStream = socket.getInputStream();
            final String response = readAsString(inputStream);
            System.out.println(response);
            inputStream.close();
            outputStream.close();
        }
    }

    private static String readAsString(final InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String x;
        while ((x = in.readLine()) != null) {
            sb.append(x).append("\n");
        }
        return sb.toString();
    }
}