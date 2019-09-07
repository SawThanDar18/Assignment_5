package com.padcmyanmar.padc9.assignment_5.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "hotel", indices = @Index(value = "id", unique = true))
public class HotelVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "hotel_id_pk")
    private int hotelIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("house_image_url")
    @ColumnInfo(name = "house_image_url")
    private String image;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("price")
    @ColumnInfo(name = "price")
    private long price;

    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    @SerializedName("square_feet")
    @ColumnInfo(name = "square_feet")
    private long square_feet;

    @SerializedName("latitude")
    @ColumnInfo(name = "latitude")
    private double lattitude;

    @SerializedName("longitude")
    @ColumnInfo(name = "longitude")
    private double longitude;

    public int getHotelIdPK() {
        return hotelIdPK;
    }

    public void setHotelIdPK(int hotelIdPK) {
        this.hotelIdPK = hotelIdPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSquare_feet() {
        return square_feet;
    }

    public void setSquare_feet(long square_feet) {
        this.square_feet = square_feet;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
