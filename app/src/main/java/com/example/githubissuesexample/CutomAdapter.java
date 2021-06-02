package com.example.githubissuesexample;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class CutomAdapter extends RecyclerView.Adapter<CutomAdapter.CustomViewHolder> {

    private List<Issues> datalist;

    private Context context;
    private String commentUrl;




    public CutomAdapter(List<Issues> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }


    @Override
    public CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.issue_tile, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CutomAdapter.CustomViewHolder holder, int position) {
        holder.title.setText(datalist.get(position).getTitle());
        holder.body.setText(Html.fromHtml(datalist.get(position).getBody()));
       // holder.comment.setText(datalist.get(position).getCommentURL());
        commentUrl= datalist.get(position).getCommentURL();
        //commentUrl=  holder.comment.getText().toString();

        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] var = commentUrl.split(".com");

                Intent intent = new Intent(context, Dest.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("message", commentUrl);
               context.startActivity(intent);



             /*   GetDataService service = RetrofitClient.getRetrofit().create(GetDataService.class);


                Call<List<Comments>> call = service.getAllComments(var[1]);
                call.enqueue(new Callback<List<Comments>>() {
                    @Override
                    public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                        /*Intent intent = new Intent(context, Dest.class);
                        intent.putExtra("message", var[1]);
                        context.startActivity(intent);
                        Toast.makeText(context,"responce",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<Comments>> call, Throwable t) {
                        Toast.makeText(context,"fail",Toast.LENGTH_LONG).show();
                    }
                });*/


            }
        });





    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
         private View mview;
         private TextView title;
         private TextView body;






        public CustomViewHolder( View itemView) {
            super(itemView);
            mview= itemView;

            title= mview.findViewById(R.id.issuetitle);
            body=mview.findViewById(R.id.issuebody);
           // comment=mview.findViewById(R.id.comment);



        }
    }
}
