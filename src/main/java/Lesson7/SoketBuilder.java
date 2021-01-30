package Lesson7;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SoketBuilder {
    enum Type {TEXT, JSON}
    private Type type;
    private boolean isGet;
    private String path;
    private String body;
    private String result;
    private String host;
    private StringBuilder params;
    private int port;

    public SoketBuilder() {
        params = new StringBuilder();
        type = Type.TEXT;
    }

    public static SoketBuilder builder() {
        return new SoketBuilder();
    }

    public SoketBuilder soket(String host, int port) {
        this.host = host;
        this.port = port;
        return this;
    }

    public SoketBuilder addRequestParam(String param, String value) {
        if (params.length()==0) {
            params.append("?").append(param).append("=").append(value);
        } else {
            params.append("&").append(param).append("=").append(value);
        }
        return this;
    }

    public SoketBuilder request(String path) {
        this.path = path;
        result = "GET %s HTTP/1.1\r\n" +
                "Host: %s\r\n" +
                "Content-type: %s\r\n" +
                "Connection: close\r\n\r\n";
        isGet = true;
        return this;
    }

    public SoketBuilder request(String path, String body) {
        this.path = path;
        this.body = body;
        result = "POST %s HTTP/1.1\r\n" +
                "Host: %s\r\n" +
                "Content-type: %s\r\n" +
                "Content-Length: %d\r\n" +
                "Connection: close\r\n\r\n" +
                "%s";
        isGet = false;
        return this;
    }

    public SoketBuilder contentType(Type type) {
        this.type = type;
        return this;
    }

    public void build() throws IOException {
        String tmp = type.equals(Type.JSON) ? "application/json" : "text/html";
        if (isGet) {
            result = String.format(result, path+params.toString(), host, tmp);
        } else {
            result = String.format(result, path, host, tmp, body.length(), body);
        }
        try (Socket socket = new Socket(host, port)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(result.getBytes(StandardCharsets.UTF_8));
            InputStream inputStream = socket.getInputStream();
            System.out.println(readAsString(inputStream));
        }
    }

    private String readAsString(final InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String x;
        while ((x = in.readLine()) != null) {
            sb.append(x).append("\n");
        }
        return sb.toString();
    }
}
