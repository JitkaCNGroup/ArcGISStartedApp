package demoApp;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyMapApp extends Application {

    private MapView mapView;

    @Override
    public void start(Stage stage) throws Exception {

        // create stack pane and application scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);

        // set title, size, and add scene to stage
        stage.setTitle("Display Map Sample");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();

        // create a ArcGISMap with the a Basemap instance with an Imagery base layer
        ArcGISMap map = new ArcGISMap(Basemap.createImagery());

        // set the map to be displayed in this view
        mapView = new MapView();
        mapView.setMap(map);

        // add the map view to stack pane
        stackPane.getChildren().addAll(mapView);
    }

    /**
     * Stops and releases all resources used in application.
     */
    @Override
    public void stop() {
        if (mapView != null) {
            mapView.dispose();
        }
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}