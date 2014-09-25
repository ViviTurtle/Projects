public class Distance2
{
private double rEarth = 3961.3;
private double latitude1;
private double longitude1;
private double latitude2;
private double longitude2;

    //constructs the actual longitudes and latitudes of the two points on Earth
    public Distance2(double lat1, double lon1, double lat2, double lon2)
    {
        latitude1 = Math.toRadians(lat1);
        longitude1 = Math.toRadians(lon1);
        latitude2 = Math.toRadians(lat2);
        longitude2 = Math.toRadians(lon2);
   
    }
    public double getDistance()
    {
    
            double dis= rEarth*Math.acos(Math.sin(latitude2)*Math.sin(latitude1)+Math.cos(latitude1)*Math.cos(latitude2)*Math.cos(longitude2-longitude1));
            return dis;
        }
        
}
