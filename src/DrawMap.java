import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;



public class DrawMap extends JFrame{
	
	Browser browser;
	
	public DrawMap(Browser b){
		this.browser = b;
	}
	
	static Image iconToImage(Icon icon) {
		   if (icon instanceof ImageIcon) {
		      return ((ImageIcon)icon).getImage();
		   } 
		   else {
		      int w = icon.getIconWidth();
		      int h = icon.getIconHeight();
		      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		      GraphicsDevice gd = ge.getDefaultScreenDevice();
		      GraphicsConfiguration gc = gd.getDefaultConfiguration();
		      BufferedImage image = gc.createCompatibleImage(w, h);
		      Graphics2D g = image.createGraphics();
		      icon.paintIcon(null, g, 0, 0);
		      g.dispose();
		      return image;
		   }
		 } 

	
	public void paint(Graphics g){
	
		Icon ico = FileSystemView.getFileSystemView().getSystemIcon(browser.Home);

		g.drawImage(iconToImage(ico), (int)(browser.ScrWidth *.5),(int)(browser.ScrHeight *.2),ico.getIconWidth(),ico.getIconHeight(), null);

		for(double i = 0; i < browser.Home.subfiles.size(); i++){
			int j = (int)(i);
			ico = FileSystemView.getFileSystemView().getSystemIcon(browser.Home.subfiles.get(j));
			g.drawImage(iconToImage(ico), (int)(browser.ScrWidth * ((i+1)/10)),(int)(browser.ScrHeight *.3),ico.getIconWidth(),ico.getIconHeight(), null);
			
			for(double k = 0; k < browser.Home.subfiles.get(j).subfiles.size(); k++){
				int l = (int)(k);
				System.out.println(k + "inner");
				ico = FileSystemView.getFileSystemView().getSystemIcon(browser.Home.subfiles.get(j).subfiles.get(l));
				g.drawImage(iconToImage(ico), (int)(browser.ScrWidth * .4),(int)(browser.ScrHeight * (20/k)),ico.getIconWidth(),ico.getIconHeight(), null);

			}
		}
		
	}
}
