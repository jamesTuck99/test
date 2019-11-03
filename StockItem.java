/*
  This is the base class that all of the stock items will be based upon
 */
package carsales;

/**
 *
 * @author James/Lloyd
 */
public class StockItem {
    
private String stockName;
private String stockCode;

private int stockQuantity;

private float stockPriceNoVat;
private float stockPriceVat;

private String stockDescription;

public StockItem(String name,String code, int quantity, String description,float priceNoVat){ //constructor
    stockName = name;
    stockQuantity = quantity;
    stockDescription = description;
    stockCode = code;
    stockPriceNoVat = priceNoVat;
    stockPriceVat = (float) (1.2*priceNoVat);
}

        
public String GetStockName(){ //gets stock name
    if(stockName==null){
        return("Unknown stock name");
    }
    else{
         return(stockName);
    }
}

public void SetStockName(String newStockName) //sets stock name
{
    this.stockName = newStockName;
}

public String GetStockCode(){ //gets stock code
    if(stockCode==null){
        return("Unknown stock code");
    }
    else{
         return(stockCode);
    }
}

public void SetStockCode(String newStockCode)  // sets stock code
{
    this.stockCode = newStockCode;
}

public String GetStockDescription(){//gets stock description
    if(stockDescription==null){
        return("No stock description found");
    }
    else{
        return(stockDescription);
    }
}

public void SetStockDescription(String newDescription){
    this.stockDescription = newDescription;
}
 
 public int sellItem(int saleQuantity){
    if(saleQuantity>1){
       if(stockQuantity-saleQuantity<1)
       {
           System.out.println("Unable to sell "+ saleQuantity+" of this item as we do not have enough in stock");
       }
       else{
           stockQuantity =- saleQuantity;
       }
     }
    else{
        System.out.println("Unable to complete this transaction as you can not sell an item of stock by less than one");
    }
    
     return(stockQuantity);
 }
 
  public int addItem(int quantity){
     if(quantity>1){
        if(stockQuantity+quantity>100){
            System.out.println("Unable to complete order as this would exceed our storage limit for this item");
        }
        else{
            stockQuantity =+ quantity;
        }
     }
     else{
         System.out.println("Unable to complete this transaction as you can not increase stock by less than one");
     }
     return(stockQuantity);
 }
  
  public float getVatPrice(){
      return stockPriceVat;
}
  
  public void setPrice(float newNoVatPrice){
      this.stockPriceNoVat = newNoVatPrice;
      this.stockPriceVat = (float) (newNoVatPrice*1.2);
  }
  
  public float getNoVatPrice(){
      return stockPriceNoVat;
}
  
  
}
