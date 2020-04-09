package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
            protected void onBindViewHolder(@NonNull AdminOrdersViewHolder holder, int i, @NonNull AdminOrders model) {

                holder.userName.setText( "Name: " + model.getName());
                holder.userPhoneNumber.setText( "phone: " + model.getPhone());
                holder.userTotalPrice.setText( "Total Amount: " + model.getTotalAmount());
                holder.userDateTime.setText( "Order at: " + model.getDate()+ " " + model.getTime());
                holder.userShippingAddress.setText( "Shipping Address: " + model.getAddress()+ ", " + model.getCity());
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
}
