package com.example.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RecyclerViewCompat mRecyclerViewCompat;
	private ItemTouchHelper itemTouchHelper;
	private List<String> mDatas;
	private RecyclerViewBaseAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDatas = new ArrayList<String>();
		mDatas.add("A");
		mDatas.add("B");
		mDatas.add("C");
		mDatas.add("D");
		mDatas.add("E");
		mDatas.add("F");
		mRecyclerViewCompat = (RecyclerViewCompat) findViewById(R.id.rv);
		itemTouchHelper = new ItemTouchHelper(new Callback() {

			@Override
			public void onSwiped(ViewHolder arg0, int arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean onMove(RecyclerView arg0, ViewHolder viewHolder,
					ViewHolder target) {
				int fromPosition = viewHolder.getAdapterPosition();
				int toPosition = target.getAdapterPosition();
				mDatas.add(fromPosition, mDatas.remove(toPosition));
				adapter.notifyItemMoved(fromPosition, toPosition);
				return true;
			}

			/**
			 * 是否处理拖拽和滑动事件
			 */
			@Override
			public int getMovementFlags(RecyclerView arg0, ViewHolder arg1) {
				int dragFlags;
				int swipeFlags = 0;
				if (arg0.getLayoutManager() instanceof GridLayoutManager) {
					dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN
							| ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
				} else {
					dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
				}
				return makeMovementFlags(dragFlags, swipeFlags);
			}
		});
		itemTouchHelper.attachToRecyclerView(mRecyclerViewCompat);
//		mRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		mRecyclerViewCompat.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
		adapter = new RecyclerViewBaseAdapter<String>(mDatas,R.layout.item) {

			@Override
			public void bindData(RecyclerViewBaseViewHolder arg0, String data) {
				arg0.setText(R.id.tv, data);
				
			}
		};
		mRecyclerViewCompat.setAdapter(adapter);

	}
}
