package encode;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;;

public class EncodePassword {

	
	public static void main(String[] args) {
		ShaPasswordEncoder a=new ShaPasswordEncoder();
		System.out.println("-------------------------------------------");
		//System.out.println("admin:"+a.encodePassword("admin", "admin"));
		System.out.println("a:"+a.encodePassword("zhang.p", "zhang.p"));
		
		
	}

}
