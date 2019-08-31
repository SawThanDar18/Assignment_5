package com.padcmyanmar.padc9.assignment_5.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;
import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

import java.util.List;

public class GetEventsResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
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

    public Boolean isResponseOk(){
        return code == EventsConstants.CODE_RESPONSE_OK && hotelVOList != null;
    }
}
