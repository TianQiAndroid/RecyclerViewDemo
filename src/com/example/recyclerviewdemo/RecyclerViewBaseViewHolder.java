package com.example.recyclerviewdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewBaseViewHolder extends ViewHolder {

	private SparseArray<View> mViewsArray;
	private View itemView;
	
	
	public RecyclerViewBaseViewHolder(View arg0) {
		super(arg0);
		itemView = arg0;
		mViewsArray = new SparseArray<View>();
	}
	
	/**
	 * 获取指定id的view
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T findViewById(int id) {
		T view = (T) mViewsArray.get(id);
		if (view == null) {
			view = (T) itemView.findViewById(id);
			mViewsArray.put(id, view);
		}
		return view;
	}

	/**
	 * 设置view可见性
	 * 
	 * @param id
	 * @param visibility
	 * @return
	 */
	public <T extends View> void setVisibility(int id, int visibility) {
		T view = findViewById(id);
		view.setVisibility(visibility);

	}

	/**
	 * 获取view的文本信息
	 * 
	 * @param id
	 * @return
	 */
	public String getText(int id) {
		return ((TextView) findViewById(id)).getText().toString().trim();
	}

	/**
	 * 设置view的文本信息
	 * 
	 * @param id
	 * @param content
	 * @return
	 */
	public RecyclerViewBaseViewHolder setText(int id, CharSequence content) {
		((TextView) findViewById(id)).setText(content);
		return this;

	}

	/**
	 * 设置view的文本颜色
	 * 
	 * @param id
	 * @param color
	 * @return
	 */
	public RecyclerViewBaseViewHolder setTextColor(int id, int color) {
		((TextView) findViewById(id)).setTextColor(color);
		return this;

	}

	/**
	 * 设置view的文字大小
	 * 
	 * @param id
	 * @param size
	 * @return
	 */
	public RecyclerViewBaseViewHolder setTextSize(int id, float size) {
		((TextView) findViewById(id)).setTextSize(size);
		return this;
	}

	/**
	 * 设置imageview图片
	 * 
	 * @param viewId
	 * @param bm
	 * @return
	 */
	public RecyclerViewBaseViewHolder setImageBitmap(int viewId, Bitmap bm) {
		((ImageView) findViewById(viewId)).setImageBitmap(bm);
		return this;
	}

	/**
	 * 设置imageview图片
	 * 
	 * @param viewId
	 * @param drawable
	 * @return
	 */
	public RecyclerViewBaseViewHolder setImageDrawable(int viewId, Drawable drawable) {
		((ImageView) findViewById(viewId)).setImageDrawable(drawable);
		return this;
	}

	/**
	 * 设置imageview图片
	 * 
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public RecyclerViewBaseViewHolder setImageResource(int viewId, int resId) {
		((ImageView) findViewById(viewId)).setImageResource(resId);
		return this;
	}

	/**
	 * 设置imageview图片
	 * 
	 * @param viewId
	 * @param uri
	 * @return
	 */
	public RecyclerViewBaseViewHolder setImageURI(int viewId, Uri uri) {
		((ImageView) findViewById(viewId)).setImageURI(uri);
		return this;
	}

	/**
	 * 设置imageview图片
	 * 
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public RecyclerViewBaseViewHolder setBackgroundResource(int viewId, int resId) {
		((ImageView) findViewById(viewId)).setBackgroundResource(resId);
		return this;
	}



}
