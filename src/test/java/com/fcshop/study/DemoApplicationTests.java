package com.fcshop.study;

import com.fcshop.study.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	@MockBean
	private MemberService memberService;




//	void updateMember(Long id){
//
//		ShoppingRequestDto shoppingRequestDto = new ShoppingRequestDto();
//
//		shoppingRequestDto.setId(id);
//		shoppingRequestDto.setName("업데이트 유저");
//		shoppingRequestDto.setPassword("1111");
//
//		//int result = memberService.updateMember(shoppingRequestDto);
//
//		if(result>0){
//			System.out.println("Update success: ");
//		} else{
//			System.out.println("Update Fail: ");
//		}
//	}


	@Test
	void contextLoads() {
	}

}
