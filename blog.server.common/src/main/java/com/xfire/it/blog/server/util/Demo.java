package com.xfire.it.blog.server.util;

public class Demo{
	public static void main(String[] args) {
		//new GrilFriend();
		//GrilFriend her=GrilFriend.her;
		//GrilFriend.her = null;
		GrilFriend her = GrilFriend.getHer();
		//System.out.println();
	}
}

class GrilFriend {
	private static GrilFriend her;
	private GrilFriend(){
	}
	public synchronized static GrilFriend getHer() {
		if(her==null){
			her = new GrilFriend();
		}
		return her;
	}
}
//class GrilFriend {
//	private static GrilFriend her = 
//			new GrilFriend();
//	private GrilFriend(){
//	}
//	public static GrilFriend getHer() {
//		return her;
//	}
//}
