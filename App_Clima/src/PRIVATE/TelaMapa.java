package PRIVATE;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class TelaMapa extends javax.swing.JPanel {
    public static void main(String[] args) {
        // Create a JPanel to hold the JMapViewer
        JPanel mapPanel = new JPanel();
        mapPanel.setLayout(new BorderLayout());

        // Create a JMapViewer
        JMapViewer mapViewer = new JMapViewer();
        mapPanel.add(mapViewer, BorderLayout.CENTER);

        // Add a marker to the map
        Coordinate coordinate = new Coordinate(48.8566, 2.3522); // Paris, France
        MapMarkerDot marker = new MapMarkerDot(coordinate);
        mapViewer.setDisplayPosition(coordinate, 12);
        mapViewer.addMapMarker(marker);
    }
}
