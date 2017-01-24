package com.sy.example.recyclerview_paging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sy.example.recyclerview_paging.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    boolean isLoading;
    boolean isLastPage;
    int page_size = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter(this, R.layout.list_item, getDafalutItems());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(recyclerViewViewOnScrollListener);
    }

    private RecyclerView.OnScrollListener recyclerViewViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int visibleItemCount = linearLayoutManager.getChildCount();
            int toalItemCount = linearLayoutManager.getItemCount();
            int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

            if (!isLoading && !isLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= toalItemCount && firstVisibleItemPosition >= 0 && toalItemCount >= page_size) {
                    loadMoreItems();
                }
            }
        }
    };

    private void loadMoreItems() {
        adapter.addItems(getDafalutItems());
        adapter.notifyDataSetChanged();
    }

    private ArrayList<String> getDafalutItems() {

        ArrayList<String> items = new ArrayList<>();
        for (int i=0; i <= 100; i++) {
            items.add("" + i);
        }
        return items;
    }
}
