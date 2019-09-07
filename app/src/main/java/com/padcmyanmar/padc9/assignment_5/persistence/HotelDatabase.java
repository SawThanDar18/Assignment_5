package com.padcmyanmar.padc9.assignment_5.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;
import com.padcmyanmar.padc9.assignment_5.persistence.daos.HotelDao;
import com.padcmyanmar.padc9.assignment_5.persistence.typeconverters.HotelTypeConverter;
import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

@Database(entities = HotelVO.class, version = 2, exportSchema = false)
@TypeConverters({HotelTypeConverter.class})
public abstract class HotelDatabase extends RoomDatabase {

    public abstract HotelDao hotelDao();

    private static HotelDatabase objInstance;

    public static HotelDatabase getObjInstance(Context context){
        if (objInstance == null){
            objInstance = Room.databaseBuilder(context, HotelDatabase.class, EventsConstants.HOTEL_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objInstance;
    }

    public boolean areDatasExistInDB(){
        return !hotelDao().getAll().isEmpty();
    }
}
