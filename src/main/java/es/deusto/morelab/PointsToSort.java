package es.deusto.morelab;

import java.util.List;

public class PointsToSort
{
    Double originLatitude;
    Double originLongitude;
    List<Coordinate> listOfCoordinates;

    public PointsToSort()
    {
    }

    public PointsToSort(Double originLatitude, Double originLongitude, List<Coordinate> listOfCoordinates)
    {
        this.originLatitude = originLatitude;
        this.originLongitude = originLongitude;
        this.listOfCoordinates = listOfCoordinates;
    }

    public Double getOriginLatitude() {
        return this.originLatitude;
    }

    public void setOriginLatitude(Double originLatitude) {
        this.originLatitude = originLatitude;
    }

    public Double getOriginLongitude() {
        return this.originLongitude;
    }

    public void setOriginLongitude(Double originLongitude) {
        this.originLongitude = originLongitude;
    }

    public List<Coordinate> getListOfCoordinates() {
        return this.listOfCoordinates;
    }

    public void setListOfCoordinates(List<Coordinate> listOfCoordinates) {
        this.listOfCoordinates = listOfCoordinates;
    }
}