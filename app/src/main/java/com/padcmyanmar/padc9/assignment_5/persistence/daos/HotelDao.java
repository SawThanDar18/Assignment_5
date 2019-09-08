package com.padcmyanmar.padc9.assignment_5.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import java.util.List;

@Dao
public interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertHotels(List<HotelVO> hotelVOS);

    @Query("SELECT * FROM hotel")
    List<HotelVO> getAll();

    @Query("SELECT * FROM hotel where id = :id")
    HotelVO getHotelById(int id);
}
