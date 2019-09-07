package com.padcmyanmar.padc9.assignment_5.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

public class HotelTypeConverter {

    @TypeConverter
    public static String hotelToJson(HotelVO hotelVO){
        return new Gson().toJson(hotelVO);
    }

    @TypeConverter
    public static HotelVO jsonToHotel(String hotelJson){
        return new Gson().fromJson(hotelJson, HotelVO.class);
    }
}
