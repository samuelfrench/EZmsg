package main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GlobalDataModel {
	
	private Map<Integer, PostModel> postMap;
	
	public GlobalDataModel(){
		postMap = new HashMap<>();
		addPost(0,"1st Post");
		addPost(1,"2nd Post");
	}
	
	public PostModel getPost(Integer postId){
		return postMap.get(postId);
	}
	
	public String getPostString(Integer postId){
		try{
			return postMap.get(postId).getPost();
		} catch (NullPointerException e){
			//log error - TODO
			return "NOT FOUND ERROR!";
		}
	}
	
	private void addPost(Integer index, String message){
		PostModel post = new PostModel();
		if(message == null){
			message = "This means you have started the server successfully!!";
		}
		post.post = message;
		//Integer i = postMap.keySet().size();
		postMap.put(index, post);
	}
}
