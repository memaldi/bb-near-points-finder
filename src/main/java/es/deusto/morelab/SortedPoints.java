package es.deusto.morelab;

import java.util.LinkedList;
import java.util.List;

public class SortedPoints
{
    private List<Route> routesSorted;
    private String origin;

    public SortedPoints()
    {
        this.routesSorted = new LinkedList();
    }

    public SortedPoints(List<Route> routesSorted) {
        this.routesSorted = routesSorted;
    }

    public List<Route> getRoutesSorted() {
        return this.routesSorted;
    }

    public void setRoutesSorted(List<Route> routesSorted) {
        this.routesSorted = routesSorted;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}