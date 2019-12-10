package test;

import java.util.ArrayList;
import java.util.List;

import com.jt.po.User;

public class ListTest {
	public static void main(String[] args) {
		List<User> users=new ArrayList<User>();
		
		User user1=new User(1, "ssss",  "ssss");
		User user2=new User(1, "ssss",  "ssss");
		User user3=new User(1, "ssss",  "ssss");
		User user4=new User(1, "ssss",  "ssss");
		User user5=new User(1, "ssss",  "ssss");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
	
		for (int i = 0; i < users.size(); i++) {
			
			User user=users.get(i);
			System.out.println(user.getUsername());
		}
	
	}

}
