package com.heiko.mediatorpattern;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AbstractMediator mediator = new Mediator();
                //采购人员采购电脑
                System.out.println("-----采购人员采购电脑------");
                Purchase purchase = new Purchase(mediator);
                purchase.buyIBMcomputer(100);

                //销售人员销售电脑
                System.out.println("-----销售人员销售电脑-----");
                Sale sale = new Sale(mediator);
                sale.sellIBMComputer(1);

                //库房管理人员管理库存
                System.out.println("-----库房管理人员清库管理-----");
                Stock stock = new Stock(mediator);
                stock.clearStock();
            }
        });
    }
}
