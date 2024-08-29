package com.app.bo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class AuthorBo {
	
	@Id
	@GeneratedValue
	private Integer id;

	private String autorFirstName;
	private String authorSecondName;
	private String authorEmail;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinTable(name = "AUTHOR_COURSE_MAPPING",
			   joinColumns = @JoinColumn(name = "author_id"),
			   inverseJoinColumns = @JoinColumn(name = "course_id"))
	@JsonManagedReference
	private Set<CourseBo> courseBo;
	
	public String getAutorFirstName() {
		return autorFirstName;
	}
	public void setAutorFirstName(String autorFirstName) {
		this.autorFirstName = autorFirstName;
	}
	public String getAuthorSecondName() {
		return authorSecondName;
	}
	public void setAuthorSecondName(String authorSecondName) {
		this.authorSecondName = authorSecondName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<CourseBo> getCourseBo() {
		return courseBo;
	}
	public void setCourseBo(Set<CourseBo> courseBo) {
		this.courseBo = courseBo;
	}
	@Override
	public String toString() {
		return "AuthorBo [courseBo=" + courseBo + "]";
	}
	

}
