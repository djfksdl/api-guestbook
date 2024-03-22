package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;
//@Controller
@RestController //ResponseBody도 포함하고있어서 이걸로 쓰면 밑에 @ResponseBody 안써도됨. RestApi를  쓰고있으니까!
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookService guestbookService;
	
	//리스트 -리스트 데이터를 주기위해서 만듦
	//@ResponseBody
	//@RequestMapping(value="/api/guests", method= RequestMethod.GET)
	@GetMapping(value="/api/guests")
	public List<GuestbookVo> list() {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVo> guestbookList = guestbookService.exeGuestList();
		System.out.println(guestbookList);
		
		
		return guestbookList;
	}
	
	//등록
	//@ResponseBody
	//@RequestMapping(value="/api/guests", method= RequestMethod.POST)
	@PostMapping(value="/api/guests")
	public GuestbookVo add(@RequestBody GuestbookVo guestbookVo) {//json으로 보냈으니까 요청바디를 살펴보라고 해야함! modelAttribute아님!
		System.out.println("GuestbookController.add");
		
		GuestbookVo guestVo = guestbookService.exeAddandGuest(guestbookVo);
		//System.out.println(guestVo);
		
		return guestVo;
	}
	
	//삭제
	//@ResponseBody
	//@RequestMapping(value="/api/guests/{no}", method= RequestMethod.DELETE)
	@DeleteMapping(value="/api/guests/{no}")
	public int remove(@RequestBody GuestbookVo guestbookVo
						,@PathVariable(value="no")int no ) {
		System.out.println("GuestbookController.remove");
		System.out.println(guestbookVo);
		System.out.println(no);
		
		guestbookVo.setNo(no);
		System.out.println("no집어넣은 후: "+guestbookVo);

		int count = guestbookService.exeRemove(guestbookVo);
		
		//int count = 1으로 넘길때 json은 객체모양{키,값}이니까
		//return "{count:1}" 이런모양으로 넘겨줘야함. 위에 자료형은 String으로 바꿔줘야함. 
//		String result = "{\"count\":"+count+"}";
//		System.out.println(result);
//		return result;
		return count;
	}
}
