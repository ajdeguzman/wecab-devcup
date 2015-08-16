
package edu.ajdeguzman.wecab;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class FragmentCabsNearby extends Fragment {

    public FragmentCabsNearby() {
    }

    private static final LatLng UCU = new LatLng(15.9802657, 120.5608399);
    private GoogleMap map;
    private ProgressDialog dialog;
    private MapTask task;
    Boolean isInternetPresent = false;
    MapView mapView;
    Marker marker1, marker2, marker3, marker4, marker5, marker6, marker7,
            marker8, marker9, marker10, marker11, marker14, marker15, marker16,
            marker17, marker18, marker19, marker20, marker21, marker22;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from tab_normal_map.xml

        if (!isInternetPresent) {
            Toast.makeText(getActivity(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
        }
        View view = inflater.inflate(R.layout.fragment_cabs_nearby, container, false);
        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        //task = new MapTask();
        //task.execute();
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);

        MapsInitializer.initialize(this.getActivity());

        // Updates the location and zoom of the MapView
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UCU, 19.0f));

        // Set the map type to Satellite
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(UCU)      // Sets the center of the map to Mountain View
                .zoom(18)                   // Sets the zoom
                .bearing(75)                // Sets the orientation of the camera to east
                .build();                   // Creates a CameraPosition from the builder
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
       /* GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.ucu_map))
                .position(UCU, 8600f, 6500f);
        GroundOverlay imageOverlay = map.addGroundOverlay(newarkMap);*/
        //IconGenerator icon = new IconGenerator(getActivity());

        // Gymnasium
        // icon.setStyle(IconGenerator.STYLE_BLUE);
        //Bitmap iconBitmap = icon.makeIcon("Gymnasium");


         /*map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.equals(marker1)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.ucu_gymn);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker2)) {
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            // Show Image of The Building
                                            Toast toast2 = new Toast(getActivity());
                                            ImageView view2 = new ImageView(
                                                    getActivity());
                                            //view2.setImageResource(R.drawable.orata);
                                            toast2.setDuration(Toast.LENGTH_LONG);
                                            toast2.setView(view2);
                                            toast2.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker3)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.quadrangle);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker4)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.engg_buiding);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker5)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.ucu_ob2);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker6)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.quadrangle);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker7)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.avr);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker8)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.accounting_building);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker9)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.green_home);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker10)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.green_home2);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker11)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.pehm);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker14)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.canteen);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker15)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.orata_park);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker16)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.registrar);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker17)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.dbc);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker18)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                           // view1.setImageResource(R.drawable.honasan);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker19)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.badar);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker20)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.square_garden);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker21)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.president_office);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                if (marker.equals(marker22)) {
                    // handle click here
                    CharSequence options[] = new CharSequence[] { "View Photo" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("Options");
                    builder.setItems(options,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int options) {
                                    // the user clicked on options[options]
                                    switch (options) {
                                        case 0:
                                            Toast toast = new Toast(getActivity());
                                            ImageView view1 = new ImageView(
                                                    getActivity());
                                            //view1.setImageResource(R.drawable.cashier_building);
                                            toast.setDuration(Toast.LENGTH_LONG);
                                            toast.setView(view1);
                                            toast.show();
                                            ;
                                            break;
                                    }
                                }
                            });
                    builder.show();
                }
                return true;
            }
        });*/

        return view;
    }
    private class MapTask extends AsyncTask<String, String, String> {
        String response;
        @Override
        protected String doInBackground(String... arg0) {
            return response;
        }
        @Override
        protected void onPostExecute(String result) {
            dialog.hide();
            super.onPostExecute(result);
        }
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Loading Map...");
            dialog.show();
            super.onPreExecute();
        }
    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}