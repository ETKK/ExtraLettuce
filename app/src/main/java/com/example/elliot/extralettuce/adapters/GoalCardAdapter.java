package com.example.elliot.extralettuce.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.elliot.extralettuce.R;
import com.example.elliot.extralettuce.dataClasses.Goal;
import com.example.elliot.extralettuce.support._HelperFunctions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class GoalCardAdapter extends RecyclerView.Adapter<GoalCardAdapter.ViewHolder> {
    private List<Goal> goalList;

    public GoalCardAdapter(List<Goal> goals) {
        goalList = goals;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goal_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mItem = goalList.get(position);
        holder.mPos.setText(Integer.toString(position + 1));
        holder.mGoalName.setText(holder.mItem.getGoalName());
        holder.mGoalAmount.setText(_HelperFunctions.getMoneyString(holder.mItem.getGoalAmount()));
        holder.mProgressBar.setProgress((holder.mItem.getCurrentBal() / holder.mItem.getGoalAmount()) * 100);
    }

    @Override
    public int getItemCount() {
        return goalList != null ? goalList.size() : 0;
    }


    public void addGoal(Goal goal) {
        goalList.add(goal);
        sortList();
        notifyDataSetChanged();
    }

    public void removeGoal(int pos) {
        goalList.remove(pos);
        notifyDataSetChanged();
    }

    public void setGoalList(List<Goal> goalList) {
        this.goalList = goalList;
    }

    private void sortList() {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        protected Goal mItem;
        protected TextView mPos, mGoalName, mGoalAmount;
        protected ProgressBar mProgressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            mPos = (TextView) itemView.findViewById(R.id.position_text);
            mGoalName = (TextView) itemView.findViewById(R.id.goalName);
            mGoalAmount = (TextView) itemView.findViewById(R.id.goal_money);
            mProgressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }

}
