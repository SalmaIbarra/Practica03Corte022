package com.example.practica03corte02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SearchView srcLista;
    private SpinnerAdapter adapter;
    private ListView sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//El error en teoria es normal¿
        //Un dos tres tamarindo
        srcLista = findViewById(R.id.menu_search); //Me da una amsiedad ver esto en rojo no puedo AAAAAAAAAA
//No estoy seguro pero bueno
        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData(getString(R.string.itemEstefano), getString(R.string.msgEstefano), R.drawable.img2019030344));
        list.add(new ItemData(getString(R.string.itemCarlosAlberto), getString(R.string.msgCarlosAlberto), R.drawable.img2020030174));
        list.add(new ItemData(getString(R.string.itemMarcoAntonio), getString(R.string.msgMarcoAntonioAlarid), R.drawable.img2020030176));
        list.add(new ItemData(getString(R.string.itemJoshuaDaniel), getString(R.string.msgJoshuaDaniel), R.drawable.img2020030181));
        list.add(new ItemData(getString(R.string.itemErnestoDavid), getString(R.string.msgErnestoDavid), R.drawable.img2020030184));
        list.add(new ItemData(getString(R.string.itemMaximiliano), getString(R.string.msgMaximiliano), R.drawable.img2020030189));
        list.add(new ItemData(getString(R.string.itemIvanEnrique), getString(R.string.msgIvanEnrique), R.drawable.img2020030199));
        list.add(new ItemData(getString(R.string.itemJesusEduardo), getString(R.string.msgJesusEduardo), R.drawable.img2020030212));
        list.add(new ItemData(getString(R.string.itemDavidAntonio), getString(R.string.msgDavidAntonio), R.drawable.img2020030241));
        list.add(new ItemData(getString(R.string.itemGustavoAdolfo), getString(R.string.msgGustavoAdolfo), R.drawable.img2020030243));
        list.add(new ItemData(getString(R.string.itemJuanCarlos), getString(R.string.msgJuanCarlos), R.drawable.img2020030249));
        list.add(new ItemData(getString(R.string.itemAlejo), getString(R.string.msgAlejo), R.drawable.img2020030264));
        list.add(new ItemData(getString(R.string.itemCarlosJair), getString(R.string.msgCarlosJair), R.drawable.img2020030268));
        list.add(new ItemData(getString(R.string.itemJesusTadeo), getString(R.string.msgJesusTadeo), R.drawable.img2020030292));
        list.add(new ItemData(getString(R.string.itemJair), getString(R.string.msgJair), R.drawable.img2020030304));
        list.add(new ItemData(getString(R.string.itemDiego), getString(R.string.msgDiego), R.drawable.img2020030306));
        list.add(new ItemData(getString(R.string.itemSalmaYareth),getString(R.string.msgSalmaYareth),R.drawable.img2020030315));
        list.add(new ItemData(getString(R.string.itemJesusAntonio), getString(R.string.msgJesusAntonio), R.drawable.img2020030333));
        list.add(new ItemData(getString(R.string.itemYenniferCarolina), getString(R.string.msgYenniferCarolina), R.drawable.img2020030389));
        list.add(new ItemData(getString(R.string.itemManuelAlexis), getString(R.string.msgManuelAlexis), R.drawable.img2020030766));
        list.add(new ItemData(getString(R.string.itemVictorMoises), getString(R.string.msgVictorMoises), R.drawable.img2020030771));
        list.add(new ItemData(getString(R.string.itemHalachUinic), getString(R.string.msgHalachUinic), R.drawable.img2020030777));
        list.add(new ItemData(getString(R.string.itemEnzoAlejandro), getString(R.string.msgEnzoAlejandro), R.drawable.img2020030799));
        list.add(new ItemData(getString(R.string.itemJoseAlberto), getString(R.string.msgJoseAlberto), R.drawable.img2020030808));
        list.add(new ItemData(getString(R.string.itemGiancarlo), getString(R.string.msgGiancarlo), R.drawable.img2020030819));
        list.add(new ItemData(getString(R.string.itemLuisAngel), getString(R.string.msgLuisAngel), R.drawable.img2020030865));
        //Sí los puse a mano, se que pude haber utilizado una herramienta *guiño guiño* pero se me fue el rollo :c
        sp = findViewById(R.id.listView);
        adapter = new SpinnerAdapter(this, R.layout.spinner_layout, R.id.lblNombe, list);
        sp.setAdapter(adapter);

        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapter.getContext(), "Se ha seleccionado".toString()+ " "+((ItemData) adapterView.getItemAtPosition(i)).getTxtNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.searchview, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
