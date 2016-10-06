import com.example.stockquote_xsd.*;
import com.example.stockquote_wsdl.*;
import java.net.URL;

public class StockQuoteClient {

public static void main(String[]args){
  if(args.length==0){
    System.out.println("usage: StockQuoteClient sym [ http://... ]");
    return;
    }
  String sym=args[0];
  String uriStr="http://localhost:8080/axis/services/StockQuotePort";
  if(args.length > 1) uriStr=args[1];

  try{
    System.out.println("seeking "+sym+" price at "+ uriStr);
    URL url=new URL(uriStr);
    StockQuoteServiceLocator sL=new StockQuoteServiceLocator();
    StockQuotePortType serv = sL.getStockQuotePort(url);
    _TradePriceRequest tpr = new _TradePriceRequest();
    tpr.setTickerSymbol(sym);
    _TradePrice tP = serv.getLastTradePrice(tpr);
    float res=tP.getPrice();
    System.out.println(uriStr+"\n  ... says that "+sym+" price is "+res);
  }catch(Exception ex){ex.printStackTrace();}
}

}
