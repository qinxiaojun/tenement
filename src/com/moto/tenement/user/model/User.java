package com.moto.tenement.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	// Fields
		private String id;
		private String username; //登录名
		private String password;	//密码
		private Integer sex;	//性别
		private String nickname;	//昵称
		
		private String avatar;	//头像地址
		private String email;	//邮箱
		private String phone;	//手机号码
		private String address;	//地址
		private String jobTitle;	//岗位

		// Constructors

		/** default constructor */
		public User() {
		}

		/** minimal constructor */
		public User(String id) {
			this.id = id;
		}

		/** full constructor */
		public User(String id, String username, String password, Integer sex,
				String nickname,String avatar,String email,String phone,String address
				,String jobTitle) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.sex = sex;
			this.nickname = nickname;
			this.avatar = avatar;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.jobTitle = jobTitle;
		}

		@Column(name = "avatar", length = 255)
		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		@Column(name = "email", length = 255)
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		@Column(name = "phone", length = 255)
		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
		@Column(name = "address", length = 255)
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		@Column(name = "jobTitle", length = 255)
		public String getJobTitle() {
			return jobTitle;
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		// Property accessors
		@Id
		@Column(name = "id", unique = true, nullable = false)
		public String getId() {
			return this.id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Column(name = "username", length = 50)
		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		@Column(name = "password", length = 50)
		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(name = "sex")
		public Integer getSex() {
			return this.sex;
		}

		public void setSex(Integer sex) {
			this.sex = sex;
		}

		@Column(name = "nickname", length = 100)
		public String getNickname() {
			return this.nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
}
