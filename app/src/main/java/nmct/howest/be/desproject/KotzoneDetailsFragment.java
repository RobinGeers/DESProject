package nmct.howest.be.desproject;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class KotzoneDetailsFragment extends Fragment {

    private TextView textViewDetailsAdres, textViewDetailsStad, textViewDetailsPostcode;
    private Geocoder geocoder;
    private List<Address> listAddressen;


    public static final String EXTRA_MARKER_LATITUDE = "";
    public static final String EXTRA_MARKER_LONGITUDE = "";


    public KotzoneDetailsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewKotzoneDetails = inflater.inflate(R.layout.fragment_kotzone_details, container, false);

        textViewDetailsAdres = (TextView) viewKotzoneDetails.findViewById(R.id.textViewDetailsAdres);
        textViewDetailsStad = (TextView) viewKotzoneDetails.findViewById(R.id.textViewDetailsStad);
        textViewDetailsPostcode = (TextView) viewKotzoneDetails.findViewById(R.id.textViewDetailsPostcode);

        if (getArguments() != null) {
            double latitude = getArguments().getDouble(EXTRA_MARKER_LATITUDE);
            double longitude = getArguments().getDouble(EXTRA_MARKER_LONGITUDE);
            geocoder = new Geocoder(getActivity(), Locale.getDefault());
           /* try {
                listAddressen = geocoder.getFromLocation(latitude, longitude, 3);

                // Haal info op van locatie
                String adres = listAddressen.get(0).getAddressLine(0);
                String stad = listAddressen.get(0).getLocality();
                String postcode = listAddressen.get(0).getPostalCode();

                // Vul info in TextViews
                textViewDetailsAdres.setText(adres);
                textViewDetailsStad.setText(stad);
                textViewDetailsPostcode.setText(postcode);
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        }
        return viewKotzoneDetails;
    }

    public static KotzoneDetailsFragment newInstance(double latitude, double longitude) {
        KotzoneDetailsFragment fragment = new KotzoneDetailsFragment();

        // Steek ontvangen parameters in Bundle (mandje)
        Bundle args = new Bundle();
        args.putDouble(EXTRA_MARKER_LATITUDE, latitude);
        args.putDouble(EXTRA_MARKER_LONGITUDE, longitude);
        fragment.setArguments(args);

        return fragment;
    }
}
