package com.example.amazonagencytt.model.report.salesandtrafficbyasin;

import com.example.amazonagencytt.model.report.salesandtrafficbydate.OrderedProductSalesB2B;
import lombok.Data;

@Data
public class SalesByAsin {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
}
