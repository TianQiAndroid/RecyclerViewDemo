package com.example.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerViewCompat extends RecyclerView {

	private OnItemClickListener mOnItemClickListener;
	private OnItemLongClickListener mOnItemlLongClickListener;

	public RecyclerViewCompat(Context arg0, @Nullable AttributeSet arg1,
			int arg2) {
		super(arg0, arg1, arg2);
	}

	public RecyclerViewCompat(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public RecyclerViewCompat(Context context) {
		super(context);
		init();
	}

	private void init() {
		addOnItemTouchListener(new OnItemTouchListenerImpl(this));
	}

	private class OnItemTouchListenerImpl implements OnItemTouchListener {

		private GestureDetectorCompat mGestureDetectorCompat;
		private RecyclerViewCompat mRecyclerView;

		public OnItemTouchListenerImpl(RecyclerViewCompat recyclerView) {
			this.mRecyclerView = recyclerView;
			mGestureDetectorCompat = new GestureDetectorCompat(getContext(),
					new GestureDetector.SimpleOnGestureListener() {

						@Override
						public boolean onSingleTapUp(MotionEvent e) {
							if (mOnItemClickListener != null) {

								View child = mRecyclerView.findChildViewUnder(
										e.getX(), e.getY());
								if (child != null) {
									int position = mRecyclerView
											.getChildAdapterPosition(child);
									mOnItemClickListener.OnItemClick(
											mRecyclerView, child, position);
								}
							}
							return super.onSingleTapUp(e);
						}

						@Override
						public void onLongPress(MotionEvent e) {
							if (mOnItemlLongClickListener != null) {

								View child = mRecyclerView.findChildViewUnder(
										e.getX(), e.getY());
								if (child != null) {
									int position = mRecyclerView
											.getChildAdapterPosition(child);
									mOnItemlLongClickListener.OnItemLongClick(
											mRecyclerView, child, position);
								}
							}
						}

					});

		}

		@Override
		public boolean onInterceptTouchEvent(RecyclerView arg0, MotionEvent arg1) {
			mGestureDetectorCompat.onTouchEvent(arg1);
			return false;
		}

		@Override
		public void onRequestDisallowInterceptTouchEvent(boolean arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTouchEvent(RecyclerView arg0, MotionEvent arg1) {
			mGestureDetectorCompat.onTouchEvent(arg1);
		}

	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.mOnItemClickListener = onItemClickListener;
	}

	public void setOnItemlLongClickListener(
			OnItemLongClickListener onItemlLongClickListener) {
		this.mOnItemlLongClickListener = onItemlLongClickListener;
	}

	public interface OnItemClickListener {
		void OnItemClick(RecyclerViewCompat parent, View child, int position);
	}

	public interface OnItemLongClickListener {
		void OnItemLongClick(RecyclerViewCompat parent, View child, int position);
	}

}
