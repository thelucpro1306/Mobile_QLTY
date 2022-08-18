package com.example.qlty;

import android.app.DatePickerDialog;
import android.app.Service;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlty.Adapter.ServicesAdapter;
import com.example.qlty.Model.Appointment;
import com.example.qlty.Model.Client;
import com.example.qlty.Model.Services;
import com.example.qlty.Model.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DatLichFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatLichFragment extends Fragment {
    List<Services> servicesList;
    public EditText edtDate,edtName,edtEmail,edtPhone,edtNote;
    private long SID = -1;
    private Spinner spinner;
    private ServicesAdapter servicesAdapter;
    private Button btnDatLich,btnThoat;
    private Appointment appointment;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DatLichFragment() {
        // Required empty public constructor
    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatLichFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DatLichFragment newInstance(String param1, String param2) {
        DatLichFragment fragment = new DatLichFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_dat_lich, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ApiServices.apiService.GetServices().enqueue(new Callback<List<Services>>() {
            @Override
            public void onResponse(Call<List<Services>> call, Response<List<Services>> response) {
                Toast.makeText(getActivity(), "Get services sucess", Toast.LENGTH_SHORT).show();
                servicesList = response.body();
                servicesAdapter = new ServicesAdapter(getActivity(),R.layout.item_selected,servicesList);
                spinner.setAdapter(servicesAdapter);

            }

            @Override
            public void onFailure(Call<List<Services>> call, Throwable t) {
                Toast.makeText(getActivity(), "Get services error", Toast.LENGTH_SHORT).show();

            }
        });
        appointment = new Appointment();
        spinner = getView().findViewById(R.id.spinner_services);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), String.valueOf(servicesAdapter.getItem(i).getId()), Toast.LENGTH_SHORT).show();
                SID = servicesAdapter.getItem(i).getId();
                appointment.setServicesId(SID);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        edtDate =getView().findViewById(R.id.edtDate);
        edtName =getView().findViewById(R.id.edtName);
        edtEmail =getView().findViewById(R.id.edtEmail);
        edtPhone =getView().findViewById(R.id.edtPhone);
        edtNote =getView().findViewById(R.id.edtNote);

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });
        btnDatLich = getView().findViewById(R.id.btnDatLichKham);
        try {
            appointment.setBookingDate(simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String mail = edtEmail.getText().toString().trim();
        appointment.setEmail("mail");
        Log.e("a:312312",mail+"");
        appointment.setPhone(edtPhone.getText().toString().trim());
        appointment.setName(edtName.getText().toString());
        appointment.setNote(edtNote.getText().toString());
        Client client = (Client) getArguments().get("Client_ID");
        appointment.setClientID(client.getId());


        btnDatLich.setOnClickListener(v->{
            ApiServices.apiService.addAppointment(appointment).enqueue(new Callback<Appointment>() {
                @Override
                public void onResponse(Call<Appointment> call, Response<Appointment> response) {
                    Appointment apm = response.body();

                }

                @Override
                public void onFailure(Call<Appointment> call, Throwable t) {

                }
            });
//            ScheduleFragment scheduleFragment = new ScheduleFragment();
//            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.frame, scheduleFragment);
//            fragmentTransaction.commit();

        });
    }

    private void ChonNgay(){
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), (datePicker, i, i1, i2) -> {
            calendar.set(i,i1,i2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            edtDate.setText(simpleDateFormat.format(calendar.getTime()));
            Log.e("eqwqewq",edtDate.getText()+"");
        },nam,thang,ngay);
        datePickerDialog.show();
    }
}