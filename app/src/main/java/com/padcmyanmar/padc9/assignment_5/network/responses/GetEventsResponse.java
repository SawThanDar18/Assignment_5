package com.padcmyanmar.padc9.assignment_5.network.responses;

import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import java.util.List;

public class GetEventsResponse {

    private int code;
    private String message;
    private List<HotelVO> hotelVOList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HotelVO> getHotelVOList() {
        return hotelVOList;
    }

    public void setHotelVOList(List<HotelVO> hotelVOList) {
        this.hotelVOList = hotelVOList;
    }
}
