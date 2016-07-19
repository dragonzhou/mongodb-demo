package com.example;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by  moxz
 * User: 224911261@qq.com
 * 2016/1/28-12:35
 */
@Document(collection="geo_location")
public class GeoLocation {

    private String name;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint geoPoint;

    public GeoLocation(String name, Point point) {
        this.name = name;
        this.geoPoint =  new GeoJsonPoint(point);
    }

    public GeoLocation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
