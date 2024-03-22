package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	//필드
	@Autowired
	private GuestbookDao guestbookDao;
	
	//리스트
	public List<GuestbookVo> exeGuestList() {
		System.out.println("GuestbookService.guestList");
		
		List<GuestbookVo> guestbookList= guestbookDao.guestbookSelectList();
		
		return guestbookList;
	}
	
	// 방명록 등록 ajax
	public GuestbookVo exeAddandGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestService.exeAddandGuest()");

		// 등록
		int count = guestbookDao.insertSelectKey(guestbookVo);

		// no 의 데이터 가져오기
		// no값 확인
		int no = guestbookVo.getNo();
		// no데이터 가져오기

		GuestbookVo gVo = guestbookDao.guestbookSelectOne(no);
		return gVo;
	}
	
	//삭제
	public int exeRemove(GuestbookVo guestbookVo) {
		System.out.println("GuestService.exeRemove()");
		
		int count = guestbookDao.guestbookDelete(guestbookVo);
		return count;
		
		
	}
}
