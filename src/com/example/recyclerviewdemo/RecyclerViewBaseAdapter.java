package com.example.recyclerviewdemo;

import java.util.List;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class RecyclerViewBaseAdapter<T> extends
		Adapter<RecyclerViewBaseViewHolder> {

	private List<T> mDatas;
	private int itemLayoutId;

	public RecyclerViewBaseAdapter(List<T> datas, int itemLayoutId) {
		this.mDatas = datas;
		this.itemLayoutId = itemLayoutId;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public void onBindViewHolder(RecyclerViewBaseViewHolder arg0, int arg1) {
		bindData(arg0, mDatas.get(arg1));

	}

	@Override
	public RecyclerViewBaseViewHolder onCreateViewHolder(ViewGroup arg0,
			int arg1) {
		return new RecyclerViewBaseViewHolder(LayoutInflater.from(
				DemoApplication.getInstance()).inflate(itemLayoutId, arg0,
				false));
	}

	public abstract void bindData(RecyclerViewBaseViewHolder arg0, T data);
}
