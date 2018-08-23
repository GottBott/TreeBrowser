import java.io.File;
import java.util.ArrayList;


public class SysFile extends File {
	
	
	public ArrayList<SysFile> subfiles;
	
	public SysFile(String pathname) {
		super(pathname);
		this.subfiles = new ArrayList<SysFile>();
	}
	
	
	
	

}
