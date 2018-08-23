

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.io.File;

import javax.swing.JFrame;


public class Browser {
	
	public SysFile Home;
	public double ScrHeight;
	public double ScrWidth;
	static int x =0;
	
	
	public SysFile GetHomeDirectory(){
		return new SysFile(System.getProperty( "user.home" ));
		
	}
	public Browser(){
		this.Home = GetHomeDirectory();
	}
	
	
	public static SysFile buildTree(SysFile f){
		x++;
		if(x <1000){
			File[] files = f.listFiles();
			for(int i = 0; i < f.listFiles().length; i++){
				SysFile n = new SysFile(files[i].getPath());
				if(n.isHidden() == false){
					f.subfiles.add(n);
					System.out.println(n.getPath());
				}
//				if(n.listFiles() != null)
//					buildTree(n);
			}
		
	
			return f;
		}
		return f;
	}
	
	
	

	public static void main(String[] args){
		Browser b = new Browser();
		DrawMap m = new DrawMap(b);
		m.setTitle("TREE MAP");
		m.setBackground(Color.WHITE);
		m.setExtendedState(Frame.MAXIMIZED_BOTH);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		Dimension size = m.getBounds().getSize();
		b.ScrHeight = size.getHeight();
		b.ScrWidth = size.getWidth();
		buildTree(b.Home);
	}

}
