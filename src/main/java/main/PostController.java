package main;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	GlobalDataModel dataModel;

	@RequestMapping("/getPost/{postId}")
	public String index(@PathVariable("postId") String postId) {
		logError(postId);
		
		Integer postIdInt;
		try{
			postIdInt = Integer.getInteger(postId);
		} catch (NumberFormatException e){
			logError(e.getMessage());
			return null;
		}
		
		if(dataModel == null){
			return initilize();
		}
		return dataModel.getPostString(postIdInt);
	}
	
	private String initilize(){
		dataModel = new GlobalDataModel();
		return dataModel.getPostString(0);
	}
	
	//temporary
	private void logError(String msg){
		System.out.println("Error: " + msg);
	}
}
