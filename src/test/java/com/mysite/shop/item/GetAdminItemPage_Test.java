package com.mysite.shop.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class GetAdminItemPage_Test {
	
	@Autowired
	private ItemService itemService ; 
	
	@Test
	void getAdminItemPage_Test() {
		
		ItemSearchDto itemSearchDto = new ItemSearchDto() ; 
		// 0 : 페이지 번호 
		// 3 : 레코드 3개 
		Pageable pageable = PageRequest.of(0,10) ; 
		
		itemSearchDto.setSearchDateType("all");
		itemSearchDto.setSearchBy("itemNm");
		itemSearchDto.setSearchQuery("팔찌");
		
		
		Page<Item> pages =  
				itemService.getAdminItemPage(itemSearchDto, pageable); 
		
		// pages 의 Item 을 출력 
		for (Item k : pages) {
			
			System.out.println("제품 번호 : " + k.getId());
			System.out.println("제품 이름 : " + k.getItemNm());
			System.out.println("제품 가격 : " + k.getPrice());
			System.out.println("제고 수량 : " + k.getStockNumber());
			System.out.println();
		}
		

		System.out.println(pages.getSize());
		assertEquals(3, pages.getSize());
		
	}

}
