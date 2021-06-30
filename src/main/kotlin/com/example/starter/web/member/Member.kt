package com.example.starter.web.member

import javax.persistence.*

@Entity
@Table(name = "user")
class Member(name: String) {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null
	val name: String = name
}
