package com.mysite.shop.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetItemDtl_Test {
	
	@Autowired
	private ItemService itemService ; 
	
	@Test
	void getItemDtl_Test() {
		
		ItemFormDto itemFormDto = 
				itemService.getItemDtl(2L); 
		
		System.out.println("=====Item 출력====");
		System.out.println("id : " + itemFormDto.getId());
		System.out.println("제품명 : " + itemFormDto.getItemNm());
		System.out.println("제품 상세설명 : " + itemFormDto.getItemDetail());
		System.out.println("제품 가격 : " + itemFormDto.getPrice());
		System.out.println("제품 판매상태 : " + itemFormDto.getItemSellStatus());
		System.out.println("제품 재고수량 : " + itemFormDto.getStockNumber());
		
		System.out.println("====ItemImg 출력 === = ");
		
		for ( int i = 0 ; i < itemFormDto.getItemImgDtoList().size() ; i++) {			
			System.out.println(itemFormDto.getItemImgDtoList().get(i).getOriImgName());
			System.out.println(itemFormDto.getItemImgDtoList().get(i).getImgUrl());
			System.out.println();
		}
		
		
	}

}
