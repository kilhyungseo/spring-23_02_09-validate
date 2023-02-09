package com.hyungso.root;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	//검증할 객체(memberDto) 클래스 타입 정보
		// TODO Auto-generated method stub
		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberDto memberDto = (MemberDto) target; // 검증하려는 memberDto객체를 타겟

		//String memberId = memberDto.getId();
		int memberPw = memberDto.getPw();
		
//		if(memberId == null || memberId.trim().isEmpty()) {
//			errors.rejectValue("id", "trouble");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		if(memberPw == 0) {
			errors.rejectValue("pw", "trouble");
		}
		
	}

}
