/**
 * Stores a set of latitude, longitude Coordinates.
 * @author hliao62
 * @version 1.0
 */
public class Coordinates {
    private final double latitude;
    private final double longitude;
    
    /**
     * Constructs a set of coordinates given the constructor arguments.
     * @param latitude the latitude of the location
     * @param longitude the longitude of the location
     */
    public Coordinates (double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Returns the given latitude.
     * @return latitude of the set of coordinates.
     */
    public double getLatitude() {
        return latitude;
    }
    
    /**
     * Returns the given longitude
     * @return longitude of the set of coordinates.
     */
    public double getLongitude() {
        return longitude;
    }
    
    /**
     * Returns whether this coordinate is equal to another coordinate.
     * @param other
     * @return coordinate equality
     */
    @Override
    public boolean equals(Object other) {
        if(this==other) return true;
        if(other==null) return false;
        if(other instanceof Coordinates) {
            Coordinates c = (Coordinates)other;
            return latitude==c.latitude && longitude==c.longitude;
        }
        return false;        
    }
    
    /**
     * @return Coordinate in "latitude: (latitude), longitude: (longitude)" form
     */
    @Override
    public String toString() {
        return "latitude: "+latitude+", longitude: "+longitude;
    }
    
}
