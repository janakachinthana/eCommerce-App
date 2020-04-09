package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecommerce.Model.AdminOrders;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdimnNewOrderActivity extends AppCompatActivity {

    private RecyclerView orderList;
    private DatabaseReference orderRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_adimn_new_order );

        orderRef = FirebaseDatabase.getInstance().getReference().child( "Orders" );
        orderList = findViewById( R.id.order_list );
        orderList.setLayoutManager( new LinearLayoutManager( this ) );

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<AdminOrders> options = new FirebaseRecyclerOptions.Builder<AdminOrders>()
                .setQuery( orderRef, AdminOrders.class )
                .build();

        FirebaseRecyclerAdapter<AdminOrders, AdminOrdersViewHolder> adapter =
        new FirebaseRecyclerAdapter<AdminOrders, AdminOrdersViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AdminOrdersViewHolder holder, final int position, @NonNull AdminOrders model) {

                holder.userName.setText( "Name: " + model.getName());
                holder.userPhoneNumber.setText( "phone: " + model.getPhone());
                holder.userTotalPrice.setText( "Total Amount: " + model.getTotalAmount());
                holder.userDateTime.setText( "Order at: " + model.getDate()+ " " + model.getTime());
                holder.userShippingAddress.setText( "Shipping Address: " + model.getAddress()+ ", " + model.getCity());

                holder.ShowOrdersBtn.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String uID = getRef( position ).getKey();

                        Intent intent = new Intent( AdimnNewOrderActivity.this, AdminUserProductActivity.class );
                        intent.putExtra( "uid", uID );
                        startActivity( intent );
                    }
                } );


                    holder.itemView.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            CharSequence options[] = new CharSequence[]
                                    {
                                            "Yes",
                                            "No"
                                    };

                            AlertDialog.Builder builder = new AlertDialog.Builder( AdimnNewOrderActivity.this );
                            builder.setTitle( "Have you shipped this order product...?" );

                            builder.setItems( options, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {

                                    if (i == 0)
                                    {

                                        String uID = getRef( position ).getKey();

                                        RemoveOrder(uID);
                                    }
                                    else
                                    {
                                        finish();
                                    }
                                }
                            } );


                            builder.show();

                        }
                    } );


            }

            @NonNull
            @Override
            public AdminOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.orders_layout, parent, false);
                return  new  AdminOrdersViewHolder(view  );
            }
        };

        orderList.setAdapter( adapter );
        adapter.startListening();
    }



    public static class AdminOrdersViewHolder extends RecyclerView.ViewHolder
    {

        public TextView userName, userPhoneNumber, userTotalPrice, userDateTime, userShippingAddress;
        public Button ShowOrdersBtn;

        public AdminOrdersViewHolder(@NonNull View itemView) {
            super( itemView );


            userName = itemView.findViewById( R.id.order_user_name );
            userPhoneNumber = itemView.findViewById( R.id.order_phone_number );
            userTotalPrice = itemView.findViewById( R.id.order_total_price );
            userDateTime = itemView.findViewById( R.id.order_date_time );
            userShippingAddress = itemView.findViewById( R.id.order_address_city );
            ShowOrdersBtn = itemView.findViewById( R.id.show_all_product_btn );
        }
    }


    private void RemoveOrder(String uID) {

        orderRef.child( uID ).removeValue();
    }
}
