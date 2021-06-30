package com.example.starter.web.member

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MemberService(val memberRepository: MemberRepository) {

	fun getMember(id : Long): Member? {
		return memberRepository.findByIdOrNull(id)
	}
}
