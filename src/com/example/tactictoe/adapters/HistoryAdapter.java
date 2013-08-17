package com.example.tactictoe.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tactictoe.R;
import com.example.tactictoe.model.History;

public class HistoryAdapter extends BaseAdapter {

	private List<History> list;
	private LayoutInflater mInflater;

	public HistoryAdapter(Context context, List<History> listHistories) {
		this.list = listHistories;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return this.list.size();
	}

	@Override
	public Object getItem(int position) {
		return this.list.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.history_item, null);
			holder.tvFirstSign = (TextView) convertView
					.findViewById(R.id.item_tvFirstSign);
			holder.tvSequenceStep = (TextView) convertView
					.findViewById(R.id.item_tvSequenceStep);
			holder.tvWinSign = (TextView) convertView
					.findViewById(R.id.item_tvWinSign);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		History model = this.list.get(position);
		holder.tvFirstSign.setText(model.getFirstSign());
		holder.tvWinSign.setText(model.getWinSign());
		holder.tvSequenceStep.setText(model.getSequenceStep());

		return convertView;
	}

	private static class ViewHolder {
		TextView tvFirstSign;
		TextView tvWinSign;
		TextView tvSequenceStep;
	}

}
