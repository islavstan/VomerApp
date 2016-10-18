package com.islavdroid.vomerapp;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface.OnClickListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SwipeRecyclerViewAdapter extends RecyclerSwipeAdapter<SwipeRecyclerViewAdapter.SimpleViewHolder> {

    final int DELETE_DIALOG = 1;
    private Context mContext;
    private ArrayList<Users> eList;
    AlertDialog.Builder adb;
    AlertDialog alert;
    OnClickListener myClickListener;
    View viewTitle;

    public SwipeRecyclerViewAdapter(Context context, ArrayList<Users> objects) {
        this.mContext = context;
        this.eList = objects;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_list, parent, false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position) {
        //final Student item = studentList.get(position);

       // viewHolder.tvName.setText((item.getName()) + "  -  Row Position " + position);
       // viewHolder.tvEmailId.setText(item.getEmailId());
        viewHolder.name.setText(eList.get(position).getName());
        viewHolder.description.setText(eList.get(position).getMessage());
        viewHolder.image.setImageResource(eList.get(position).getPhoto());

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        // Drag From Left
       // viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper1));

        // Drag From Right
        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper));


        // Handling different events when swiping
        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                //when the SurfaceView totally cover the BottomView.
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                //you are swiping.
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                //when the BottomView totally show.
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                //when user's hand released.
            }
        });

        /*viewHolder.swipeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((((SwipeLayout) v).getOpenStatus() == SwipeLayout.Status.Close)) {
                    //Start your activity

                    Toast.makeText(mContext, " onClick : " + item.getName() + " \n" + item.getEmailId(), Toast.LENGTH_SHORT).show();
                }

            }
        });*/

      /*  viewHolder.swipeLayout.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " onClick : " + item.getName() + " \n" + item.getEmailId(), Toast.LENGTH_SHORT).show();
            }
        });*/


        /*viewHolder.btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Clicked on Map " + viewHolder.tvName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/


        viewHolder.tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,UserInfo.class);
                mContext.startActivity(intent);

             //   Toast.makeText(view.getContext(), "Info " + viewHolder.name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

     /*   viewHolder.tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "Clicked on Edit  " + viewHolder.tvName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/



        viewHolder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                mItemManger.removeShownLayouts(viewHolder.swipeLayout);
                                eList.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, eList.size());
                                mItemManger.closeAllItems();
                               // Toast.makeText(mContext, "Deleted " + viewHolder.name.getText().toString(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(mContext, "Контакт удалён", Toast.LENGTH_SHORT).show();

                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                viewTitle = LayoutInflater.from(mContext).inflate(R.layout.title_for_delete_dialog,null);
                //builder.setTitle("Удалить");

                builder.setCustomTitle(viewTitle);
               // builder.setIcon(R.drawable.ic_delete_white_24dp);
                builder.setMessage("Вы уверены, что хотите удалить контакт?").setPositiveButton("Да", dialogClickListener)
                        .setNegativeButton("Отмена", dialogClickListener);
                AlertDialog dialog = builder.create();
                dialog.show();
                Button button = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
// Customize the button
                button.setTextColor(Color.BLACK);
              //  button.setTypeface(Typeface.DEFAULT_BOLD);
                Button button2 = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                button2.setTextColor(Color.BLACK);




               /* mItemManger.removeShownLayouts(viewHolder.swipeLayout);
                eList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, eList.size());
                mItemManger.closeAllItems();
                Toast.makeText(view.getContext(), "Deleted " + viewHolder.name.getText().toString(), Toast.LENGTH_SHORT).show();*/
            }
        });




        // mItemManger is member in RecyclerSwipeAdapter Class
        mItemManger.bindView(viewHolder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return eList.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }





    //  ViewHolder Class

    public static class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        SwipeLayout swipeLayout;
        public CircleImageView image;
        public TextView name;
        public TextView description;
        ImageButton tvDelete;
        ImageButton tvInfo;


        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            image=(CircleImageView)itemView.findViewById(R.id.user_image);
            name=(TextView)itemView.findViewById(R.id.user_name);
            description=(TextView)itemView.findViewById(R.id.user_message);
            tvDelete = (ImageButton) itemView.findViewById(R.id.tvDel);
            tvInfo = (ImageButton) itemView.findViewById(R.id.tvInfo);
            itemView.setOnClickListener(this);


        }
        @Override
        public void onClick(View v) {
          // Toast.makeText(v.getContext(),"нажали",Toast.LENGTH_SHORT).show();

        }

    }

}