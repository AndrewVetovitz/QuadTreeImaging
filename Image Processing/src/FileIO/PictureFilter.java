package FileIO;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PictureFilter extends FileFilter {

	private String description = "Image Extensions";
	
	private String[] extensions = {"PNG", "JPG", "RAW", "GIF", "JPRG", "BMP"};
	
	public PictureFilter(){
	}

	@Override
	public boolean accept(File file) {
		if(file.isDirectory()){
			return true;
		} else{
			String path = file.getAbsolutePath();
			for(int i = 0, n = this.extensions.length; i < n; i++){
				String extension = extensions[i];
				if(path.endsWith(extension.toLowerCase()) && ((path.charAt(path.length() - extension.length() - 1)) == '.')){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
