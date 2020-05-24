package aiss.model.GoogleDrive;

import static org.junit.Assert.assertNotNull; 
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.GoogleDrive.FileItem;
import aiss.model.GoogleDrive.Files;
import aiss.model.resources.GoogleDriveResource;

public class GoogleDriveTest {

	String token = "ya29.a0AfH6SMBH3x1nw4PlNDl-GgNLeXe8udU69vZFwMZGC2R0n4iGbep0pOEoYhkHqALl7vtYWAZEy9Kk_vxzfio-DP_G-FmrKuvpEVWgWxyj_SOEldRxT-wjzCmDJFHBUOsRB5_IwaEsSDDBoQQkoC_CitoY1HaHzRTfGQY";
	GoogleDriveResource gdr = new GoogleDriveResource(token);
	
	@Test
	public void testGetFiles() throws UnsupportedEncodingException {
		System.out.println("Test Drive: Files of the account with token " + token);
		Files files = gdr.getFiles();
		
		if(files.getItems().isEmpty()) {
			files = null;
		}
		if(files != null) {
			System.out.println("Found!");
		}
		
		assertNotNull("The list with files shouldn't be empty.", files);
	}
	
	@Test
	public void testGetFile() throws UnsupportedEncodingException {
		String search = "jelo";
		System.out.println("Test Drive: File with the name " + search);
		Files files = gdr.getFiles();
		String id = "";
		List<FileItem> f2 = files.getItems();
		for(FileItem f:f2) {
			if(f.getTitle()==search) {
				id.concat(f.getId());
				break;
			}
		}
		FileItem file = gdr.getFile(id);
		
		if(file == null) {
			file = null;
		}
		if(file != null) {
			System.out.println("Found!");
		}
		
		assertNotNull("The file shouldn't be null", file);
	}
	
	@Test
	public void testInsertFile() throws UnsupportedEncodingException {
		String content = "jelo2";
		System.out.println("Test Drive: Insert a file with name and content " + content);
		FileItem file = new FileItem();
		file.setTitle("jelo2");
		String res = gdr.insertFile(file, content);
		
		if(res.isEmpty()) {
			res = null;
		}
		if(res != null) {
			System.out.println("Successfully inserted!");
		}
		
		assertNotNull("The inserted file shouldn't be null", res);
	}
	
	@Test
	public void testUpdateFile() throws UnsupportedEncodingException {
		System.out.println("Test Drive: Update file.");
		Files files = gdr.getFiles();
		List<FileItem> f2 = files.getItems();
		FileItem file = f2.get(0);
		Boolean res = gdr.updateFile(file);
		
		if(res == true) {
			System.out.println("Updated successfully!");
		}
		
		assertTrue("The file wasn't updated correctly", res);
	}
	
	@Test
	public void testDeleteFile() throws UnsupportedEncodingException {
		System.out.println("Test Drive: Deleting file.");
		Files files = gdr.getFiles();
		List<FileItem> f2 = files.getItems();
		String id = f2.get(0).getId();
		Boolean res = gdr.deleteFile(id);
		
		if(res == true) {
			System.out.println("Deleted successfully!");
		}
		
		assertTrue("The file wasn't deleted correctly", res);
	}
	
	@Test
	public void testGetFileContent() throws UnsupportedEncodingException {
		System.out.println("Test Drive: Getting file content.");
		Files files = gdr.getFiles();
		List<FileItem> f2 = files.getItems();
		FileItem file = f2.get(0);
		String res = gdr.getFileContent(file);
		
		if(res.isEmpty()) {
			res = null;
		}
		if(res != null) {
			System.out.println("File content reached!");
		}
		
		assertNotNull("No file content", res);
	}
	
	public void testUpdateFileContent() throws UnsupportedEncodingException {
		System.out.println("Test Drive: Updating file content.");
		Files files = gdr.getFiles();
		List<FileItem> f2 = files.getItems();
		String id = f2.get(0).getId();
		Boolean res = gdr.updateFileContent(id, "jelo4");
		
		if(res = true) {
			System.out.println("Content updated successfully!");
		}
		
		assertTrue("The file content couldn't be updated", res);
	}
}
