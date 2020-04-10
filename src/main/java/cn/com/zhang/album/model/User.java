package cn.com.zhang.album.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description
 * @Author  zhouxin
 * @Date 2019-12-09 17:40:19
 */

@Entity
@Table ( name ="user" , schema = "")
public class User  implements Serializable {

	private static final long serialVersionUID =  4657003610906748255L;

	@GeneratedValue(strategy= GenerationType.AUTO)
	@Id
	private Long id;

   	@Column(name = "password" )
	private String password;

   	@Column(name = "name" )
	private String name;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{" +
					"id='" + id + '\'' +
					"password='" + password + '\'' +
					"name='" + name + '\'' +
				'}';
	}

}
