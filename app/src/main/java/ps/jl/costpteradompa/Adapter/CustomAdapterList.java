package ps.jl.costpteradompa.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import ps.jl.costpteradompa.Model.ModelListItem;
import ps.jl.costpteradompa.R;

/**
 * Created by Lenovo on 30-09-2017.
 */

public class CustomAdapterList extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ModelListItem> modellist;//model ที่สร้าง
    private Context context;

    //Constructor
    public CustomAdapterList(List<ModelListItem> modellist, Context context) {
        this.modellist = modellist;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //สร้าง View เพื่อใช้แสดง itemView ที่เรา สร้าง
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_view,parent,false);
        return new ViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //update Adapter
        ModelListItem modelListItem = modellist.get(position);

        ViewItemHolder viewItemHolder = (ViewItemHolder) holder;
        viewItemHolder.tv_FName.setText(modelListItem.getF_Name());
        viewItemHolder.tv_LName.setText(modelListItem.getL_Name());
    }

    @Override
    public int getItemCount() {

        //return ตามขนาดของ model ที่เราสร้าง
        return modellist.size();
    }

    //สร้าง Class ในการเก็บ itemView ที่ใช้ แสดงใน Listview
    static class ViewItemHolder extends RecyclerView.ViewHolder{
        private TextView tv_FName,tv_LName;
        public ViewItemHolder(View itemView) {
            super(itemView);
            tv_FName = (TextView) itemView.findViewById(R.id.tv_FName);
            tv_LName = (TextView) itemView.findViewById(R.id.tv_LName);
        }
    }
}
