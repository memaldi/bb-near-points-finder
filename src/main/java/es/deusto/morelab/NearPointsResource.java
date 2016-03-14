package es.deusto.morelab;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Collections;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Api(value="/Near Points Finder")
@Path("nearpoints")
public class NearPointsResource
{
    private GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCa81L98grwbo5eVa0WMTCUG9CvLKzc4w0");

    /* REQUEST EXAMPLE
    {
	"listOfCoordinates": [{
		"latitude": 43.3323021,
		"longitude": -3.0543229
	}, {
		"latitude": 43.3519344,
		"longitude": -3.0827414
	}, {
		"latitude": 43.3520952,
		"longitude": -3.0186928
	}],
	"originLatitude": 43.2626354,
	"originLongitude": -2.9469514
    }
         */
    @GET
    @Produces({"text/plain"})
    @Path("test")
    public String getIt() { return "Got it!"; }

    @POST
    @Path("/sort-distances")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value="Sort points by walking distance")
    public SortedPoints sortPointsByDistance(PointsToSort json) {
        try { DistanceMatrixApiRequest distanceApiRequest = new DistanceMatrixApiRequest(this.context);

            String destinationString = "";
            int size = json.getListOfCoordinates().size();
            for (Coordinate c : json.getListOfCoordinates()) {
                destinationString = destinationString + c.getLatitude() + "," + c.getLongitude();
                size--; if (size != 0)
                {
                    destinationString = destinationString + "|";
                }
            }
            distanceApiRequest.destinations(new String[] { destinationString });
            distanceApiRequest.origins(new LatLng[] { new LatLng(json.getOriginLatitude().doubleValue(), json.getOriginLongitude().doubleValue()) });
            distanceApiRequest.mode(TravelMode.WALKING);
            distanceApiRequest.units(Unit.METRIC);

            DistanceMatrix results = (DistanceMatrix)distanceApiRequest.await();

            SortedPoints sortedPoints = new SortedPoints();
            for (DistanceMatrixRow r : results.rows)
            {
                for (int i = 0; i < r.elements.length; i++) {
                    Route route = new Route(r.elements[i].duration.inSeconds, r.elements[i].distance.inMeters, results.destinationAddresses[i]);

                    sortedPoints.getRoutesSorted().add(route);
                }
            }

            Collections.sort(sortedPoints.getRoutesSorted());
            sortedPoints.setOrigin(results.originAddresses[0]);

            return sortedPoints;
        } catch (Exception e)
        {
            System.out.println("Output from Server .... \n");
            e.printStackTrace();
        }return null;
    }
}