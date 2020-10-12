package service;

import model.User;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public interface UserService {


    BufferedImage click(int id, int x, int y) throws IOException;
    BufferedImage fill(int userId,String content);
    BufferedImage clickThenFill(int userId,int x,int y,String content);
    BufferedImage action() throws IOException;
	BufferedImage openDesktop(int id) throws IOException;
	BufferedImage loadAppView(int id) throws IOException;
	BufferedImage reloadAppView(int id) throws IOException;
}
