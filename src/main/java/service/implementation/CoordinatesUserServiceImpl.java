package service.implementation;
import com.google.gson.Gson;
import dao.UsersDao;
import model.DTOs.Request.ClientActionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

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
        return sendRequestAndGetImage(g.toJson(clientActionRequest));

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

    private byte[] testSend(String message) throws IOException{

    	Socket socket = new Socket("localhost",2137);
		OutputStream outputStream = socket.getOutputStream();
		InputStream inputStream = socket.getInputStream();

    	byte[] data = message.getBytes();
		outputStream.write(ByteBuffer.allocate(4).putInt(data.length).array());
		outputStream.write(data);
		inputStream.read(data);
		data = new byte[ByteBuffer.wrap(data).asIntBuffer().get()];
		inputStream.read(data);
		return data;

	}

    private BufferedImage sendRequestAndGetImage(String message) throws IOException {

        Socket socket = new Socket("localhost",2137);
        OutputStream output = socket.getOutputStream();
        InputStream input = socket.getInputStream();

        byte[] data = ByteBuffer.allocate(4).putInt(message.length()).array();
        output.write(data);
//        byte[]
		data = message.getBytes();
        output.write(data);
        data = new byte[4];
        int read = input.read(data);
        data = new byte[ByteBuffer.wrap(data).asIntBuffer().get()];
        read = input.read(data);
        socket.close();

        return ImageIO.read(new ByteArrayInputStream(data));

    }

//	private BufferedImage sendRequest(String message) throws IOException {
//
//		Socket socket = new Socket("localhost",2137);
//		OutputStream output = socket.getOutputStream();
//		InputStream input = socket.getInputStream();

//        byte[] data = ByteBuffer.allocate(4).putInt(message.length()).array();
//        output.write(data);
//		data = message.getBytes();
//		output.write(data);
//        data = new byte[4];
//        int read = input.read(data);
//        data = new byte[ByteBuffer.wrap(data).asIntBuffer().get()];
//        read = input.read(data);
//		socket.close();
//
//		return ImageIO.read(new ByteArrayInputStream(data));
//
//	}

	@Override
	public BufferedImage openDesktop(int id) throws IOException {
    	ClientActionRequest actionRequest =
				new ClientActionRequest("open_desktop",id,-1,-1);
		return this.sendRequestAndGetImage(g.toJson(actionRequest,ClientActionRequest.class));
	}

	@Override
	public BufferedImage loadAppView(int id) throws IOException {
		return sendRequestAndGetImage(g.toJson(new ClientActionRequest("send_view",id)));
	}

	@Override
	public BufferedImage reloadAppView(int id) throws IOException {
		return sendRequestAndGetImage(g.toJson(new ClientActionRequest("send_view",id)));
	}
}
