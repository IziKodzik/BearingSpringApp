package service.implementation;
import com.google.gson.Gson;
import dao.UsersDao;
import model.DTOs.Request.ClientActionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

@Service("fakeUserService")
public class CoordinatesUserServiceImpl
    implements UserService {

    private final String userResources="src/main/webapp/resources/images/app-views/";
    private final UsersDao usersDao;
    Gson g = new Gson();
    @Autowired
    public CoordinatesUserServiceImpl(@Qualifier("fakeDao") UsersDao usersDao) throws SocketException {
        this.usersDao = usersDao;
    }


    @Override
    public BufferedImage click(int userId, int x, int y) throws IOException {

        ClientActionRequest clientActionRequest = new ClientActionRequest("",x,y,userId);
        return sendRequest(g.toJson(clientActionRequest));

    }

    @Override
    public BufferedImage fill(int userId, String content) {

        return null;
    }

    @Override
    public BufferedImage clickThenFill(int userId, int x, int y, String content) {

        return null;
    }

    @Override
    public BufferedImage action() throws IOException {

        return null;
    }



    private BufferedImage sendRequest(String message) throws IOException {

        Socket socket = new Socket("localhost",2137);
        OutputStream output = socket.getOutputStream();
        InputStream input = socket.getInputStream();
        byte[] data = ByteBuffer.allocate(4).putInt(message.length()).array();
        output.write(data);
        data = message.getBytes();
        output.write(data);
        data = new byte[4];
        int read = input.read(data);
        data = new byte[ByteBuffer.wrap(data).asIntBuffer().get()];
        read = input.read(data);

        return ImageIO.read(new ByteArrayInputStream(data));

    }
}
