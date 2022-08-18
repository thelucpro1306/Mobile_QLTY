package com.example.qlty;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlty.Adapter.MEFAdapter;
import com.example.qlty.Model.Client;
import com.example.qlty.Model.MEF;
import com.example.qlty.Model.Users;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ISendDataListener iSendDataListener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public  ScheduleFragment () {
        // Required empty public constructor

    }


    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(ISendDataListener listener) {
        ScheduleFragment fragment = new ScheduleFragment();
        iSendDataListener = listener;
        return fragment;
    }

    public RecyclerView recyclerView;
    public FloatingActionButton btnAdd;
    public MEFAdapter mefAdapter;
    public View mview;
    public trangchu tc;
    public MainActivity mainActivity;
    public Client mclient;
    public List<Client> listClient;
    Users users;
    List<MEF> listMEF = new ArrayList<>();

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
        mview = inflater.inflate(R.layout.fragment_schedule, container, false);
        tc = (trangchu) getActivity();
        recyclerView = mview.findViewById(R.id.rcv_mef);
        mefAdapter = new MEFAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(tc);
        recyclerView.setLayoutManager(linearLayoutManager);
//        users = (Users) getArguments().get("Client");
        ApiServices.apiService.GetClientsByUID().enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                listClient = response.body();
                users = (Users) getArguments().get("Client");
                Log.e("listClient: ", listClient.size() + " ID First "+listClient.get(0).getId()+"");
                for (Client client : listClient) {
                    if(client.getUserId()==users.getID()){
                        mclient = client;
                        Toast.makeText(tc, "get Client ok", Toast.LENGTH_SHORT).show();
                        ApiServices.apiService.GetMEFByClientId().enqueue(new Callback<List<MEF>>() {
                            @Override
                            public void onResponse(Call<List<MEF>> call, Response<List<MEF>> response) {
                                try {
                                    List<MEF> mListMEF = response.body();

                                        for (MEF mef:mListMEF){
                                            if(mef.ClientID == mclient.getId()){
                                                listMEF.add(mef);
                                            }
                                        }
                                    mefAdapter.setData(listMEF);
                                    recyclerView.setAdapter(mefAdapter);

                                } catch (Exception e) {
                                    Log.e("Error getMEF: ",e.toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<List<MEF>> call, Throwable t) {
                                Toast.makeText(tc, "CALL MEF Error", Toast.LENGTH_SHORT).show();
                                Log.e("Eror getMEF: ", t.toString());
                            }
                        });
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.e("listClient: ", t.toString());
                Toast.makeText(tc, "Get client error", Toast.LENGTH_SHORT).show();
            }
        });
        btnAdd = mview.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {

            Bundle bundleClient = new Bundle();
            bundleClient.putSerializable("Client_ID",mclient);
            DatLichFragment datLichFragment = new DatLichFragment();
            datLichFragment.setArguments(bundleClient);
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, datLichFragment);
            fragmentTransaction.commit();
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy>0){
                    btnAdd.hide();
                }
                else {
                    btnAdd.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return mview;
    }
}