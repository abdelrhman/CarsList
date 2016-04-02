package com.podo.carslist;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.podo.carslist.model.Car;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CarDetailsActivity extends AppCompatActivity {


    @Bind(R.id.car_image)
    ImageView carImage;

    @Bind(R.id.tv_model)
    TextView tvModel;

    @Bind(R.id.tv_manufacturer)
    TextView tvManufacturer;

    @Bind(R.id.tv_engineSize)
    TextView tvEngineSize;

    @Bind(R.id.tv_speed)
    TextView tvSpeed;

    @Bind(R.id.tv_acceleration)
    TextView tvAcceleration;


    private Car mCar;
    protected static final String TAG = "CarDetails";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        ButterKnife.bind(this);
        mCar = (Car) getIntent().getSerializableExtra("car");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Picasso.with(this).load(mCar.getThumbnailLarge()).into(carImage);
        tvModel.setText(mCar.getModel());
        tvManufacturer.setText("Manufacturer: "+mCar.getManufacturer());
        tvSpeed.setText("Max Speed: "+ mCar.getSpeed());
        tvAcceleration.setText("Acceleration from 0-100 in "+ mCar.getAcceleration()+" Seconds" );
        tvEngineSize.setText("Engine Size: "+ mCar.getAcceleration()+" L" );



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
