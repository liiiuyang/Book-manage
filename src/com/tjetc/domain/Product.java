package com.tjetc.domain;

public class Product {
	//属性
		private int pid;
		private String pname;
		private String price;
		private String photo;
		private String num;
		
		public Product(){
			System.out.println("调用无参构造方法。。。。");
		}
		
		/*public User(int userid,String username,String password,String sex,String job,String favor,String photo){
			System.out.println("调用有参构造方法。。。。");
			this.userid=userid;
			this.username=username;
			this.password=password;
			this.sex=sex;
			this.job=job;
			this.favor=favor;
			this.photo=photo;
		}*/
		
		public Product(int pid, String pname, String price, String photo, String num) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.price = price;
			this.photo = photo;
			this.num   = num;
			
		}
		
		public Product(String pname, String price) {
			super();
			this.pname = pname;
			this.price = price;
		}

		public Product(String pname, String price, String photo, String num) {
			super();
			this.pname = pname;
			this.price = price;
			this.photo = photo;
			this.num = num;
			
		}

		//添加set和get方法
		public int getpid() {
			return pid;
		}
		

		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		
		
		
		
		
		
		

}
