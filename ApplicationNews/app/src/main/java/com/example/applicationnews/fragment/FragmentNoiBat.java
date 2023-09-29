package com.example.applicationnews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationnews.R;
import com.example.applicationnews.adapter.DanhMucAdaper;
import com.example.applicationnews.models.DanhMuc;

import java.util.ArrayList;

public class FragmentNoiBat extends Fragment {

    public RecyclerView recyclerView;
    private DanhMucAdaper mDanhMucAdapter;
    private ArrayList<DanhMuc> mListDanhMuc;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_muc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeUI();
    }

    private void initializeUI() {
        recyclerView = getView().findViewById(R.id.activityMain_RecyclerView);
        mListDanhMuc = getListDanhMuc();
        mDanhMucAdapter = new DanhMucAdaper(requireContext(), mListDanhMuc);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mDanhMucAdapter);

    }

    private ArrayList<DanhMuc> getListDanhMuc() {
        ArrayList<DanhMuc> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMuc("Nổi bật", R.drawable.noibat, "https://vnexpress.net/rss/tin-noi-bat.rss"));
        listDanhMuc.add(new DanhMuc("Mới nhất", R.drawable.moinhat, "https://vnexpress.net/rss/tin-moi-nhat.rss"));
        listDanhMuc.add(new DanhMuc("Kinh doanh", R.drawable.kinhdoanh, "https://vnexpress.net/rss/kinh-doanh.rss"));
        listDanhMuc.add(new DanhMuc("Giáo dục", R.drawable.giaoduc, "https://vnexpress.net/rss/giao-duc.rss"));
        listDanhMuc.add(new DanhMuc("Pháp luật", R.drawable.phapluat, "https://vnexpress.net/rss/phap-luat.rss"));
        return listDanhMuc;
    }

}
