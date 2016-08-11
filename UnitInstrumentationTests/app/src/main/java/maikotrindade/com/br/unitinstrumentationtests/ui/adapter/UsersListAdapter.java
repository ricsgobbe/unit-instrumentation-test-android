package maikotrindade.com.br.unitinstrumentationtests.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;

/**
 * Created by joao on 8/11/16.
 */
public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {

    private List<User> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ViewHolder(View v){
            super(v);
            mView = v;
        }
    }

    public UsersListAdapter(List<User> myDataset) {
        updateDataset(myDataset);
    }

    public void updateDataset(List<User> myDataset){
        if( myDataset == null ) {
            myDataset = new ArrayList<>();
        }
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_user, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textView = (TextView) holder.mView.findViewById(R.id.user_name);
        textView.setText("("+position+"): "+mDataset.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}