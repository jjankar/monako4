package janis.monaco.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
public class Place {
    private int placeId;
    private double latitude;
    private double longitude;
    private String imageUrl;
    private String placeName;
    private String placeAddress;
    private Integer placeTypeId;
    private PlaceTypeRef placeTypeRefByPlaceTypeId;
    private Collection<PlacesInRoute> placesInRoutesByPlaceId;
    private Collection<Review> reviewsByPlaceId;

    @Id
    @Column(name = "placeID")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "imageURL")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "placeName")
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Basic
    @Column(name = "placeAddress")
    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    @Basic
    @Column(name = "placeTypeID")
    public Integer getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(Integer placeTypeId) {
        this.placeTypeId = placeTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (placeId != place.placeId) return false;
        if (Double.compare(place.latitude, latitude) != 0) return false;
        if (Double.compare(place.longitude, longitude) != 0) return false;
        if (imageUrl != null ? !imageUrl.equals(place.imageUrl) : place.imageUrl != null) return false;
        if (placeName != null ? !placeName.equals(place.placeName) : place.placeName != null) return false;
        if (placeAddress != null ? !placeAddress.equals(place.placeAddress) : place.placeAddress != null) return false;
        if (placeTypeId != null ? !placeTypeId.equals(place.placeTypeId) : place.placeTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = placeId;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (placeName != null ? placeName.hashCode() : 0);
        result = 31 * result + (placeAddress != null ? placeAddress.hashCode() : 0);
        result = 31 * result + (placeTypeId != null ? placeTypeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "placeTypeID", referencedColumnName = "PLACE_TYPE_ID")
    public PlaceTypeRef getPlaceTypeRefByPlaceTypeId() {
        return placeTypeRefByPlaceTypeId;
    }

    public void setPlaceTypeRefByPlaceTypeId(PlaceTypeRef placeTypeRefByPlaceTypeId) {
        this.placeTypeRefByPlaceTypeId = placeTypeRefByPlaceTypeId;
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<PlacesInRoute> getPlacesInRoutesByPlaceId() {
        return placesInRoutesByPlaceId;
    }

    public void setPlacesInRoutesByPlaceId(Collection<PlacesInRoute> placesInRoutesByPlaceId) {
        this.placesInRoutesByPlaceId = placesInRoutesByPlaceId;
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<Review> getReviewsByPlaceId() {
        return reviewsByPlaceId;
    }

    public void setReviewsByPlaceId(Collection<Review> reviewsByPlaceId) {
        this.reviewsByPlaceId = reviewsByPlaceId;
    }
}