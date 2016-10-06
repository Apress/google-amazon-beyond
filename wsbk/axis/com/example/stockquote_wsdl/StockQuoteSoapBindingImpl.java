/**
 * StockQuoteSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.example.stockquote_wsdl;

public class StockQuoteSoapBindingImpl implements com.example.stockquote_wsdl.StockQuotePortType{
    public com.example.stockquote_xsd._TradePrice getLastTradePrice(com.example.stockquote_xsd._TradePriceRequest body) throws java.rmi.RemoteException {
      String stockSym=body.getTickerSymbol();
      com.example.stockquote_xsd._TradePrice tP= new com.example.stockquote_xsd._TradePrice();
      tP.setPrice(stockSym.length());
      return tP;
    }

}
