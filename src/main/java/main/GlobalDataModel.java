package main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GlobalDataModel {
	
	private Map<Integer, PostModel> postMap;
	
	public GlobalDataModel(){
		postMap = new HashMap<>();
		Integer i = 0;
		PostModel post = new PostModel();
		post.post = "This means you have started the server successfully!!";
		postMap.put(i, post);
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
}
