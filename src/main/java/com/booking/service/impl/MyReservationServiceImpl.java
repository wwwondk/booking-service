package com.booking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.config.AuthUser;
import com.booking.dao.MyReservationDao;
import com.booking.dto.MyReservationDto;
import com.booking.dto.ReservationTypeDto;
import com.booking.dto.User;
import com.booking.service.MyReservationService;

@Service
public class MyReservationServiceImpl implements MyReservationService {

	private MyReservationDao myReservationDao;
	
	@Autowired
	public MyReservationServiceImpl(MyReservationDao myReservationDao) {
		this.myReservationDao = myReservationDao;
	}
	
	@Override
	public List<MyReservationDto> selectAll(int userId) {
		return myReservationDao.selectAll(userId);
	}

	@Override
	public Map<String, Integer> selectReservationTypeCount(int userId) {
		List<ReservationTypeDto> list = myReservationDao.selectReservationTypeCount(userId);
		Map<String, Integer> result = new HashMap<>();
		int total = 0;
		int due_requesting = 0;
		int used = 0;
		int refund_cancel = 0;
		for(ReservationTypeDto dto : list) {
			String type = dto.getReservationType();
			if("DUE".equals(type) || "REQUESTING".equals(type)){
				due_requesting += dto.getCount();
			}else if("USED".equals(type)){
				used = dto.getCount();
			}else if("REFUND_CANCEL".equals(type)){
				refund_cancel = dto.getCount();
			}
			total += dto.getCount();
		}
		result.put("ALL", total);
		result.put("USED", used);
		result.put("DUE_REQUESTING", due_requesting);
		result.put("REFUND_CANCEL", refund_cancel);
		return result;
	}

	public void reservationRefundCancel(int reservationId) {
		HashMap<String, Object> param = new HashMap<>();
		param.put("id", reservationId);
		param.put("reservation_type", "REFUND_CANCEL");
		myReservationDao.updateReservationType(param);
	}
}
