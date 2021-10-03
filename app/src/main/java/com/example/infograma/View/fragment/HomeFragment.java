package com.example.infograma.View.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infograma.R;
import com.example.infograma.adapter.CardViewAdapter;
import com.example.infograma.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar
        showToolBar(getString(R.string.title_home_fragment),false,view);

        //recycleview
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);

        //layoud manager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(),R.layout.cardview_image,getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }
    public void showToolBar(String titulo, boolean botonSubir , View view){

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://www.telesurtv.net/__export/1408990586195/sites/telesur/img/image/2014/06/16/cerro-rico-de-potosa.jpg","Carlos Vargas","5 dias","9 me gusta"));
        images.add(new Image("https://boliviaturistica.com/wp-content/uploads/2019/06/sitios-turisticos-de-bolivia-lago-titicaca.jpg","Maria Teresa","1 dias","2 me gusta"));
        images.add(new Image("https://laicismo.org/wp-content/uploads/2016/02/monumento-virgen-socavon-Bolivia.jpg","Juan Carlos","8 dias","10 me gusta"));
        images.add(new Image("https://lh3.googleusercontent.com/proxy/gZYfBihMRQqRky9m-hsyE-aG8AJRPoRCsI3uSU19NccfWYkbEzxd8Pr7QgXs0z9QYdp-AweY7xcdXx6SFSdBmjgY90IcGuKQyT6ICNehDEGQNyhv2cTJbEBZulYpGp2y1O0n","Manuel Serna","5 dias","6 me gusta"));
        images.add(new Image("https://www.quepasahora.com/wp-content/uploads/2021/07/cocha.jpg","Jose Manuel","5 dias","5 me gusta"));
        images.add(new Image("http://www.soybolivia.bo/wp-content/uploads/2019/06/Catarata-Ahlfeld-960x636.jpg","Eduardo Martin","4 dias","5 me gusta"));
        images.add(new Image("https://www.soynomada.news/__export/1621870445224/sites/debate/img/2021/05/24/los_6_lugares_turxsticos_mxs_bonitos_de_bolivia_que_tienes_que_visitar_crop1621870351521.jpg_976912859.jpg","Antonio Fernandez","6 dias","9 me gusta"));
        images.add(new Image("https://boliviadventure.com/wp-content/uploads/2017/11/misiones-jesu%C3%ADticas-e1537550828843.jpg","Erick Arenas","2 dias","6 me gusta"));
        images.add(new Image("https://media-cdn.tripadvisor.com/media/photo-s/11/33/cd/d6/puma-uta-largejpg.jpg","Lina Rios","8 dias","1 me gusta"));
        images.add(new Image("https://www.lugaresturisticos.org/wp-content/uploads/2019/02/Potos%C3%AD.jpg","Julia Vasquez","9 dias","3 me gusta"));
        return images;
    }
}