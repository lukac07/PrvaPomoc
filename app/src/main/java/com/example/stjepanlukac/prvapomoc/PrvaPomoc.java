package com.example.stjepanlukac.prvapomoc;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrvaPomoc extends Fragment {


    public PrvaPomoc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prva_pomoc, container, false);

        final int[] imgs = {R.drawable.rane, R.drawable.krvarenje, R.drawable.unutarnje_krvarenje,
                R.drawable.srcani_infarkt, R.drawable.mozdani_udar, R.drawable.sok, R.drawable.epilepticni_napad, R.drawable.gusenje,
                R.drawable.opekline, R.drawable.strujni_udar, R.drawable.udar_groma, R.drawable.toplinski_udar, R.drawable.vrucica,
                R.drawable.smrzotine, R.drawable.pothladenost, R.drawable.prijelomi, R.drawable.ozljede_kraljeznice, R.drawable.amputacijske_ozljede,
                R.drawable.bocni_polozaj, R.drawable.otrovanja
        };

        //popis ozljeda
        String[] popis_ozljeda = { "RANE", "KRVARENJE", "UNUTARNJE KRVARENJE", "SRČANI INFARKT",
        "MOŽDANI UDAR", "ŠOK", "EPILEPTIČNI NAPAD", "GUŠENJE", "OPEKLINE", "STRUJNI UDAR", "UDAR GROMA", "TOPLINSKI UDAR",
        "VRUĆICA", "SMRZOTINE", "POTHLAĐENOST", "PRIJELOMI", "OZLJEDE KRALJEŽNICE", "AMPUTACIJSKE OZLJEDE", "BOČNI POLOŽAJ",
        "OTROVANJA"};

        ListAdapter ozljedeAdapter = new CustomAdapterOzljede(getContext(), popis_ozljeda, imgs);

        ListView ozljedeListView = (ListView) view.findViewById(R.id.ozljedeListView);
        ozljedeListView.setAdapter(ozljedeAdapter);

        //Listener kad se klikne na pojedini item
        ozljedeListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String ozljede = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(getActivity(), ozljede, Toast.LENGTH_SHORT).show();


                        //otvaranje novog aktivitija na klikom na pojedini item u listi
                        if (position == 0) {
                            Intent lala = new Intent(view.getContext(), Rane.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 1){
                            Intent lala = new Intent(view.getContext(), Krvarenje.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 2){
                            Intent lala = new Intent(view.getContext(), UnutarnjeKrvarenje.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 3){
                            Intent lala = new Intent(view.getContext(), SrcaniInfarkt.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 4){
                            Intent lala = new Intent(view.getContext(), MozdaniUdar.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 5){
                            Intent lala = new Intent(view.getContext(), Sok.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 6){
                            Intent lala = new Intent(view.getContext(), EpilepticniNapad.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 7){
                            Intent lala = new Intent(view.getContext(), Gusenje.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 8){
                            Intent lala = new Intent(view.getContext(), Opekline.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 9){
                            Intent lala = new Intent(view.getContext(), StrujniUdar.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 10){
                            Intent lala = new Intent(view.getContext(), UdarGroma.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 11){
                            Intent lala = new Intent(view.getContext(), ToplinskiUdar.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 12){
                            Intent lala = new Intent(view.getContext(), Vrucica.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 13){
                            Intent lala = new Intent(view.getContext(), Smrzotine.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 14){
                            Intent lala = new Intent(view.getContext(), Pothladenost.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 15){
                            Intent lala = new Intent(view.getContext(), Prijelomi.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 16){
                            Intent lala = new Intent(view.getContext(), OzljedeKraljeznice.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 17){
                            Intent lala = new Intent(view.getContext(), AmputacijskeOzljede.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 18){
                            Intent lala = new Intent(view.getContext(), BocniPolozaj.class);
                            startActivityForResult(lala, 0);

                        }else if (position == 19){
                            Intent lala = new Intent(view.getContext(), Otrovanja.class);
                            startActivityForResult(lala, 0);

                        } else {
                            Intent lala = new Intent(view.getContext(), OzljedeKraljeznice.class);
                            startActivityForResult(lala, 0);
                        }

                    }
                }
        );
        return view;
    }
}
